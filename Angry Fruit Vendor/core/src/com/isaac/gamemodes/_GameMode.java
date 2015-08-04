package com.isaac.gamemodes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.gamemodes.levels._Level;
import com.isaac.gameobjects.AddALife;
import com.isaac.gameobjects.FallingObject;
import com.isaac.gameobjects.FruitVendor;
import com.isaac.gameobjects.Trampoline;
import com.isaac.gameobjects.fruits.Apple;
import com.isaac.gameobjects.fruits.Banana;
import com.isaac.gameobjects.fruits.Basket;
import com.isaac.gameobjects.fruits.Fruit;
import com.isaac.gameobjects.fruits.Orange;
import com.isaac.gameobjects.fruits.RottenFruit;
import com.isaac.gameobjects.fruits.Watermelon;
import com.isaac.helpers.GameValues;
import com.isaac.helpers.UserData;
import com.isaac.screens.GameScreen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by Isaac Holloway on 12/9/2014.
 */
public abstract class _GameMode {
    /**
     * Here is all of the logic related to the actual gameplay
     * (The GameScreen will handle any user input)
     */

    protected abstract void createLevelPool();
    private int currentStreak;
    public float totalGameTime;

    public float currentFruitTossInterval;
    public float timeUntilNextFruitToss;

    public float currentObjFallInterval;
    public float timeUntilNextObjFall;

    protected final String SCORE_PREFIX = "Score:  ";
    protected final String LIVES_PREFIX = "Lives:  ";
    protected final String STREAK_PREFIX = "Streak:  ";
    private int score;
    private int livesLeft;

    private Array<Fruit> activeFruits;
    private Array<FallingObject> fallingObjects;
    private Trampoline trampoline;
    private FruitVendor fruitVendor;

    protected float startFruitTossInterval_Low = 1000;
    protected float startFruitTossInterval_High = 2000;

    protected float startObjFallInterval_Low = 20000;
    protected float startObjFallInterval_High = 50000;

    protected List<_Level> levels;
    protected int currentLevelIndex;

    protected GameScreen gameScreen;

    /** [CONSTRUCTOR] */
    public _GameMode(GameScreen gameScreen){
        this.gameScreen = gameScreen;
        activeFruits = new Array<Fruit>();
        fallingObjects = new Array<FallingObject>();
        trampoline = new Trampoline();
        fruitVendor = new FruitVendor();
        setLevels(new ArrayList<_Level>());
        createLevelPool();
    }

    /***/
    public void init(){
        restartLevel();
    }

    /***/
    public void update(float delta) {
        // This will cap the FPS at 60
        if (delta > .15f) {
            delta = .15f;
        }

        totalGameTime += delta;

        // Checks to see if our Angry Fruit Vendor tosses the fruit!
        tossFruit(delta);

        // Checks to see if a power up can fall from the sky
        fallFromTheSky(delta);

        getTrampoline().update(delta);

        // If you want to free dead fruits, returning them to the pool:
        Fruit fruit;
        int len = activeFruits.size;
        for (int i = len; --i >= 0; ) {
            fruit = activeFruits.get(i);

            // Update the fruits
            fruit.update(delta);

            if (fruit.isAlive == false) {
                activeFruits.removeIndex(i);
            }
        }

        // Falling Objects
        FallingObject fallingObject;
        int faLen = fallingObjects.size;
        for (int i = faLen ; --i >= 0; ) {
            fallingObject = fallingObjects.get(i);

            // Update the fallingObject
            fallingObject.update(delta);

            if (fallingObject.isAlive == false) {
                fallingObjects.removeIndex(i);
            }
        }

        getCurrentLevel().update(delta);
    }

    /***/
    public void initLevel(){
        activeFruits.clear();
        this.totalGameTime = 0;
        this.score = 0;
        this.currentStreak = 0;
        createNewFruitTossInterval();
        createNewObjFallInterval();
        trampoline.init();
    }

    /***/
    public void renderGameMode(float delta, SpriteBatch batch) {
        getCurrentLevel().drawLevel(delta, batch);
    }

