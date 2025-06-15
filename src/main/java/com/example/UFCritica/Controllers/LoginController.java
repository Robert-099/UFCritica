package com.example.UFCritica.Controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {
    @GetMapping("/register") // Este método será executado quando alguém acessar /register
    public String showRegistrationForm() {
        return "register"; // Retorna o nome da sua view (o arquivo register.html)
    }


    
}
