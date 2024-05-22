package com.example.demo;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Order;
import com.example.demo.dto.StatusEnum;
import com.example.demo.dto.User;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;
/**
 * Clase de controlador de la aplicacion de gestion de pedidos
 * @author Alfonso
 * @version 1.0
 */
@RestController
public class AppController {

	/** Servicio de pedidos */
	@Autowired
	private OrderService orderService;
	
	/** Servicio de usuarios */
	@Autowired
	private UserService userService;
	
	
	/**
	 * Método peticion de tipo <code>GET</code> que devuelve un pedido buscado
	 * @param id ID del pedido buscado
	 * @return Pedido buscado
	 */
	@GetMapping("/getOrder") 
	public Order getOrder(@RequestParam Long id) {

		return orderService.buscarOrder(id);

	}

	
	/**
	 * Método petición de tipo <code>POST</code> que crea un pedido
	 * @param o Pedido completo a crear
	 * @return Pedido creado
	 */
	@PostMapping("/createOrder")
	public Order createOrder(@RequestBody Order o) {

		userService.crearUser(o.getUser());
		return orderService.crearOrder(o);

	}
	
	/**
	 * Método petición de tipo <code>POST</code> que crea un pedido y un usuario nuevo
	 * @param precio Precio del pedido
	 * @param firstNameUser Nombre del usuario dueño del pedido
	 * @param lastNameUser Apellido del usuario dueño del pedido
	 * @param phoneUser Número de telefono del usuario dueño del pedido
	 * @param mailUser Correo electrónico del usuario dueño del pedido
	 * @param addressUser Dirección del usuario dueño del pedido
	 * @return Pedido creado
	 */
	@PostMapping("/createOrderWParams") 
	public Order createOrder(@RequestBody @RequestParam double precio, @RequestParam String firstNameUser,
			@RequestParam String lastNameUser, @RequestParam Long phoneUser,
			@RequestParam String mailUser, @RequestParam String addressUser) {

		return orderService.crearOrder(new Order(precio, StatusEnum.CREADO, LocalDate.now(),
				userService.crearUser(new User(firstNameUser, lastNameUser, phoneUser, mailUser, addressUser))));

	}
	
	
	/**
	 * Método petición de tipo <code>POST</code> que crea un pedido con un usuario ya existente
	 * @param precio Precio del pedido
	 * @param userID ID del usuario ya existente dueño del pedido
	 * @return Pedido creado
	 */
	@PostMapping("/createOrderWithUserId")
	public Order createOrderWUserId(@RequestParam double precio, @RequestParam Long userID) {

		return orderService.crearOrder(new Order(precio, StatusEnum.CREADO, LocalDate.now(), userService.buscarUser(userID)));

	}
	

	/**
	 * Método petición de tipo <code>PUT</code> que modifica el estado de un pedido
	 * @param id ID del pedido
	 * @param estado Estado del pedido
	 * @return <code>TRUE</coode> en caso de modificar el estado del pedido correctamente,
	 * <code>FALSE</code> en caso de que se intente cambiar al mismo estado.
	 */
	@PutMapping("/processOrder")
	public boolean processOrder(@RequestParam Long id, @RequestParam StatusEnum estado) {

		return orderService.procesarOrder(id, estado);

	}
	
	
	/**
	 * Método petición de tipo <code>DELETE</code> que elimina un pedido en caso de no haber sido procesado.
	 * @param id ID del pedido
	 * @return <code>TRUE</coode> en caso de eliminar el pedido correctamente,
	 * <code>FALSE</code> en caso haber sido procesado anteriormente o no haber sido posible elimiminarlo.
	 */
	@DeleteMapping("/deleteOrder") //Elimina el pedido
	public boolean deleteOrder(@RequestParam Long id) {

		return orderService.borrarOrder(id);

	}

	/**
	 * Método petición de tipo <code>GET</code> que muestra todos los pedidos existentes
	 * @return Lista con todos los pedidos
	 */
	@GetMapping("/getAllOrders") //Visualiza la lista de pedidos
	public ArrayList<Order> getAllOrders() {

		return orderService.verOrders();

	}

	
	/**
	 * Método petición de tipo <code>POST</code> que crea un nuevo usuario
	 * @param u Usuario a crear
	 * @return Nuevo usuario creado
	 */
	@PostMapping("/createUser") //Crea un usuario con body
	public User createUser(@RequestBody User u) {
		
		return userService.crearUser(u);
		
	}
	
	/**
	 * Método petición de tipo <code>GET</code> que muestra los datos de un usuario
	 * @param id ID del usuario
	 * @return Datos del usuario
	 */
	@GetMapping("/getUser")
	public User getUser(@RequestParam Long id) {
		
		return userService.buscarUser(id);
		
	}
	
	/**
	 * Método petición de tipo <code>DELETE</code> que elimina a un usuario
	 * @param id ID del usuario
	 * @return <code>TRUE</coode> en caso de eliminar el usuario correctamente,
	 * <code>FALSE</code> en caso contrario.
	 */
	@DeleteMapping("/deleteUser")
	public boolean deleteUser(Long id) {
		
		return userService.eliminarUser(id);
		
	}
	
	/**
	 * Método petición de tipo <code>GET</code> que muestra una lista con todos los pedidos de un usuario
	 * @param id ID del usuario
	 * @return Pedidos del usuario
	 */
	@GetMapping("/getOrdersByUserId")
	public ArrayList<Order> getOrdersByUserId(@RequestParam Long id){
		
		return orderService.verOrdersPorUsuario(id);
		
	}
	
	/**
	 * Método petición de tipo <code>GET</code> que muestra todos los usuarios
	 * @return Lista con todos los usuarios
	 */
	@GetMapping("/getAllUsers")
	public ArrayList<User> getAllUsers(){
		
		return userService.verUsers();
		
	}

}
