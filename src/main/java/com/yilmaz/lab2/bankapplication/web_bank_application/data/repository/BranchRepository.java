package com.yilmaz.lab2.bankapplication.web_bank_application.data.repository;

import com.yilmaz.lab2.bankapplication.web_bank_application.data.model.Branch;
import org.springframework.data.repository.CrudRepository;

public interface BranchRepository extends CrudRepository<Branch,Long> {

}
