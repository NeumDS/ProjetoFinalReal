package com.example.demo.dto;

import java.math.BigDecimal;

public record TipoQuartoDTO(

    Long id,
    String nome,
    String descricao,
    Integer capacidade,
    BigDecimal valorDiaria
    
) {
    
}