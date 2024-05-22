package com.example.demo.dto;


/**
 * Clase base de usuario para la gestion de sus pedidos
 * @author Alfonso
 * @version 1.0
 */
public class User {
	
	/** ID del usuario */
	private Long id;
	
	/** Nombre del usuario */
	private String firstName;
	
	/** Apellido del usuario */
	private String lastName;
	
	/** Número de telefono del usuario */
	private Long phone;
	
	/** Correo electronico del usuario */
	private String mail;
	
	/** Dirección del usuario */
	private String address;

	
	/** Variable de clase utilizada para la asignacion de IDs auto incrementales  */
	private static Long idActU = 0L;

	/**
	 * Constructor parametrizado para la creacion del usuario y asignacion de su ID
	 * @param firstName Nombre del usuario
	 * @param lastName Apellido del usuario
	 * @param phone Número de telefono del usuario
	 * @param mail Correo electronico del usuario
	 * @param address Dirección del usuario
	 */
	public User(String firstName, String lastName, Long phone, String mail, String address) {
		this.id = ++idActU;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.mail = mail;
		this.address = address;
	}
	
	/**
	 * Método que devuelve el ID del usuario
	 * @return ID del usuario
	 */
	public Long getId() {
		return id;
	}

	
	/**
	 * Método que devuelve el nombre del usuario
	 * @return nombre del usuario
	 */
	public String getFirstName() {
		return firstName;
	}

	
	/**
	 * Método que recibe y establece el nombre del usuario
	 * @param firstName Nombre del usuario
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	/**
	 * Método que devuelve el apellido del usuario
	 * @return apellido del usuario
	 */
	public String getLastName() {
		return lastName;
	}

	
	/**
	 * Método que recibe y establece el apellido del usuario
	 * @param lastName Apellido del usuario
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	/**
	 * Método que devuelve el número de telefono del usuario
	 * @return número de telefono del usuario
	 */
	public Long getPhone() {
		return phone;
	}

	
	/**
	 * Método que recibe y establece el número de telefono del usuario
	 * @param phone Número de telefono del usuario
	 */
	public void setPhone(Long phone) {
		this.phone = phone;
	}

	
	/**
	 * Método que devuelve el correo electrónico del usuario
	 * @return correo electrónico del usuario
	 */
	public String getMail() {
		return mail;
	}

	
	/**
	 * Método que recibe y establece el correo electrónico del usuario
	 *@param mail Correo electrónico del usuario
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	
	/**
	 * Método que devuelve la dirección del usuario
	 * @return dirección del usuario
	 */
	public String getAddress() {
		return address;
	}

	
	/**
	 * Método que recibe y establece la dirección del usuario
	 * @param address Dirección del usuario
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	
	/**
	 * Método que devuelve los datos del cliente en una cadena de texto
	 * @return Cadeba de texto con los datos del cliente
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", mail="
				+ mail + ", address=" + address + "]";
	}

}
