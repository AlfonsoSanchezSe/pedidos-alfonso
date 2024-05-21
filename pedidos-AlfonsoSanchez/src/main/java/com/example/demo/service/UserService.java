package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.dto.User;

@Service
public class UserService {

	private static ArrayList<User> users = new ArrayList<>();

	public UserService() {

		


	}

	public User buscarUser(Long id) {

		for (User u : users) {

			if (u.getId() == id) {

				return u;

			}

		}
		return null;
	}
	
	
	public User crearUser(User u) {
		
		
		users.add(u);
		return u;
		
	}
	
	
	public boolean eliminarUser(Long id) {
		
		User u = buscarUser(id);
		
		return users.remove(u);
		
	}
	
	public ArrayList<User> verUsers() {

		return users;
	
	}
	

}
