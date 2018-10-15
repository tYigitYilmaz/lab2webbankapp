package com.yilmaz.lab2.bankapplication.web_bank_application.data.services;

import com.yilmaz.lab2.bankapplication.web_bank_application.data.model.Bank;
import com.yilmaz.lab2.bankapplication.web_bank_application.data.model.Branch;

import java.util.ArrayList;

public interface BankService extends CrudService<Bank,Long>{

    ArrayList<Branch> branches();

    boolean addBranch(Long id, String branchName);

    boolean addCustomer(String nameBranch, Long id, String firstName, String lastName, Double initialAmount);

    boolean addCustomerTransaction(String branchName, String customerLastName, double amount);

    boolean transferBetweenCustomers(String branchName, String customerLastName1, String customerLastName2, double amount);

    BranchService findBranch(String nameBranch);
}

