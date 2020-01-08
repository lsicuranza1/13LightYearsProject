package game;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {
	
	private Clip sound;           
    private FloatControl volume;

    /**
     * @param sound
     */
    public Sound(Clip sound) {
        this.sound = sound;
        volume = (FloatControl) sound.getControl(FloatControl.Type.MASTER_GAIN);
    }

    /**
     * 
     */
    public void playSound() {
        if (Settings.soundEffects) {
            sound.setFramePosition(0);
            sound.start();
        }
    }

    /**
     * 
     */
    public void loopSound() {
        sound.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * 
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
     * @param value
     */
    public void changeVolume(float value) {
        volume.setValue(value);
    }

    /**
     * @return
     */
    public boolean isRunning() {
        return sound.isRunning();
    }
    
	}
