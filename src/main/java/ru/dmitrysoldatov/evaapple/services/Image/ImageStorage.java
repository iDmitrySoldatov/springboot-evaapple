package ru.dmitrysoldatov.evaapple.services.Image;

import java.util.List;

public interface ImageStorage {
    List<String> getImages(String entity, Integer entityId);
    void loadImages(String entity, Integer id,String imagesName, byte[] imagesBytes);
    void loadImages(String entity, Integer id, String imagesName, String URL);
}
