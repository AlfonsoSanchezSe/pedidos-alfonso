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

@RestController
public class AppController {

	@Autowired
	private OrderService orderService;
	
	
	@Autowired
	private UserService userService;

	@GetMapping("/getOrder") //Busca un pedido
	public Order getOrder(@RequestParam Long id) {

		return orderService.buscarOrder(id);

	}

	
	// IDs generados automaticamente, no es necesario incluirlos en el body.
	@PostMapping("/createOrder") // Crea un pedido pasando el body
	public Order createOrder(@RequestBody Order o) {

		userService.crearUser(o.getUser());
		return orderService.crearOrder(o);

	}
	
	@PostMapping("/createOrderWParams") // Crea un pedido pasando sus parametros
	public Order createOrder(@RequestBody @RequestParam double precio, @RequestParam String firstNameUser,
			@RequestParam String lastNameUser, @RequestParam Long phoneUser,
			@RequestParam String mailUser, @RequestParam String addressUser) {

		return orderService.crearOrder(new Order(precio, StatusEnum.CREADO, LocalDate.now(),
				userService.crearUser(new User(firstNameUser, lastNameUser, phoneUser, mailUser, addressUser))));

	}
	
	
	@PostMapping("/createOrderWithUserId") //Crea un pedido con un usuario ya existente (no hay que crearlo junto al pedido)
	public Order createOrderWUserId(@RequestParam double precio, @RequestParam Long userID) {

		return orderService.crearOrder(new Order(precio, StatusEnum.CREADO, LocalDate.now(), userService.buscarUser(userID)));

	}


	@PutMapping("/processOrder") //Proccesa el pedido
	public boolean processOrder(@RequestParam Long id, @RequestParam StatusEnum estado) {

		return orderService.procesarOrder(id, estado);

	}

	@DeleteMapping("/deleteOrder") //Elimina el pedido
	public boolean deleteOrder(@RequestParam Long id) {

		return orderService.borrarOrder(id);

	}

	@GetMapping("/getAllOrders") //Visualiza la lista de pedidos
	public ArrayList<Order> getAllOrders() {

		return orderService.verOrders();

	}
	// IDs generados automaticamente, no es necesario incluirlos en el body.
	@PostMapping("/createUser") //Crea un usuario con body
	public User createUser(@RequestBody User u) {
		
		return userService.crearUser(u);
		
	}
	
	
	@GetMapping("/getUser") //Busca un usuario por su id
	public User getUser(@RequestParam Long id) {
		
		return userService.buscarUser(id);
		
	}
	
	@DeleteMapping("/deleteUser") //Elimina un usuario por su id
	public boolean deleteUser(Long id) {
		
		return userService.eliminarUser(id);
		
	}
	
	
	@GetMapping("/getOrdersByUserId") //Devuelve la lista de los pedidos realizados por un determinado usuario
	public ArrayList<Order> getOrdersByUserId(@RequestParam Long id){
		
		return orderService.verOrdersPorUsuario(id);
		
	}
	
	@GetMapping("/getAllUsers")
	public ArrayList<User> getAllUsers(){
		
		return userService.verUsers();
		
	}

}
