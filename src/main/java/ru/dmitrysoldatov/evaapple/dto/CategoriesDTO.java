package ru.dmitrysoldatov.evaapple.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoriesDTO {

    private Integer id;

    private String name;

    private Integer parentId;

    private List<String> categoriesURL;
}
