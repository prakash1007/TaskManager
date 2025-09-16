//package com.example.taskmanager.controller;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.taskmanager.models.User;
//import com.example.taskmanager.repository.UserRepo;
//import com.example.taskmanager.service.UserService;
//
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
//
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//    
//	@Autowired
//	private UserRepo repo;
//
//    @PostMapping("/register")
//    public User registerUser(@RequestBody User user) {
//        return userService.saveUser(user);
//    }
//   
//}