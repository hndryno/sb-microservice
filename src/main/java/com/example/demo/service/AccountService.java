package com.example.demo.service;

import com.example.demo.dto.RegisterCheckDto;
import com.example.demo.model.entities.Account;
import com.example.demo.model.entities.TempAccount;
import com.example.demo.model.repo.AccountRepo;
import com.example.demo.model.repo.TempAccountRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepo accountRepo;
    private final TempAccountRepo tempAccountRepo;
    
    @Autowired
    public AccountService(AccountRepo accountRepo, TempAccountRepo tempAccountRepo) {
        this.accountRepo = accountRepo;
        this.tempAccountRepo = tempAccountRepo;
    }

    public ResponseEntity<?> registerCheck(RegisterCheckDto registerCheckDto){
        String email = registerCheckDto.getEmail();
        //check data di pg, apakah email didata sudah ada?
        Account accountByEmail = accountRepo.getFirstByEmail(email);
        if(accountByEmail != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        //check data di redis apakah sudah pernah regis?
        TempAccount tempAccountByEmail = tempAccountRepo.getFirstByEmail(registerCheckDto.getEmail());
        if(tempAccountByEmail!=null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        //save ke temp redis
        tempAccountByEmail = new TempAccount();
        tempAccountByEmail.setEmail(email);
        tempAccountByEmail.setValid(false);
        tempAccountRepo.save(tempAccountByEmail);
        return ResponseEntity.ok().build();
    }
}
