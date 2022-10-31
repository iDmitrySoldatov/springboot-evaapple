package ru.dmitrysoldatov.evaapple.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Categories")
@Data
public class Categories {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Categories parentId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "categories")
    private List<Product> productList;
}
