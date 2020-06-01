import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class PlaySound {

    public void play (String fileName){

        try {

            //Gets the absolute path to the given file name at resources directory
            File filePath = new File(getClass().getClassLoader().getResource(fileName).getFile());

            //Creates a clip that loads the file before playing
            Clip clip = AudioSystem.getClip();

            // create a AudioInputStream object with the sound file location
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(filePath);

            //loading the sound file
            clip.open(audioInputStream);

            clip.start();

            //Allows to delay the end of the method so the sound plays
            while (!clip.isRunning()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (clip.isRunning()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            clip.close();

        } catch (Exception e){
            e.printStackTrace();

        }



    }
}
