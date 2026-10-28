package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TipoQuarto;

@Repository
public interface TipoQuartoRepository extends JpaRepository<TipoQuarto, Long> {

    List<TipoQuarto> findByAtivoTrue();    

}
