package com.example.demo.model.repo;

import com.example.demo.model.entities.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//ambil dari account idnya tipenya adalah long
@Repository
public interface AcountRepo extends JpaRepository <Account, Long> {
    
}
