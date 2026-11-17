package com.example.demo.dto;

import java.math.BigDecimal;
import java.util.List;

public record ReservaDTO(

    Long id,
    Long quartoId,
    Long hospedeId,
    List<PagamentoDTO> pagamentos,
    List<ReservaServicoDTO> servicos,
    BigDecimal valorDiaria,
    Integer diasTotais

) {
    
}