package com.example.demo.dto;

import java.math.BigDecimal;

public record ServicoDTO(

    Long id,
    String nome,
    String descricao,
    BigDecimal valorServico
    
) {
    
}