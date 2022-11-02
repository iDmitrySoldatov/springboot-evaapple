package ru.dmitrysoldatov.evaapple.dto;

import lombok.Data;

@Data
public class ImagesByteDTO {

    private String entity;

    private Integer id;

    private String imagesName;

    private byte[] bytes;
}
