package com.negocioBimba.negocioBimba.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "clients")
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    Integer clientId;

    String name;
    String contact;
    String email;
    String location;

}
