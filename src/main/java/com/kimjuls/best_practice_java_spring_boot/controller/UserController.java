package com.kimjuls.best_practice_java_spring_boot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kimjuls.best_practice_java_spring_boot.classes.AppException;
import com.kimjuls.best_practice_java_spring_boot.classes.ExceptionDef;
import com.kimjuls.best_practice_java_spring_boot.dto.CreateUserDto;
import com.kimjuls.best_practice_java_spring_boot.dto.UpdateUserDto;
import com.kimjuls.best_practice_java_spring_boot.model.User;
import com.kimjuls.best_practice_java_spring_boot.service.UserService;

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
    public User getUserById(@PathVariable Long id) throws AppException {
        return this.userService.getUserById(id);
    }

    @GetMapping("/not-found")
    public User getNotFound() throws AppException {
        return this.userService.getUserById(-1L);
    }

    @GetMapping("/internal-server-error")
    public void getInternalServerError() throws AppException {
        throw new AppException(ExceptionDef.INTERNAL_SERVER_ERROR);
    }

    @PostMapping
    public void createUser(@RequestBody CreateUserDto dto) {
        this.userService.createUser(dto);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UpdateUserDto dto) throws AppException {
        this.userService.updateUser(id, dto);
    }

}
