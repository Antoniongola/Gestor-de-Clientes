package com.ngolajr.cadastrodeclientes.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String username;
    private String password;
    @OneToMany
    private Set<Role> roles;
}
