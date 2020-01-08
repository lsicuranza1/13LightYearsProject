package game;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {
	
	private Clip sound;           
    private FloatControl volume;

    /**
     * Constructor of the class
     * @param sound A Clip parameter
     */
    public Sound(Clip sound) {
        this.sound = sound;
        volume = (FloatControl) sound.getControl(FloatControl.Type.MASTER_GAIN);
    }

    /**
     * This method is used to play the audio track.
     */
    public void playSound() {
        if (Settings.soundEffects) {
            sound.start();
        }
    }

    /**
     * This method allows us to keep the song in loop.So when the audio ends, it re-starts from the beginning.
     */
    public void loopSound() {
        sound.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * It stops the sounds.
     */
    public void stopSound() {
        sound.stop();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method changes the volume of the audio track.
     * @param value is the volume of the song
     */
    public void changeVolume(float value) {
        volume.setValue(value);
    }

    /**
     * @return a boolean value: 
     * True : if the audio track is running
     * False : otherwise
     */
    public boolean isRunning() {
        return sound.isRunning();
    }
    
	}
