package ru.dmitrysoldatov.evaapple.Image;

import org.springframework.stereotype.Component;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
    @Override
    public void loadImages(String entity, Integer id,String imagesName, byte[] imagesBytes) {
        Path file = Paths.get(path);
        if (!Files.exists(file)){
            try {
                Files.createDirectories(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Path newFile = Paths.get(path,imagesName + ".jpg");
        try (FileOutputStream fileOutputStream = new FileOutputStream(newFile.toFile())){
            fileOutputStream.write(imagesBytes);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void loadImages(String entity, Integer id,String imagesName, String URL) {
        Path file = Paths.get(path);
        if(!Files.exists(file)) {
            try {
                Files.createDirectories(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Path newFile =Paths.get(path, imagesName + ".jpg");
        java.net.URL url = null;
        try {
            url = new URL(URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try (InputStream inputStream = url.openStream()){
            Files.copy(inputStream, newFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
