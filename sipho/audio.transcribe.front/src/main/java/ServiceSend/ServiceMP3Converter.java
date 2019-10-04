package ServiceSend;

import ProviderSend.ProviderMP3Converter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Mp3File;

import java.io.File;

public class ServiceMP3Converter {

    private ProviderMP3Converter providerMP3Converter = new ProviderMP3Converter();

    public ServiceMP3Converter() {
        //null
    }

    public void sendValue(String filePath) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        File mp3 = providerMP3Converter.convert(filePath);
        Mp3File mp3File = new Mp3File();
        mp3File.setFilePath(filePath);
        mp3File.setMp3(mp3);
        String mp3Json = mapper.writeValueAsString(mp3File);
    }
}
