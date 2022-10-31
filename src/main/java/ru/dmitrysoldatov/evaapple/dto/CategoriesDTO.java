package ru.dmitrysoldatov.evaapple.dto;

import lombok.Data;

@Data
public class CategoriesDTO {

    private Integer id;

    private String name;

    private Integer parentId;
}
