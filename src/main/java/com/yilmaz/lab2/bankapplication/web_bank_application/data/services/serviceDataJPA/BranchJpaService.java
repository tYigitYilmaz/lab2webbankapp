package com.yilmaz.lab2.bankapplication.web_bank_application.data.services.serviceDataJPA;

import com.yilmaz.lab2.bankapplication.web_bank_application.data.model.Customer;
import com.yilmaz.lab2.bankapplication.web_bank_application.data.repository.BranchRepository;
import com.yilmaz.lab2.bankapplication.web_bank_application.data.repository.CustomerRepository;
import com.yilmaz.lab2.bankapplication.web_bank_application.data.services.BranchService;
import com.yilmaz.lab2.bankapplication.web_bank_application.data.services.CustomerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Profile("serviceDataJpa")
public abstract class BranchJpaService implements BranchService {

    private final BranchRepository branchRepository;
    private final CustomerRepository customerRepository;
    private final ArrayList<Customer> customers;

    public BranchJpaService(BranchRepository branchRepository, CustomerRepository customerRepository) {
        this.branchRepository = branchRepository;
        this.customerRepository = customerRepository;
        this.customers = customers();
    }

    @Override
    public boolean newCustomer(String nameBranch, Long id, String firstName, String lastName, Double initialAmount) {
        return false;
    }

    @Override
    public boolean addCustomerTransaction(String LastName, double amount) {
        CustomerService existingCustomer = findCustomer(LastName);
        if (existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;

    }

    @Override
    public CustomerService findCustomer(String LastName){
        for (int i = 0; i < this.customers.size(); i++) {
            Customer checkedCustomer = this.customers.get(i);
            if (this.customers.get(i).getLastName().equals(LastName)) {
                return (CustomerService) checkedCustomer;
            }
        }
        return null;
    }

    @Override
    public boolean transferBetweenCustomers (String LastName1,String LastName2, double amount){
        Customer existingCustomer1 = (Customer) findCustomer(LastName1);
        if (existingCustomer1 != null){
            existingCustomer1.addTransaction(-amount);
            addCustomerTransaction(LastName2,amount);
            return true;
        }
        return false;
    }
}