package com.ty.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.Entity.User;
import com.ty.Repo.UserRepository;
import com.ty.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public void register(User user) {
		userRepo.save(user);

	}

}
