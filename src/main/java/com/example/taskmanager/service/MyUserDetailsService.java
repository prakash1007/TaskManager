//package com.example.taskmanager.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.example.taskmanager.models.User;
//import com.example.taskmanager.repository.UserRepo;
//import com.sun.security.auth.UserPrincipal;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//	
//	@Autowired
//	private UserRepo repo;
//	
//	@Autowired
//	private UserPrincipal userPrincipal;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//		User user = repo.findByUsername(username);
//		if(user==null)
//		{
//			System.out.println("User 404");
//			throw new UsernameNotFoundException("User 404");
//		}	
//		return new UserPrincipal(user);
//	}
//
//}
