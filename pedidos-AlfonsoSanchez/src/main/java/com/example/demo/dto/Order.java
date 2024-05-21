package com.example.demo.dto;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.UserService;


/**
 * Clase pedido con los datos posibles de un pedido para su gestion
 * @author Alfonso
 * @version 1.0
 */
public class Order {

	/** ID del pedido*/
	private Long id;
	
	/** Precio del pedido*/
	private double precio;
	
	/** Estado del pedido*/
	private StatusEnum estado;
	
	/** Fecha de realzación del pedido */
	private LocalDate fechaPedido;

	/** Usuario asignado al pedido */
	private User user;

	/** Variable de clase utilizada para la asignacion de IDs auto incrementales  */
	private static Long idActual = 0L;

	
	/**
	 * Constructor parametrizado que recibe todos los atributos a excepción
	 * del ID que crea el pedido y establece el ID
	 * @param precio Precio del pedido
	 * @param estado Estado del pedido
	 * @param fecha Fecha de realzación del pedido
	 * @param user Usuario asignado al pedido
	 */
	public Order(double precio, StatusEnum estado, LocalDate fecha, User user) {

		this.id = ++idActual;
		this.precio = precio;
		this.estado = estado;
		this.fechaPedido = fecha;
		this.user = user;

	}

	
	/**
	 * Método que devuelve el ID del pedido
	 * @return ID del pedido
	 */
	public Long getId() {
		return id;
	}

	
	/**
	 * Método que devuelve el precio del pedido
	 * @return precio del pedido
	 */
	public double getPrecio() {
		return precio;
	}

	
	/**
	 * Método que recibe y establece el precio del pedido
	 * @param precio Precio del pedido
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
	/**
	 * Método que devuelve el estado del pedido
	 * @return estado del pedido
	 */
	public StatusEnum getEstado() {
		return estado;
	}

	
	/**
	 * Método que recibe y establece el estado del pedido
	 * @param estado Estado del pedido
	 */
	public void setEstado(StatusEnum estado) {
		this.estado = estado;
	}

	
	/**
	 * Método que devuelve la fecha de realización del pedido
	 * @return fecha de realización del pedido
	 */
	public LocalDate getFechaPedido() {
		return fechaPedido;
	}

	
	/**
	 * Método que recibe y establece la fecha de realización del pedido
	 * @param fechaPedido Fecha de realización del pedido
	 */
	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}



	/**
	 * Método que devuelve el usuario asignado al pedido
	 * @return usuario asignado al pedido
	 */
	public User getUser() {

		return user;
	}

	
	/**
	 * Método que recibe y establece el usuario asignado al pedido
	 * @param user Usuario asignado al pedido
	 */
	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	/**
     * Metodo que devuelve los datos del pedido
     * @return Cadena de texto con los datos del pedido
     */
	@Override
	public String toString() {
		return "Order [id=" + id + ", precio=" + precio + ", estado=" + estado + ", fechaPedido=" + fechaPedido
				+ ", user=" + user + "]";
	}

}
