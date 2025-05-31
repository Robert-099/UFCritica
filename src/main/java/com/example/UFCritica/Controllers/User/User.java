package com.example.UFCritica.Controllers.User;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users") // Boa prática nomear tabelas no plural
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email; // Campo para o email
    private String password; // Campo para a senha

    // Construtores (opcional, mas bom ter um padrão e um com campos)
    public User() {}

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

}