package com.idus.idus.service;

import com.idus.idus.entity.User;
import com.idus.idus.exception.UserException;
import com.idus.idus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User saveUser(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        } catch (Exception e) {

            throw new UserException("Erro ao salvar o usuário: " + e.getMessage());
        }
    }

    public User getUserById(Long id) {
        try {
            return userRepository.findById(id).stream().findFirst().orElse(null);

        } catch (Exception e) {
            throw new UserException("Erro ao buscar o usuário: " + e.getMessage());
        }
    }
}
