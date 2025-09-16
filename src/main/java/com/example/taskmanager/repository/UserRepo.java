package com.example.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.taskmanager.models.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	User findByUsername(String username);
}
