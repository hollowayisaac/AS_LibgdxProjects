//package com.isaac.gameworld;
//
//import com.badlogic.gdx.math.MathUtils;
//import com.badlogic.gdx.utils.Array;
//import com.isaac.gamemodes._GameMode;
//import com.isaac.gameobjects.Trampoline;
//import com.isaac.gameobjects.fruits.Apple;
//import com.isaac.gameobjects.fruits.Banana;
//import com.isaac.gameobjects.fruits.Basket;
//import com.isaac.gameobjects.fruits.Fruit;
//import com.isaac.gameobjects.fruits.Orange;
//import com.isaac.gameobjects.fruits.RottenFruit;
//import com.isaac.gameobjects.fruits.Watermelon;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
///**
// * Created by Isaac Holloway on 11/12/2014.
// */
//public class GameWorldcopy {
//
//    private int currentStreak;
//    public float totalGameTime;
//    protected final String SCORE_PREFIX = "Score:  ";
//    protected final String LIVES_PREFIX = "Lives:  ";
//    protected final String STREAK_PREFIX = "Streak:  ";
//    private int score;
//
//   /* // All of our
//    private List<GameObject> gameObjects;*/
//
//    // array containing the active Fruits.
//    private Array<Fruit> activeFruits;
//    private Trampoline trampoline;
//    protected _GameMode gameMode;
//    public _GameMode getGameMode(){
//        return  gameMode;
//    }
//
//    // How many more fruits is the user aloud to drop
//    private int livesLeft;
//
//    public float currentFruitTossInterval;
//    public float timeUntilNextFruitToss;
//
//    /**
//     * [CONSTRUCTOR]
//     */
//    public GameWorldcopy() {
//        activeFruits = new Array<Fruit>();
//        trampoline = new Trampoline();
//    }
//
//    /**
//     * init
//     *
//     * @param gameMode
//     */
//    public void init(_GameMode gameMode){
//        setGameMode(gameMode);
///*
//        // Create the world and all of its components.
//        initWorld();*/
//    }
//
//    /**
//     * resetWorld
//     */
//    public void resetWorld(){
//        initWorld();
//    }
//
//    /**
//     * initWorld
//     */
//    protected void initWorld() {
//        activeFruits.clear();
//        this.totalGameTime = 0;
//        this.score = 0;
//        createNewFruitTossInterval();
//        trampoline.init();
//    }
//
//    /**
//     * getLivesLeft
//     * @return
//     */
//    public int getLivesLeft(){
//        return this.livesLeft;
//    }
//
//    /**
//     * getDisplayedLivesText
//     * @return
//     */
//    public String getDisplayedLivesText(){
//        return LIVES_PREFIX + getLivesLeft();
//    }
//
//
//    /**
//     * getDisplayedStreakText
//     * @return
//     */
//    public String getDisplayedStreakText(){
//        return STREAK_PREFIX + getCurrentStreak();
//    }
//
//    /**
//     * subtractLivesLeft
//     *
//     * @param subAmount
//     */
//    public void subractLivesLeft(int subAmount){
//        this.livesLeft -= subAmount;
//    }
//
//    /**
//     * setLivesLeft
//     * @param newLivesLeft
//     */
//    public void setLivesLeft(int newLivesLeft){
//        this.livesLeft = newLivesLeft;
//    }
//
//    /**
//     * setGameMode
//     * @param gameMode
//     */
//    private void setGameMode(_GameMode gameMode){
//        this.gameMode = gameMode;
//
//        // TODO: Init the gamemode and here is where the init level is set.
//        this.gameMode.init(this);
//    }
//
//    /**
//     * updateReady
//     *
//     * @param delta
//     */
//    private void updateReady(float delta) {
//        //bird.updateReady(runTime);
//        //scroller.updateReady(delta);
//    }
//
//    /**
//     * updateRunning
//     *
//     * @param delta
//     */
//    public void updateRunning(float delta) {
//        // This will cap the FPS at 60
//        if (delta > .15f) {
//            delta = .15f;
//        }
//
//        totalGameTime += delta;
//
//        tossFruit(delta);
//        getTrampoline().update(delta);
//
//        // If you want to free dead fruits, returning them to the pool:
//        Fruit fruit;
//        int len = activeFruits.size;
//        for (int i = len; --i >= 0; ) {
//            fruit = activeFruits.get(i);
//
//            // Update the fruits
//            fruit.update(delta);
//
//            if (fruit.alive == false) {
//                activeFruits.removeIndex(i);
//            }
//        }
//
//        gameMode.update(delta);
//    }
//
//    /**
//     * tossFruit
//     */
//    protected void tossFruit(float delta) {
//
//        currentFruitTossInterval += delta * 1000;
//        if (currentFruitTossInterval > timeUntilNextFruitToss) {
//            Fruit newFruit = gameMode.getRandomFruit();
//            newFruit.spawn(GameValues.FRUIT_STARTING_X, GameValues.FRUIT_STARTING_Y);
//            activeFruits.add(newFruit);
//            createNewFruitTossInterval();
//        }
//    }
//
//    /**
//     * createFruitsFromBasket
//     */
//    public void createFruitsFromBasket(float startingX, float startingY){
//
//        // Amount of fruits bouncing out of the basket
//        int randFruitInBasket = MathUtils.random(1, 3);
//
//        // Apple = 1
//        // Orange = 2
//        // Watermelon = 3
//        // Banana = 4
//        List<Integer> availableFruitInts = new ArrayList();
//        Collections.addAll(availableFruitInts, 1,2,3,4);
//
//        for (int i = 1; i <= randFruitInBasket;i++ ) {
//            int randFruitInt = MathUtils.random(0, availableFruitInts.size()-1);
//            int getFruitIntFromList = availableFruitInts.get(randFruitInt);
//            Fruit newFruit;
//            switch (getFruitIntFromList) {
//                case 1:
//                    newFruit = new Apple(this);
//                    break;
//                case 2:
//                    newFruit = new Orange(this);
//                    break;
//                case 3:
//                    newFruit = new Watermelon(this);
//                    break;
//                default:
//                    newFruit = new Banana(this);
//                    break;
//            }
//
//            // Initialize and add the new fruit
//            newFruit.spawnFromBasket(startingX, startingY);
//            activeFruits.add(newFruit);
//
//            // Remove the randomFruitInt we just grabbed from the list so we don't have 2 oranges popping out.
//            availableFruitInts.remove(randFruitInt);
//        }
//    }
//
///*    *//**
//     * getRandomFruit
//     *//*
//    protected Fruit getRandomFruit() {
//        int randFruitInt = MathUtils.random(1, 6);
//*//*        if(AngryFVGame.DEV_MODE){
//          randFruitInt = 3;
//        }*//*
//        switch (randFruitInt) {
//            case 1:
//                return new Apple(this);
//            case 2:
//                return new Orange(this);
//            case 3:
//                return new Banana(this);
//            case 4:
//                return new RottenFruit(this);
//            case 5:
//                return new Basket(this);
//            default:
//                return new Watermelon(this);
//        }
//    }*/
//
//    /***/
//    protected void createNewFruitTossInterval() {
//        currentFruitTossInterval = 0;
//        timeUntilNextFruitToss = MathUtils.random(gameMode.getCurrentFruitTossInterval_Low(), gameMode.getCurrentFruitTossInterval_High());
//    }
//
//    /***/
//    public void addToStreak(){
//        currentStreak += 1;
//    }
//
//
//    /***/
//    public void clearStreak(){
//        currentStreak = 0;
//    }
//
//    /***/
//    public int getCurrentStreak(){
//        return currentStreak;
//    }
//
//    /***/
//    public Fruit getFruitGivenType(Fruit.FruitType fruitType){
//        Fruit fruit = null;
//        switch (fruitType){
//            case Apple:
//                fruit = new Apple(this);
//                break;
//
//            case Banana:
//                fruit = new Banana(this);
//                break;
//
//            case Basket:
//                fruit = new Basket(this);
//                break;
//
//            case Orange:
//                fruit = new Orange(this);
//                break;
//
//            case RottenFruit:
//                fruit = new RottenFruit(this);
//                break;
//
//            case Watermelon:
//                fruit = new Watermelon(this);
//                break;
//
//            case All:
//                break;
//        }
//        return fruit;
//    }
//
//    /***/
//    public void addFruitScore(int scoreToAdd) {
//        score += scoreToAdd;
//        addToStreak();
//    }
//
//    public int getScore() {
//        return score;
//    }
//    public String getDisplayedScoreText() {
//        return SCORE_PREFIX + getScore();
//    }
//
//    public void addScore(int increment) {
//        score += increment;
//    }
//
//    public Array<Fruit> getActiveFruits() {
//        return activeFruits;
//    }
//
//    public Trampoline getTrampoline() {
//        return trampoline;
//    }
//
//    public void setTrampoline(Trampoline trampoline) {
//        this.trampoline = trampoline;
//    }
//
//}
