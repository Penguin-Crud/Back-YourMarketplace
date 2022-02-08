package com.marketplace.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String email;
    private String avatarSeller;

    @JsonIgnore
    @OneToMany(mappedBy = "owner")//, cascade = CascadeType.REMOVE)
    private Set<Product> products = new HashSet<>();

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public User() {
    }

    @Override
    public String toString(){
        return "User id:"+getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarSeller() {
        return avatarSeller;
    }

    public void setAvatarSeller(String avatarSeller) {
        this.avatarSeller = avatarSeller;
    }
}
/* hello */