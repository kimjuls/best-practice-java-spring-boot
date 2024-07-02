package com.kimjuls.best_practice_java_spring_boot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kimjuls.best_practice_java_spring_boot.dto.CreateUserDto;
import com.kimjuls.best_practice_java_spring_boot.dto.UpdateUserDto;
import com.kimjuls.best_practice_java_spring_boot.model.User;
import com.kimjuls.best_practice_java_spring_boot.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return this.userService.getUserById(id);
    }

    @GetMapping("/not-found")
    public User getNotFound() {
        return this.userService.getUserById(-1L);
    }

    @GetMapping("/internal-server-error")
    public void getInternalServerError() {
        throw new RuntimeException("Internal Server Error");
    }

    @PostMapping
    public String createUser(@RequestBody CreateUserDto dto) {
        this.userService.createUser(dto);
        return "success";
    }

    @PutMapping("/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody UpdateUserDto dto) {
        this.userService.updateUser(id, dto);
        return "successfully updated";
    }

}
