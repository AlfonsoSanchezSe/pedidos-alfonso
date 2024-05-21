package com.example.demo.dto;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.UserService;

public class Order {

	private Long id;
	private double precio;
	private StatusEnum estado;
	private LocalDate fechaPedido;
	private User user;


	private static Long idActual = 0L;

	public Order(double precio, StatusEnum estado, LocalDate fecha, User user) {

		this.id = ++idActual;
		this.precio = precio;
		this.estado = estado;
		this.fechaPedido = fecha;
		this.user = user;

	}

	public Long getId() {
		return id;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public StatusEnum getEstado() {
		return estado;
	}

	public void setEstado(StatusEnum estado) {
		this.estado = estado;
	}

	public LocalDate getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	// Evitando aliasing
	public User getUser() {

		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", precio=" + precio + ", estado=" + estado + ", fechaPedido=" + fechaPedido
				+ ", user=" + user + "]";
	}

}
