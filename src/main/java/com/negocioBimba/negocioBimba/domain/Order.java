package com.negocioBimba.negocioBimba.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    Integer id;

    @OneToOne
    @JoinColumn(referencedColumnName = "client_id")
    Client client;

    Boolean state;

    @Temporal(TemporalType.DATE)
    Date date;

    @OneToMany
    Set<Product> products;
}
