package com.negocioBimba.negocioBimba.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "clients")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    Integer idClient;

    String name;
    String contact;
    String email;
    String location;
    Integer buys;

}
