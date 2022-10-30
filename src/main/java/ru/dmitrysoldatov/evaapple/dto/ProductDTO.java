package ru.dmitrysoldatov.evaapple.dto;
import lombok.Data;
import java.util.List;
@Data
public class ProductDTO {

    private Integer id;

    private String name;

    private String description;

    private Double price;

    private Integer categoriesId;

    private List<String> imagesURL;
}
