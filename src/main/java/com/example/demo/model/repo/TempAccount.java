package com.example.demo.model.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempAccount extends CrudRepository <TempAccount, String> {
    
}
