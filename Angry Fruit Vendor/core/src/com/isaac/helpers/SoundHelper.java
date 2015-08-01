package com.isaac.helpers;

import com.badlogic.gdx.audio.Sound;

/**
 * Created by Isaac Holloway on 7/12/2015.
 */
public class SoundHelper {

    /***/
    public static void playSound(Sound sound){
        if(UserData.getSound()){
            sound.play();
        }
    }
}
