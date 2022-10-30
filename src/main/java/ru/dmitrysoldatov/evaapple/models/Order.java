package ru.dmitrysoldatov.evaapple.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Orders")
@Data
@NoArgsConstructor
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "client_name")
    private String clienName;

    @Column(name = "city")
    private String city;

    @Column(name = "date_time")
    private Date dateTime;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
}
