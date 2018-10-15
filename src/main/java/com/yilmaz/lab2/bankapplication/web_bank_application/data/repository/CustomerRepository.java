package com.yilmaz.lab2.bankapplication.web_bank_application.data.repository;

import com.yilmaz.lab2.bankapplication.web_bank_application.data.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {

}
