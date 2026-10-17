package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.demo.entity.FormaPagamento;
import com.example.demo.entity.Reserva;
import com.example.demo.entity.StatusPagamento;

public record PagamentoDTO(

    Long id,
    BigDecimal valor,
    LocalDateTime dataPagamento,
    FormaPagamento formaPagamento,
    StatusPagamento statusPagamento,
    Reserva reserva

) {    
}