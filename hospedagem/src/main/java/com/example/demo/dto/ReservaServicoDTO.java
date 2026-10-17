package com.example.demo.dto;

import java.math.BigDecimal;

import com.example.demo.entity.Reserva;
import com.example.demo.entity.Servico;

public record ReservaServicoDTO(

    Long id,
    Reserva reserva,
    Servico servico,
    Integer quantidade,
    BigDecimal valorUnitario
    
) {
    
}