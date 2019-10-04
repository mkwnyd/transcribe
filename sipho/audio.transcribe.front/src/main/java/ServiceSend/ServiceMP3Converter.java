package ServiceSend;

import ProviderSend.ProviderMP3Converter;
import models.Mp3Base64;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class ServiceMP3Converter {

    private static final Logger LOGGER = Logger.getLogger(ServiceMP3Converter.class);
    private ProviderMP3Converter providerMP3Converter = new ProviderMP3Converter();

    public ServiceMP3Converter() {
        //null
    }

    /**
     * Converts mp4 to mp3 and convert to Base64 code. Puts the resulting value in an Mp3Base64 object ready to be sent
     * @param filePath
     * @throws IOException
     */

    public void sendValue(String filePath) throws IOException {

        File mp3 = providerMP3Converter.convert(filePath);
        byte[] bytes = FileUtils.readFileToByteArray(mp3);
        String encoded = Base64.getEncoder().encodeToString(bytes);
        Mp3Base64 mp3Base64 = new Mp3Base64();
        mp3Base64.setBase64(encoded);
        LOGGER.info("Base64 code" + encoded);

    }
}
