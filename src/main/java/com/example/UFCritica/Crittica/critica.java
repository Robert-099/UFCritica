package com.example.UFCritica.Crittica;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class critica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
    private String conteudo;
    private String tipoCritica; // "Filme", "Serie", etc.
    private String autor;
    private LocalDateTime dataPostagem = LocalDateTime.now();
    private Double mediaAvaliacao = 0.0;
    private Integer totalAvaliacoes = 0;
}