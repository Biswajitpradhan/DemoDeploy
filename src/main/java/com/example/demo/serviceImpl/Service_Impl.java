package com.example.demo.serviceImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.UserDetails;
import com.example.demo.Repository.UserDetailsRepo;
import com.example.demo.services.MainService;



@Service
public class Service_Impl implements MainService{
		

	
	private UserDetailsRepo ud;
	
	
	public Service_Impl(UserDetailsRepo ud) {
	
		this.ud = ud;
	}


	@Override
	public Optional<UserDetails> checkUser(String mail, String pass) {
		// TODO Auto-generated method stub
		return ud.findByEmailAndPassword(mail, pass);
		
	
	}

}