    /***/
    public void renderGameModeBG(float delta, SpriteBatch batch) {
        getCurrentLevel().drawLevelBG(delta, batch);
    }
    /***/
    public void setCurrentLevel(int index) {
        initLevel();
        this.setCurrentLevelIndex(index);
        this.getCurrentLevel().init();
    }

    /***/
    protected void createNewFruitTossInterval() {
        currentFruitTossInterval = 0;
        timeUntilNextFruitToss = MathUtils.random(getCurrentFruitTossInterval_Low(), getCurrentFruitTossInterval_High());
    }

    /***/
    protected void createNewObjFallInterval(){
        currentObjFallInterval = 0;
        timeUntilNextObjFall = MathUtils.random(getCurrentObjFallInterval_Low(),getCurrentObjFallInterval_High());
    }

    /**
     * createFruitsFromBasket
     */
    public void createFruitsFromBasket(float startingX, float startingY){

        // Amount of fruits bouncing out of the basket
        int randFruitInBasket = MathUtils.random(1, 3);

        // Apple = 1
        // Orange = 2
        // Watermelon = 3
        // Banana = 4
        List<Integer> availableFruitInts = new ArrayList();
        Collections.addAll(availableFruitInts, 1, 2, 3, 4);

        for (int i = 1; i <= randFruitInBasket;i++ ) {
            int randFruitInt = MathUtils.random(0, availableFruitInts.size()-1);
            int getFruitIntFromList = availableFruitInts.get(randFruitInt);
            Fruit newFruit;
            switch (getFruitIntFromList) {
                case 1:
                    newFruit = new Apple(this);
                    break;
                case 2:
                    newFruit = new Orange(this);
                    break;
                case 3:
                    newFruit = new Watermelon(this);
                    break;
                default:
                    newFruit = new Banana(this);
                    break;
            }

            // Initialize and add the new fruit
            newFruit.spawnFromBasket(startingX, startingY);
            activeFruits.add(newFruit);

            // Remove the randomFruitInt we just grabbed from the list so we don't have 2 oranges popping out.
            availableFruitInts.remove(randFruitInt);
        }
    }

    /***/
    protected void tossFruit(float delta) {
        currentFruitTossInterval += delta * 1000;
        if (currentFruitTossInterval > timeUntilNextFruitToss) {
            Fruit newFruit = getRandomFruit();
            newFruit.spawn(GameValues.FRUIT_STARTING_X, GameValues.FRUIT_STARTING_Y);
            activeFruits.add(newFruit);
            createNewFruitTossInterval();
        }
    }

    /***/
    protected void fallFromTheSky(float delta){
        currentObjFallInterval += delta * 1000;
        if (currentObjFallInterval > timeUntilNextObjFall) {

            // Spawn a power up!
            AddALife aal = new AddALife(this);
            aal.spawn(getRandomTrampolinePosition());
            fallingObjects.add(aal);
            createNewObjFallInterval();
        }
    }

    /***/
    protected Trampoline.TrampolinePosition getRandomTrampolinePosition(){
        int randPosIndex = MathUtils.random(1,3);
        switch (randPosIndex){
            case 1:
                return Trampoline.TrampolinePosition.Position1;
            case 2:
                return Trampoline.TrampolinePosition.Position2;
            default:
                return Trampoline.TrampolinePosition.Position3;
        }
    }

    /***/
    public Fruit getRandomFruit() {
        Fruit.FruitType selectedFruitType = null;
        Integer randFruitIndex = MathUtils.random(0, 100);
        int percentageSum = 0;
        for (Map.Entry<Fruit.FruitType, Integer> entry : getCurrentLevel().getAllowedFruits().entrySet()) {
            Integer percentage = entry.getValue();
            if (randFruitIndex >= percentageSum
                    && randFruitIndex <= (percentage + percentageSum)) {
                selectedFruitType = entry.getKey();
                break;
            }
            percentageSum += percentage;
        }
        return getFruitGivenType(selectedFruitType);
    }

