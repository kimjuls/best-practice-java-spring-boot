package com.kimjuls.best_practice_java_spring_boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kimjuls.best_practice_java_spring_boot.dto.CreateUserDto;
import com.kimjuls.best_practice_java_spring_boot.dto.UpdateUserDto;
import com.kimjuls.best_practice_java_spring_boot.model.User;
import com.kimjuls.best_practice_java_spring_boot.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> userIfExists = this.userRepository.findById(id);
        return userIfExists.orElseThrow();
    }

    public void createUser(CreateUserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        this.userRepository.save(user);
    }

    public void updateUser(Long id, UpdateUserDto dto) {
        Optional<User> userIfExists = this.userRepository.findById(id);
        User user = userIfExists.orElseThrow();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        this.userRepository.save(user);
    }
}
