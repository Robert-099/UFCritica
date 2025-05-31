package com.example.UFCritica.Controllers.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    long countByNome(String name);
}
