package ServiceSend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tunde Michael
 *
 */

public class MP3Converter {

    private static final Logger LOG = Logger.getLogger(MP3Converter.class.getName());

    public void convert(String mp4File){

        try {
            String line;
            //Creates mp3 audio file path
            String mp3File = createMp3(mp4File);
            String cmd = "ffmpeg -i " + mp4File + " " + mp3File;
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(p.getErrorStream()));
            while ((line = in.readLine()) != null) {
            }
            p.waitFor();
            System.out.println("Video converted successfully!");
            in.close();
        } catch (IOException | InterruptedException e) {
            LOG.log(Level.SEVERE, null, e);
        }

    }

    public String createMp3(String mp3File){
        Character character = new Character(mp3File.charAt(mp3File.length()-1));
        while (!character.equals('/')) {
            mp3File = mp3File.substring(0, mp3File.length()-2);
            character = new Character(mp3File.charAt(mp3File.length()-1));
        }
        mp3File = mp3File+"Audio.mp3";
        return mp3File;
    }

}