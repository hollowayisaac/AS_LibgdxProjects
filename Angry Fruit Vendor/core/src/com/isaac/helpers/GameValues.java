package com.isaac.helpers;

/**
 * Created by Isaac Holloway on 11/16/2014.
 */
public class GameValues {

    // Screen
    public static final int GAME_WIDTH = 640;
    public static final int GAME_HEIGHT = 360;
    public static final float GAME_X = 0;
    public static final float GAME_Y = 0;
    public static float GAME_SIZE_RATIO = GAME_WIDTH / GAME_HEIGHT;

    // Trampoline
    public static float TRAMPOLINE_WIDTH = GAME_WIDTH * .15f;
    public static float TRAMPOLINE_HEIGHT = GAME_HEIGHT * .07f;
    public static float TRAMPOLINE_Y = GAME_HEIGHT * .19f;

    // Trampoline positions (center)
    public static float TRAMPOLINE_CENTER_POSITION_X_1 = GAME_WIDTH * .28f;
    public static float TRAMPOLINE_CENTER_POSITION_X_2 = GAME_WIDTH * .47f;
    public static float TRAMPOLINE_CENTER_POSITION_X_3 = GAME_WIDTH * .65f;

    // Trampoline Collision locations (y)
    public static float TRAMPOLINE_TOP_COLLISION_Y = TRAMPOLINE_Y + TRAMPOLINE_HEIGHT;
    public static float TRAMPOLINE_BOTTOM_COLLISION_Y = TRAMPOLINE_Y;

    private final static float launchOffset = 1.15f;
    private static final float FRACTION_SMALL = GAME_HEIGHT * .85f;
    private static final float FRACTION_MEDIUM = GAME_HEIGHT * .75f;
    private static final float FRACTION_LARGE = GAME_HEIGHT * .65f;
    public static final int SMALL_PEAK = (int) (FRACTION_SMALL / launchOffset);
    public static final int MEDIUM_PEAK = (int) (FRACTION_MEDIUM / launchOffset);
    public static final int LARGE_PEAK = (int) (FRACTION_LARGE / launchOffset);

    // Fruits
    public static final float FRUIT_STARTING_X = GAME_X + 5;
    public static final float FRUIT_STARTING_Y = GAME_Y + 170;
    public static final float SAVED_FRUIT_X = GAME_WIDTH * .835f;
    public static final float SAVED_FRUIT_Y = 0;
    public static final float FRUIT_ROTATION_OFFSET = 3000;

    //// Apple
    private static final float APPLE_WIDTH_PERC = .05f;
    public static final float APPLE_WIDTH = GAME_WIDTH * APPLE_WIDTH_PERC;
    public static final int APPLE_ADDITIONAL_WEIGHT = -20;
    public static final int APPLE_SCORE_VALUE = 1;

    //// Watermelon
    public static final float WATERMELON_WIDTH = GAME_WIDTH * .075f;
    public static final float WATERMELON_HEIGHT = GAME_HEIGHT * .10f;
    public static final int WATERMELON_ADDITIONAL_WEIGHT = -40;
    public static final int WATERMELON_SCORE_VALUE = 1;

    //// Orange
    public static final float ORANGE_WIDTH_PERC = .05f;
    public static final float ORANGE_WIDTH = GAME_WIDTH * ORANGE_WIDTH_PERC;
    public static final int ORANGE_ADDITIONAL_WEIGHT = -10;
    public static final int ORANGE_SCORE_VALUE = 1;

    //// Banana
    public static final float BANANA_WIDTH_PERC = .05f;
    public static final float BANANA_WIDTH = GAME_WIDTH * BANANA_WIDTH_PERC;
    public static final int BANANA_ADDITIONAL_WEIGHT = -10;
    public static final int BANANA_SCORE_VALUE = 1;

    //// Rotten Fruit
    private static final float ROTTEN_WIDTH_PERC = .05f;
    public static final float ROTTEN_WIDTH = GAME_WIDTH * ROTTEN_WIDTH_PERC;
    public static final int ROTTEN_ADDITIONAL_WEIGHT = -50;
    public static final int ROTTEN_SCORE_VALUE = 0;

    //// Basket
    public static final float BASKET_WIDTH_PERC = .05f;
    public static final float BASKET_WIDTH = GAME_WIDTH * BASKET_WIDTH_PERC;
    public static final int BASKET_ADDITIONAL_WEIGHT = -50;
    public static final int BASKET_SCORE_VALUE = 0;

    // Key Locations
    public static final float DROPPED_Y_LOC = GAME_Y + (TRAMPOLINE_BOTTOM_COLLISION_Y / 2);

}