    /***/
    public void levelComplete() {
        if (getCurrentLevelIndex() == getLevels().size() - 1) {
            // All Levels completed
            gameScreen.setGameScreenMenu(gameScreen.allLevelCompleteMenu);
        } else {
            // Update the user data to set the new highest level completed.
            UserData.setHighestLevelCompleted(getCurrentLevelIndex() + 1);

            // Show the LevelCompleteMenu
            gameScreen.setGameScreenMenu(gameScreen.levelCompleteMenu);
        }
    }

    /***/
    public void levelFail() {
        // Show the LevelCompleteMenu
        gameScreen.setGameScreenMenu(gameScreen.levelFailedMenu);
    }

    /***/
    public void advanceCurrentLevel() {
        if(getCurrentLevelIndex() >= levels.size()-1 ){
            setCurrentLevel(0);
        }else{
            setCurrentLevel(getCurrentLevelIndex() + 1);
        }
    }

    /***/
    public void restartLevel() {
        //initLevel();
        setCurrentLevel(this.getCurrentLevelIndex());
    }

    /***/
    public Fruit getFruitGivenType(Fruit.FruitType fruitType){
        Fruit fruit = null;
        switch (fruitType){
            case Apple:
                fruit = new Apple(this);
                break;

            case Banana:
                fruit = new Banana(this);
                break;

            case Basket:
                fruit = new Basket(this);
                break;

            case Orange:
                fruit = new Orange(this);
                break;

            case RottenFruit:
                fruit = new RottenFruit(this);
                break;

            case Watermelon:
                fruit = new Watermelon(this);
                break;

            case All:
                break;
        }
        return fruit;
    }

    /***/
    protected _Level getCurrentLevel() {
        return getLevels().get(getCurrentLevelIndex());
    }

    public int getCurrentLevelIndex() {
        return currentLevelIndex;
    }

    public void setCurrentLevelIndex(int currentLevelIndex) {
        this.currentLevelIndex = currentLevelIndex;
    }

    public List<_Level> getLevels() {
        return levels;
    }

    public void setLevels(List<_Level> levels) {
        this.levels = levels;
    }
    public float getCurrentFruitTossInterval_Low() {
        if(AngryFVGame.DEV_MODE){
            //return 10000;
        }
        return startFruitTossInterval_Low;
    }

    public float getCurrentFruitTossInterval_High() {
        if(AngryFVGame.DEV_MODE){
            //return 10000;
        }
        return startFruitTossInterval_High;
    }

    public float getCurrentObjFallInterval_Low() {
        if(AngryFVGame.DEV_MODE){
            //return 10000;
        }
        return startObjFallInterval_Low;
    }

    public float getCurrentObjFallInterval_High() {
        if(AngryFVGame.DEV_MODE){
            //return 10000;
        }
        return startObjFallInterval_High;
    }

    /***/
    public int getLivesLeft(){
        return this.livesLeft;
    }

    /***/
    public String getDisplayedLivesText(){
        return LIVES_PREFIX + getLivesLeft();
    }

    /***/
    public String getDisplayedStreakText(){
        return STREAK_PREFIX + getCurrentStreak();
    }

    /***/
    public void subtractLivesLeft(int subAmount){
        this.livesLeft -= subAmount;
    }

    /***/
    public void setLivesLeft(int newLivesLeft){
        this.livesLeft = newLivesLeft;
    }

    /***/
    public void addToStreak(){
        currentStreak += 1;
    }

    /***/
    public void clearStreak(){
        currentStreak = 0;
    }

    /***/
    public int getCurrentStreak(){
        return currentStreak;
    }

    /***/
    public void addFruitScore(int scoreToAdd) {
        score += scoreToAdd;
        addToStreak();
    }

    public int getScore() {
        return score;
    }
    public String getDisplayedScoreText() {
        return SCORE_PREFIX + getScore();
    }

    public void addScore(int increment) {
        score += increment;
    }

    public Array<Fruit> getActiveFruits() {
        return activeFruits;
    }
    public Array<FallingObject> getFallingObjects() {
        return fallingObjects;
    }

    public Trampoline getTrampoline() {
        return trampoline;
    }

    public void setTrampoline(Trampoline trampoline) {
        this.trampoline = trampoline;
    }

    public FruitVendor getFruitVendor() {
        return fruitVendor;
    }
}
