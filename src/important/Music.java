package important;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music {
    private static String fileName;
    private static File file;
    private static AudioInputStream audioInputStream;
    private static Clip clip;
    private static String currentlyPlaying;

    /**
     * Initializes the audio at the start of the game.
     */
    public static void initialize() {
        try {
            file = new File("other.wav");
            audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            currentlyPlaying = "other.wav";
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Checks whether the new room has a new music, if so the music will stop and start playing a new one, else the music will keep playing.
     */
    public static void play() {
        if (!currentlyPlaying.equals(fileName)) {
            stop();
        }
        if (!clip.isRunning()) {
            try {
                file = new File(fileName);
                currentlyPlaying = fileName;
                audioInputStream = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Stops the audio.
     */
    public static void stop() {
        clip.stop();
    }

    public static void setFileName(String fileName) {
        Music.fileName = fileName;
    }
}
