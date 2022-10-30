package ru.dmitrysoldatov.evaapple.dto;

import lombok.Data;

import java.util.Date;
@Data
public class OrderDTO {

    private Integer id;

    private String phoneNumber;

    private String clienName;

    private String city;

    private Date dateTime;

    private Integer productId;
}
