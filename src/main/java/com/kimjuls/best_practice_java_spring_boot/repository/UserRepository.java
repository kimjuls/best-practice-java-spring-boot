package com.kimjuls.best_practice_java_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kimjuls.best_practice_java_spring_boot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
