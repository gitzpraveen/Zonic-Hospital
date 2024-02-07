package com.ty.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.Entity.Appointment;
import com.ty.Repo.AppointmentRepository;
import com.ty.Service.AppointmentSevice;

@Service
public class AppointmentImpl implements AppointmentSevice {

	@Autowired
	private AppointmentRepository repository;
	
	@Override
	public void register(Appointment appointment) 
	{
		repository.save(appointment);
		
		
	}

}
