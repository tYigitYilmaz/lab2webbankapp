package com.yilmaz.lab2.bankapplication.web_bank_application.data.model;


import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@NoArgsConstructor
@Entity
@Table(name = "Customer")

public class Customer extends BaseEntity{

    @Builder
    public Customer(Long id, String firstName, String lastName, Double balance) {
        super.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        }



    public void addTransaction(double amount){
        this.transaction.add(amount);
    }

    @Column(name = "id")
    protected Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "balance")
    private Double balance;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private ArrayList<Double> transaction= new ArrayList<>();

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public ArrayList<Double> getTransaction() {
        return transaction;
    }

    public void setTransaction(ArrayList<Double> transaction) {
        this.transaction = transaction;
    }
}

