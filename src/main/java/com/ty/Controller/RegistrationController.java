package com.ty.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ty.Entity.User;
import com.ty.Service.UserService;

@org.springframework.stereotype.Controller
public class RegistrationController {
	@Autowired
	private UserService service;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/register")
	public String register(Model model) {
		User user = new User();
		
		model.addAttribute("user", user);
		return "register";
	}

	@PostMapping("/registerUser")
	public String registerUser(@ModelAttribute("user") User user,Model model) 
	{
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		service.register(user);
		model.addAttribute("message","Registered Successfully");
		System.out.println("registered successfully");
		return "register";
	
	}
	
	
	
}
