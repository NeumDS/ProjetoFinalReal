package com.example.demo.dto;

import java.math.BigDecimal;

public record ReservaServicoDTO(

    Long id,
    Long reservaId,
    Long servicoId,
    Integer quantidade,
    BigDecimal valorUnitario
    
) {
    
}