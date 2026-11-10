package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.example.demo.entity.FormaPagamento;
import com.example.demo.entity.StatusPagamento;

public record PagamentoDTO(

    Long id,
    BigDecimal valor,
    LocalDateTime dataPagamento,

    @JsonProperty("formaPagamento")
    FormaPagamento formaPagamento,

    @JsonProperty("statusPagamento")
    StatusPagamento statusPagamento,

    Long reservaId

) {
}