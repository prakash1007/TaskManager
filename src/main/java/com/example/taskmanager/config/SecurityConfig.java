//package com.example.taskmanager.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	@Bean
//	public DaoAuthenticationProvider authProvider()
//	{
//		DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
//		
//		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(new BCryptPasswordEncoder());
//		return provider;
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//		http.csrf(customizer -> customizer.disable())
//				.authenticationProvider(authProvider())
//				.authorizeHttpRequests(request->request.anyRequest().authenticated())
//				.httpBasic(Customizer.withDefaults())
//				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//		return http.build();
//
//	}
//	
//	
//	
//
////	 @Bean
////	    public UserDetailsService userDetailsService() {
////	        UserDetails user = User.withDefaultPasswordEncoder()
////	        		.username("prakash")
////	        		.password("@321")
////	        		.roles("USER")
////	        		.build();
////	        UserDetails admin = User.withDefaultPasswordEncoder()
////	        		.username("admin")
////	        		.password("admin@321")
////	        		.roles("ADMIN")
////	        		.build();
////
////	        return new InMemoryUserDetailsManager(user,admin);
////	    }
////
////	
//
//	/*
//	 * Customizer<CsrfConfigurer<HttpSecurity>> custCsrf = new
//	 * Customizer<CsrfConfigurer<HttpSecurity>>() {
//	 * 
//	 * @Override public void customize(CsrfConfigurer<HttpSecurity> configurer) {
//	 * 
//	 * configurer.disable(); } };
//	 * 
//	 * Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.
//	 * AuthorizationManagerRequestMatcherRegistry> custHttp = new
//	 * Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.
//	 * AuthorizationManagerRequestMatcherRegistry>() {
//	 * 
//	 * @Override public void customize(
//	 * AuthorizeHttpRequestsConfigurer<HttpSecurity>.
//	 * AuthorizationManagerRequestMatcherRegistry registry) {
//	 * registry.anyRequest().authenticated();
//	 * 
//	 * } };
//	 * 
//	 * http.authorizeHttpRequests(custHttp); http.csrf(custCsrf);
//	 */
//
//}
