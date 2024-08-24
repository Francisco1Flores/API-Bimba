package com.negocioBimba.negocioBimba.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    Integer userId;

    @Column(name = "password", nullable = false)
    String password;

    @Column(name = "name",nullable = false)
    String name;

    @Column(name = "last_name",nullable = false)
    String lastName;

    @Column(name = "cellphone_number", nullable = true)
    String cellPhoneNumber;

    @Column(name = "email", nullable = false)
    String email;

    @Column(name = "role", nullable = false)
    String role;

    @Temporal(value = TemporalType.TIMESTAMP)
    Date creationDate;

    @Temporal(value = TemporalType.TIMESTAMP)
    Date deletionDate;
}
