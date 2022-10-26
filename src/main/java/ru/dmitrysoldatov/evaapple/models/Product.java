package ru.dmitrysoldatov.evaapple.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "Products")
@Data
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Categories categories;
    @OneToMany(mappedBy = "product")
    private List<Order> orderList;

}
