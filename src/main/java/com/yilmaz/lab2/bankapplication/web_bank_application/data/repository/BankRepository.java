package com.yilmaz.lab2.bankapplication.web_bank_application.data.repository;

import com.yilmaz.lab2.bankapplication.web_bank_application.data.model.Bank;
import org.springframework.data.repository.CrudRepository;

public interface BankRepository extends CrudRepository<Bank, Long> {

}

