package com.example.demo.model.repo;

import com.example.demo.model.entities.TempAccount;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempAccountRepo extends CrudRepository <TempAccount, String> {
    TempAccount getFirstByEmail(String email);
}
