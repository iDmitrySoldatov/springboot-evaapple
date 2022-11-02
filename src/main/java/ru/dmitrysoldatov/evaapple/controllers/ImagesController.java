package ru.dmitrysoldatov.evaapple.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.dmitrysoldatov.evaapple.dto.ImagesByteDTO;
import ru.dmitrysoldatov.evaapple.dto.ImagesUrlDTO;
import ru.dmitrysoldatov.evaapple.services.Image.ImageStorage;

@RestController
public class ImagesController {
    private ImageStorage imageStorage;

    @Autowired
    public ImagesController(ImageStorage imageStorage) {
        this.imageStorage = imageStorage;
    }

    @PostMapping("/images/URL")
    public void loadImagesURL(@RequestBody ImagesUrlDTO imagesUrlDTO) {
        imageStorage.loadImages(imagesUrlDTO.getEntity(), imagesUrlDTO.getId(),
                imagesUrlDTO.getImagesName(),
                imagesUrlDTO.getURL());
    }

    @PostMapping("/images/bytes")
    public void loadImagesBytes(@RequestBody ImagesByteDTO imagesByteDTO) {
        imageStorage.loadImages(imagesByteDTO.getEntity(), imagesByteDTO.getId(),
                imagesByteDTO.getImagesName(),
                imagesByteDTO.getBytes());
    }
}
