package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    
}
