package game;

import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Utilities {

    /**
     * This method is responsible for loading the audio track into the game
     * @param direction It is the path of the sound file
     * @return clip object or null, if it finds or not the audio
     */
    public static Clip LoadSound(URL direction) {
    	
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(direction));
            return clip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
