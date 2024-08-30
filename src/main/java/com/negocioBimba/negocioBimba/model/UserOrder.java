package com.negocioBimba.negocioBimba.model;


import com.negocioBimba.negocioBimba.DTO.ProductDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user_order")
@Data
public class UserOrder {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    Integer id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    User user;

    @Column(name = "state_of_pay")
    Boolean stateOfPay;

    @Column(name = "realization_date")
    @Temporal(TemporalType.DATE)
    Date date;

    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.PERSIST)
    Set<OrderProduct> products;

    public void addProduct(ProductDto productDto) {

    }

    public void addProducts(Set<ProductDto> productsDto) {

    }

}
