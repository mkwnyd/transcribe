package models;

import java.io.File;

public class Mp3File {

    private File mp3;
    private String filePath;

    public File getMp3() {
        return mp3;
    }

    public void setMp3(File mp3) {
        this.mp3 = mp3;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
