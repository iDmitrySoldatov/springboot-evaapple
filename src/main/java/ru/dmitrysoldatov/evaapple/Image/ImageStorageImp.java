package ru.dmitrysoldatov.evaapple.Image;

import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Component
public class ImageStorageImp implements ImageStorage{

    private String path = "/home/dmitry/";

    @Override
    public List<String> getImages(String entity, Integer entityId) {
        try {
        List<String> images = new ArrayList<>();
        Path pathFile = Path.of(path+entity+"/"+entityId+"/");
        File[] list = pathFile.toFile().listFiles();
        for (File fileName : list) {
            images.add(fileName.getAbsolutePath());
        }
        return images;
        }catch (NullPointerException e) {
            return new ArrayList<>();
        }
    }
}
