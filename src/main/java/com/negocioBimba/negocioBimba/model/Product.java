package com.negocioBimba.negocioBimba.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Float price;
    private Integer stock;

    @ManyToOne
    @JoinColumn(referencedColumnName = "category_id")
    Category category;
}
