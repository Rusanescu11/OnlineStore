package com.project.demo.persitance.model;

import javax.persistence.*;

@Entity
@Table(name = "adress")
public class AdressModel {

@Id
@GeneratedValue   (strategy = GenerationType.IDENTITY)
private Long id;

private Long zipCode;

private String street;

private String city;

private String country;

@OneToOne(cascade = CascadeType.ALL,mappedBy = "adress")
private UserModel user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
