package com.isaac.helpers;

/**
 * Created by Isaac Holloway on 11/16/2014.
 */
public class GameValues {

    // Screen
    public static final int GAMEUNIT_WIDTH = 640;
    public static final int GAMEUNIT_HEIGHT = 360;
    public static float GAME_SIZE_RATIO = GAMEUNIT_WIDTH / GAMEUNIT_HEIGHT;
    public static final float GAME_MIDPOINT_X = GAMEUNIT_WIDTH / 2;
    public static final float GAME_MIDPOINT_Y = GAMEUNIT_HEIGHT / 2;

    // Top Menu/Ads
    public static final int ARENA_MENU_WIDTH = GAMEUNIT_WIDTH;
    public static final float ARENA_MENU_HEIGHT = GAMEUNIT_HEIGHT * .14f ;

    // Arena
    public static final int ARENA_WIDTH = GAMEUNIT_WIDTH;
    public static final float ARENA_HEIGHT = GAMEUNIT_HEIGHT - ARENA_MENU_HEIGHT;
    public static final int ARENA_X = 0;
    public static final float ARENA_Y = 0;

    // Trampoline
    public static float TRAMPOLINE_WIDTH = ARENA_WIDTH * .15f;
    public static float TRAMPOLINE_HEIGHT = ARENA_HEIGHT * .12f;
    public static float TRAMPOLINE_Y = ARENA_HEIGHT * .19f;

    // Trampoline positions (center)
    public static float TRAMPOLINE_CENTER_POSITION_X_1 = ARENA_WIDTH * .28f;
    public static float TRAMPOLINE_CENTER_POSITION_X_2 = ARENA_WIDTH * .47f;
    public static float TRAMPOLINE_CENTER_POSITION_X_3 = ARENA_WIDTH * .65f;

    // Trampoline Collision locations (y)
    public static float TRAMPOLINE_TOP_COLLISION_Y = TRAMPOLINE_Y + TRAMPOLINE_HEIGHT;
    public static float TRAMPOLINE_BOTTOM_COLLISION_Y = TRAMPOLINE_Y;

    // Grass
    public static float GRASS_WIDTH = ARENA_WIDTH * .75f;
    public static float GRASS_HEIGHT = ARENA_HEIGHT * .2f;
    public static float GRASS_X = ARENA_WIDTH - GRASS_WIDTH;
    public static float GRASS_Y = ARENA_HEIGHT - GRASS_HEIGHT;

    private final static float launchOffset = 1.15f;
    //private final static float launchOffset = 1.15f;
    private static final float FRACTION_SMALL = ARENA_HEIGHT * .85f;
    private static final float FRACTION_MEDIUM = ARENA_HEIGHT * .75f;
    private static final float FRACTION_LARGE = ARENA_HEIGHT * .65f;
    public static final int SMALL_PEAK = (int) (FRACTION_SMALL / launchOffset);
    public static final int MEDIUM_PEAK = (int) (FRACTION_MEDIUM / launchOffset);
    public static final int LARGE_PEAK = (int) (FRACTION_LARGE / launchOffset);

    // Fruits
    public static final float FRUIT_STARTING_X = ARENA_WIDTH * .15f;
    public static final float FRUIT_STARTING_Y = ARENA_HEIGHT * .75f;
    public static final float SAVED_FRUIT_X = ARENA_WIDTH * .85f;
    public static final float SAVED_FRUIT_Y = ARENA_HEIGHT * .35f;

    public static final float FRUIT_ROTATION_OFFSET = 3000;

    //// Apple
    private static final float APPLE_WIDTH_PERC = .05f;
    public static final float APPLE_WIDTH = ARENA_WIDTH * APPLE_WIDTH_PERC;
    public static final int APPLE_ADDITIONAL_WEIGHT = -20;
    public static final int APPLE_SCORE_VALUE = 1;

    //// Watermelon
    public static final float WATERMELON_WIDTH = ARENA_WIDTH * .075f;
    public static final float WATERMELON_HEIGHT = ARENA_HEIGHT * .10f;
    public static final int WATERMELON_ADDITIONAL_WEIGHT = -40;
    public static final int WATERMELON_SCORE_VALUE = 1;

    //// Orange
    public static final float ORANGE_WIDTH_PERC = .05f;
    public static final float ORANGE_WIDTH = ARENA_WIDTH * ORANGE_WIDTH_PERC;
    public static final int ORANGE_ADDITIONAL_WEIGHT = -10;
    public static final int ORANGE_SCORE_VALUE = 1;

    //// Banana
    public static final float BANANA_WIDTH_PERC = .05f;
    public static final float BANANA_WIDTH = ARENA_WIDTH * BANANA_WIDTH_PERC;
    public static final int BANANA_ADDITIONAL_WEIGHT = -10;
    public static final int BANANA_SCORE_VALUE = 1;

    //// Rotten Fruit
    private static final float ROTTEN_WIDTH_PERC = .05f;
    public static final float ROTTEN_WIDTH = ARENA_WIDTH * ROTTEN_WIDTH_PERC;
    public static final int ROTTEN_ADDITIONAL_WEIGHT = -50;
    public static final int ROTTEN_SCORE_VALUE = 0;

    //// Basket
    public static final float BASKET_WIDTH_PERC = .05f;
    public static final float BASKET_WIDTH = ARENA_WIDTH * BASKET_WIDTH_PERC;
    public static final int BASKET_ADDITIONAL_WEIGHT = -50;
    public static final int BASKET_SCORE_VALUE = 0;


    // Key Locations
    public static final float DROPPED_Y_LOC = ARENA_Y + (TRAMPOLINE_BOTTOM_COLLISION_Y / 2);

}
