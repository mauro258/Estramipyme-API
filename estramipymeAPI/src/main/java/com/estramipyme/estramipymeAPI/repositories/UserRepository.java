package com.estramipyme.estramipymeAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estramipyme.estramipymeAPI.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email); // Para evitar duplicados en el registro
}