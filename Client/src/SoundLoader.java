import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

public class SoundLoader {
	
	public static File sound;
	public static float value;
	
	public static String ringtone = "BusinessHiLoud.wav";
	
	Clip clip;
	
	public SoundLoader() {
		value = 0;
	}
	
	public void load() {
		sound = new File("res/ringtones/"+ringtone);
		System.out.println(ringtone);
	}
	
	public void play(File sound) {
		
		clip = null;
		
		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
