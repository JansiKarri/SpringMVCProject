package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.payment;

@Repository

public interface paymentRepo extends JpaRepository<payment, Long>{

}
