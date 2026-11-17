package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Hospede;

@Repository 
public interface HospedeRepository extends JpaRepository<Hospede, Long> {

    List<Hospede> findByNomeContainingIgnoreCase(String nome);
    
}
