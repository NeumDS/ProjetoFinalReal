package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiResponse<T> {

    private int status;
    private String mensagem;

    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
    private List<String> erros;
    private T dados;

    public static <T> ApiResponse<T> sucesso (int status, String mensagem, T dados) {
        return ApiResponse.<T>builder()
            .status(status)
            .mensagem(mensagem)
            .dados(dados)
            .build();
    }

    public static <T> ApiResponse<T> sucesso (int status, String mensagem) {
        return ApiResponse.<T>builder()
            .status(status)
            .mensagem(mensagem)
            .build();
    }

    public static <T> ApiResponse<T> erro(int status, String mensagem, List<String> erros) {
        return ApiResponse.<T>builder()
            .status(status)
            .mensagem(mensagem)
            .erros(erros)
            .build();
    }
    
}
