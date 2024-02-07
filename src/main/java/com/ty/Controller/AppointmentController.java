package com.ty.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.ty.Entity.Appointment;
import com.ty.Service.AppointmentSevice;


@Controller
public class AppointmentController 
{
	@Autowired
	private AppointmentSevice service;

	@GetMapping("/appoint")
	public String register(Model model) {
		Appointment appointment = new Appointment();
		model.addAttribute("appoint", appointment);
		return "appoint";
	}

	@PostMapping("/appointUser")
	public String registerUser(@ModelAttribute("appoint") Appointment appointment,Model model) {
		service.register(appointment);
		model.addAttribute("message","Appointment registered Successfully");
	
		return "appoint";
	
	}

}
