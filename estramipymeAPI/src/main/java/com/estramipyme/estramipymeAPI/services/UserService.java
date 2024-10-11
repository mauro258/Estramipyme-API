package com.estramipyme.estramipymeAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estramipyme.estramipymeAPI.models.User;
import com.estramipyme.estramipymeAPI.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // Aquí puedes agregar validaciones adicionales si es necesario
        return userRepository.save(user);
    }
}
