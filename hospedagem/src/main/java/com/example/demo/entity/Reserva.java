package com.example.demo.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table (name = "reserva")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reserva {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) 
    private Long id;

    @ManyToOne 
    @JoinColumn (name = "quarto_id")
    private Quarto quarto;

    @ManyToOne 
    @JoinColumn (name = "hospede_id")
    private Hospede hospede;

    @OneToMany (mappedBy = "reserva")
    private List<Pagamento> pagamentos;

    @OneToMany (mappedBy = "reserva")
    private List<ReservaServico> servicos;

    private BigDecimal valorDiaria;

    private Integer diasTotais;
}
