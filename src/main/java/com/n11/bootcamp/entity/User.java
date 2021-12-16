package com.n11.bootcamp.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "users")
public class User {

    @SequenceGenerator(name = "generator", sequenceName = "user_id_seq")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 20, name = "username", nullable = false, unique = true)
    private String username;

    @Column(length = 50, name = "name", nullable = false)
    private String name;

    @Column(length = 50, name = "surname", nullable = false)
    private String surname;

    @Column(length = 50, name = "email", nullable = false)
    private String email;

    @Column(length = 15, name = "phone_number")
    private String phoneNumber;
}
