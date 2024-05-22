package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Order;
import com.example.demo.dto.User;
import com.example.demo.dto.StatusEnum;
/**
 * Clase utilizada como servicio para los pedidos
 * @author Alfonso
 * @version 1.0
 * @see Pedidos
 */
@Service
public class OrderService {
	
	
	/** Lista con los pedidos */
	private ArrayList<Order> orders;

	/** Servicio del usuario requerido en éste */
	@Autowired
	private UserService userService = new UserService();

	
	
	
	/**
	 * Constructor no parametrizado que instancia la lista y añade varios pedidos de prueba
	 */
	public OrderService() {

		orders = new ArrayList<>();

		Order o = new Order(102.20, StatusEnum.CREADO, LocalDate.of(2024, 4, 16), userService.crearUser(new User("Juan", "Ferrer", 637485910L, "juanix@goats.com", "Calle Real 321 Caravaca")));
		orders.add(o);

		o = new Order(20.29, StatusEnum.CREADO, LocalDate.of(2024, 3, 10), userService.crearUser(new User("Cipri", "Garcia", 722839471L, "cipriano@goats.com", "Calle Ejemplo 123 Molina")));
		orders.add(o);

		o = new Order(57.93, StatusEnum.CREADO, LocalDate.of(2024, 4, 21), userService.crearUser(new User("Junior", "Chipantashi", 671625339L, "yuniol@goats.com", "Calle Annia 54 Calasparra")));
		orders.add(o);

		o = new Order(76.12, StatusEnum.CREADO, LocalDate.of(2024, 4, 12), userService.crearUser(new User("Victor", "Vivo", 635109482L, "pirri@goats.com", "Calle Pirri 12 Pliego")));
		orders.add(o);

		o = new Order(1432.39, StatusEnum.CREADO, LocalDate.of(2024, 4, 18), userService.crearUser(new User("Mateo", "Fernandez", 736483901L, "mateofo@goats.com", "Calle Diosa 1 Bullas")));
		orders.add(o);

	}

	
	/**
	 * Método que busca un pedido a partir de su ID
	 * @param id ID del pedido
	 * @return Pedido buscado o <code>NULL</code>
	 */
	public Order buscarOrder(Long id) {
		for (Order o : orders) {

			if (o.getId() == id) {

				return o;

			}

		}
		return null;

	}

	
	/**
	 * Método que recibe id y estado del pedido y lo procesa (cambia su estado)
	 * @param id ID del pedido
	 * @param estado Estado del pedido
	 * @return  <code>TRUE</coode> en caso de cambiar el estado del pedido correctamente,
	 * <code>FALSE</code> en caso de que se intente cambiar el estado al mismo estado.
	 */
	public boolean procesarOrder(Long id, StatusEnum estado) {

		Order o = buscarOrder(id);

		if (o.getEstado() != estado) {

			o.setEstado(estado);
			return true;

		}

		return false;
	}

	
	/**
	 * Método que crea un pedido y lo añade a la lista
	 * @param o Pedido a añadir
	 * @return Pedido añadido a la lista
	 */
	public Order crearOrder(Order o) {

		orders.add(o);

		return o;
	}


	
	/**
	 * Método que elimina un pedido de la lista
	 * @param id
	 * @return <code>TRUE</coode> en caso de eliminar el pedido correctamente,
	 * <code>FALSE</code> en caso haber sido procesado anteriormente o no haber sido posible elimiminarlo.
	 */
	public boolean borrarOrder(Long id) {

		Order o = buscarOrder(id);

		if (o.getEstado() != StatusEnum.PROCESADO && o.getEstado() != StatusEnum.ENVIADO) {

			o.setEstado(StatusEnum.BORRADO);
			return orders.remove(o);

		}

		return false;

	}

	
	/**
	 * Método que muestra la lista de pedidos totales
	 * @return Lista de pedidos
	 */
	public ArrayList<Order> verOrders() {

		return this.orders;

	}
	
	/**
	 * Método que muestra una lista con todos los pedidos de un usuario en concreto
	 * @param id ID del usuario propietario de los pedidos a mostrar
	 * @return Lista con todos los pedidos del usuario
	 */
	public ArrayList<Order> verOrdersPorUsuario(Long id){
	
		ArrayList<Order> res = new ArrayList<>();
		
		for (Order o : orders) {
			
			if(o.getUser().getId() == id) {
				res.add(o);
			}

		}
		
		return res;
		
	}

}
