package com.example.demo.dto;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.entity.Hospede;
import com.example.demo.entity.Pagamento;
import com.example.demo.entity.Quarto;
import com.example.demo.entity.ReservaServico;

public record ReservaDTO(

    Long id,
    Quarto quarto,
    Hospede hospede,
    List<Pagamento> pagamentos,
    List<ReservaServico> servicos,
    BigDecimal valorDiaria,
    Integer diasTotais

) {
    
}