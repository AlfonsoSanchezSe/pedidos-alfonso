package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.dto.User;

/**
 * Clase utilizada como servicio para los usuarios
 * @author Alfonso
 * @version 1.0
 * @see User
 */
@Service
public class UserService {

	
	/** Variable de clase que contiene la lista de los usuarios */
	private static ArrayList<User> users = new ArrayList<>();

	
	/** 
	 * Constructor predeterminado vacio
	 */
	public UserService() {

		


	}

	
	
	/**
	 * Método que busca un usuario en la lista por su ID
	 * @param id ID del usuario buscado
	 * @return Usuario encontrado o <code>NULL</code>
	 */
	public User buscarUser(Long id) {

		for (User u : users) {

			if (u.getId() == id) {

				return u;

			}

		}
		return null;
	}
	
	
	/**
	 * Método que recibe un usuario y lo añade a la lista de usuarios
	 * @param u Usuario a añadir
	 * @return Usuario añadido 
	 */
	public User crearUser(User u) {
		
		
		users.add(u);
		return u;
		
	}
	
	
	
	/**
	 * Método que elimina un usuario de la lista
	 * @param id ID del usuario a eliminar
	 * @return <code>TRUE</coode> en caso de eliminar el usuario correctamente,
	 * <code>FALSE</code> en caso contrario.
	 */
	public boolean eliminarUser(Long id) {
		
		User u = buscarUser(id);
		
		return users.remove(u);
		
	}
	
	
	/**
	 * Métido que muestra todos los usuarios de la lista
	 * @return Lista de usuarios
	 */
	public ArrayList<User> verUsers() {

		return users;
	
	}
	

}
