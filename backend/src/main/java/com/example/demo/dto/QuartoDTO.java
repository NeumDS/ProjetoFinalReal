package com.example.demo.dto;

import com.example.demo.entity.StatusQuarto;

public record QuartoDTO( 
     Long id,
     Integer numero,
     Long tipoQuartoID,
     StatusQuarto status
) {

}