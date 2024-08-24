package com.negocioBimba.negocioBimba.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Integer id;

    @Column(name = "product_name")
    private String name;

    private Float price;

    private Integer stock;

    @ManyToOne
    @JoinColumn(referencedColumnName = "category_id")
    Category category;
}
