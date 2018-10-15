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
@Table(name = "Bank")
public class Bank extends BaseEntity {

    @Builder
    public Bank(Long id, String name, String address, String city,
                String telephone, ArrayList<Branch>branches) {
        super.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.branches=new ArrayList<Branch>();
    }

    @Column(name = "id")
    protected Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
        private String address;

    @Column(name = "city")
        private String city;

    @Column(name = "telephone")
        private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bank")
    private ArrayList<Branch> branches = new ArrayList<>();
}
