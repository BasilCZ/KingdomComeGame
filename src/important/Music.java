package important;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music {
    private static File file;
    private static AudioInputStream audioInputStream;
    private static Clip clip;

    public static void initialize(){
        try {
            file = new File("fight.wav");
            audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void play(){
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void stop(){
        clip.stop();
    }
}
