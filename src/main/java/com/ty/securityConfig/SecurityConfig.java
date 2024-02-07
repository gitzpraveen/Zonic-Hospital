package com.ty.securityConfig;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.RedisSessionProperties.ConfigureAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@EnableWebSecurity
@Configuration
public class SecurityConfig 
{
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Bean
	public  static PasswordEncoder passwordEncoder()
	{
		 return new BCryptPasswordEncoder();
	}
	
	
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		String[] REGISTER= {"/register", "/registerUser", "/css/**", "/images/**"};
		String[] CONTENT= {"/", "/about","/achieve","/dashboard","/userout"};
		
		http.csrf(csrf->csrf.disable()).authorizeHttpRequests(auth->auth.requestMatchers(REGISTER).permitAll()
										.requestMatchers(CONTENT).permitAll()
										.anyRequest().authenticated())
			.formLogin(form->form.loginPage("/login").loginProcessingUrl("/userlogin").permitAll())
			.logout(out->out.logoutSuccessUrl("/userout").permitAll());
		
			
				
																		
		return http.build();
		
	}
	
	
	@Autowired
	public  void ConfigureAction(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}

}
