package com.yilmaz.lab2.bankapplication.web_bank_application.data.services;

import com.yilmaz.lab2.bankapplication.web_bank_application.data.model.Customer;

public interface CustomerService extends CrudService<Customer,Long>{

    public void addTransaction(double amount);
}
