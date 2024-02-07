package com.ty.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ContentController {
	
	@GetMapping("/")
	public String index()
	{
		return "index";
	}

	
	@GetMapping("/about")
	public String about()
	{
		return "about";
	}

	@GetMapping("/achieve")
	public String contact()
	{
		return "achieve";
	}
	
	@GetMapping("/dashboard")
	public String dashboard()
	{
		return "dashboard";
	}
	
	@PostMapping("/userout")
	public String userout(Model model,HttpServletRequest request) throws ServletException
	{
		request.logout();
		return "redirect:/";
	}

}
