package ru.dmitrysoldatov.evaapple.dto;

import lombok.Data;
import ru.dmitrysoldatov.evaapple.models.Categories;
import ru.dmitrysoldatov.evaapple.models.Order;

import javax.persistence.*;
import java.util.List;
@Data
public class ProductDTO {

    private Integer id;

    private String name;

    private String description;

    private Double price;

    private Categories categories;

    private List<Order> orderList;

    private List<String> imagesURL;
}
