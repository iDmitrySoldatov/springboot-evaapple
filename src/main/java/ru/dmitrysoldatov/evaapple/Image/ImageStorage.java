package ru.dmitrysoldatov.evaapple.Image;

import java.util.List;

public interface ImageStorage {
    List<String> getImages(String entity, Integer entityId);
}
