package com.yilmaz.lab2.bankapplication.web_bank_application.data.services;

import com.yilmaz.lab2.bankapplication.web_bank_application.data.model.Branch;
import com.yilmaz.lab2.bankapplication.web_bank_application.data.model.Customer;

import java.util.ArrayList;

public interface BranchService extends CrudService<Branch,Long>{

    ArrayList<Customer> customers();

    public boolean newCustomer(String nameBranch,Long id, String firstName, String lastName, Double initialAmount);

    public boolean addCustomerTransaction(String customerLastName, double amount);

    public boolean transferBetweenCustomers(String customerLastName1, String customerLastName2, double amount);

    CustomerService findCustomer (String LastName);

}
