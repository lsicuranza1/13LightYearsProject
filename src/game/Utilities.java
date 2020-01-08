package game;

import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Utilities {

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
