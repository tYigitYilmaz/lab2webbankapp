package com.yilmaz.lab2.bankapplication.web_bank_application.data.services.serviceDataJPA;

import com.yilmaz.lab2.bankapplication.web_bank_application.data.repository.CustomerRepository;
import com.yilmaz.lab2.bankapplication.web_bank_application.data.services.CustomerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Profile("serviceDataJpa")
public abstract class CustomerJpaService implements CustomerService {

    private final CustomerRepository customerRepository;
    private ArrayList<Double> transactions;

    public CustomerJpaService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.transactions = transactions;
    }

    @Override
    public void addTransaction(double amount) {
        this.transactions.add(amount);
    }
}
