package com.example.demo.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.UserDetails;



@Service
public interface MainService {
	public abstract Optional<UserDetails> checkUser(String mail,String pass);
}
