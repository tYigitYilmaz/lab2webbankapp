package com.yilmaz.lab2.bankapplication.web_bank_application.data.services.serviceDataJPA;


import com.yilmaz.lab2.bankapplication.web_bank_application.data.model.Branch;
import com.yilmaz.lab2.bankapplication.web_bank_application.data.repository.BankRepository;
import com.yilmaz.lab2.bankapplication.web_bank_application.data.repository.BranchRepository;
import com.yilmaz.lab2.bankapplication.web_bank_application.data.repository.CustomerRepository;
import com.yilmaz.lab2.bankapplication.web_bank_application.data.services.BankService;
import com.yilmaz.lab2.bankapplication.web_bank_application.data.services.BranchService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@SuppressWarnings("ALL")
@Service
@Profile("serviceDataJpa")
public abstract class BankJpaService implements BankService {

    private final BankRepository bankRepository;
    private final BranchRepository branchRepository;
    private final CustomerRepository customerRepository;
    private final ArrayList<Branch> branches;

    public BankJpaService(BankRepository bankRepository, BranchRepository branchRepository, CustomerRepository customerRepository){
        this.bankRepository = bankRepository;
        this.branchRepository = branchRepository;
        this.customerRepository = customerRepository;
        this.branches = branches();
    }

    @Override
    public boolean addBranch(Long id,String branchName){
        if (findBranch(branchName) ==null){
            this.branches.add(new Branch(id,branchName));
            return true;
        }
        return false;
    }

    @Override
    public boolean addCustomer(String nameBranch,Long id, String firstName, String lastName, Double initialAmount){
        BranchService Branch = findBranch(nameBranch);
        if (Branch != null){
            return Branch.newCustomer(nameBranch,id,firstName,lastName,initialAmount);
        }
        return false;
    }
    @Override
    public boolean addCustomerTransaction (String branchName, String customerLastName, double amount){
        BranchService branch = findBranch(branchName);
        if (branch != null){
            return branch.addCustomerTransaction(customerLastName,amount);
        }
        return false;
    }

    @Override
    public boolean transferBetweenCustomers(String branchName, String customerLastName1, String customerLastName2, double amount){
        BranchService branch = findBranch(branchName);
        if (branch != null){
            return branch.transferBetweenCustomers(customerLastName1,customerLastName2,amount);
        }
        return false;
    }

    @Override
    public BranchService findBranch(String nameBranch){
        for (int i=0; i<this.branches.size();i++){
            Branch checkedBranch = this.branches.get(i);
            if (checkedBranch.getNameBranch().equals(nameBranch)){
                return (BranchService) checkedBranch;
            }
        }
        return null;
    }
}
