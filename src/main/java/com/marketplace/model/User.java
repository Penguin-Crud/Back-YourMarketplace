package com.marketplace.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User<string> {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private string name;
    private string surname;
    private string email;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public string getName() {
        return name;
    }

    public void setName(string name) {
        this.name = name;
    }

    public string getSurname() {
        return surname;
    }

    public void setSurname(string surname) {
        this.surname = surname;
    }

    public string getEmail() {
        return email;
    }

    public void setEmail(string email) {
        this.email = email;
    }
}
