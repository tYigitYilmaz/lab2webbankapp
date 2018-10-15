package com.yilmaz.lab2.bankapplication.web_bank_application.data.model;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Branch")
public class Branch extends BaseEntity {



    @Builder
    public Branch(Long id,String nameBranch) {
        super.id = id;
        this.nameBranch = nameBranch;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }
    public boolean newCustomer(Long id, String firstName, String lastName, Double initialAmount){
        if(findCustomer(lastName)==null){
            this.customers.add(new Customer(id,firstName,lastName,initialAmount));
            return true;
        }
        return false;
    }
    public boolean addCustomerTransaction(String LastName, double amount){
        Customer existingCustomer = findCustomer(LastName);
        if (existingCustomer != null){
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }
    public boolean transferBetweenCustomers(String LastName1,String LastName2, double amount){
        Customer existingCustomer1 = findCustomer(LastName1);
        if (existingCustomer1 != null){
            existingCustomer1.addTransaction(-amount);
            addCustomerTransaction(LastName2,amount);
            return true;
        }
        return false;
    }

    private Customer findCustomer (String LastName){
        for (int i = 0; i < this.customers.size(); i++) {
            Customer checkedCustomer = this.customers.get(i);
            if (this.customers.get(i).getLastName().equals(LastName)) {
                return checkedCustomer;
            }
        }
        return null;
    }

    @Column(name = "id")
    protected Long id;

    @Column(name = "nameBranch")
    private String nameBranch;


    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branch")
    private ArrayList<Customer> customers = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameBranch() {
        return nameBranch;
    }

    public void setNameBranch(String nameBranch) {
        this.nameBranch = nameBranch;
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

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }
}
