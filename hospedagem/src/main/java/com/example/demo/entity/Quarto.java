package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table (name = "quartos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Quarto {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Integer numero;
    
    @ManyToOne 
    @JoinColumn (name = "tipo_quarto_id")
    private TipoQuarto tipoQuarto;

    @Enumerated(EnumType.STRING)
    private StatusQuarto status;

}