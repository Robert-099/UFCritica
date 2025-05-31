package com.example.UFCritica.Controllers.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Suponha que você tem uma forma de criptografar senhas (ex: BCryptPasswordEncoder)
    // Para um trabalho de faculdade, inicialmente, pode ser uma verificação simples.
    // MAS, para a segurança real, você deve criptografar!
    // private PasswordEncoder passwordEncoder; // Injetar se estiver usando Spring Security

    public boolean authenticate(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Em um sistema real, você compararia a senha fornecida com a senha HASHED do banco de dados
            // return passwordEncoder.matches(password, user.getPassword());
            return user.getPassword().equals(password); // APENAS PARA EXEMPLO SIMPLES E TESTES INICIAIS! Mude isso!
        }
        return false;
    }

    public User registerNewUser(User user) {
        // Em um sistema real, você verificaria se o email já existe
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado.");
        }
        // Em um sistema real, você criptografaria a senha antes de salvar
        // user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
    // Outros métodos de serviço para User...
}