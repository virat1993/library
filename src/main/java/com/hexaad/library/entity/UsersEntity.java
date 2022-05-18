package com.hexaad.library.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table
@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UsersEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "library_card_number")
    private String library_card_number;
    @Column(name = "is_active")
    private int is_active;
}