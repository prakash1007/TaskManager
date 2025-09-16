//package com.example.taskmanager.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.example.taskmanager.models.User;
//import com.example.taskmanager.repository.UserRepo;
//
//@Service
//public class UserService {
//
//	@Autowired
//	private UserRepo repo;
//	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//	
//	public User  saveUser(User user)
//	{
//		user.setPassword(encoder.encode(user.getPassword()));
//		System.out.println(user.getPassword());
//		return repo.save(user);
//		
//	}
//}
