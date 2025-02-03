package com.example.fooddelivery.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fooddelivery.entity.Food;
import com.example.fooddelivery.entity.Foodtype;
import com.example.fooddelivery.entity.Orders;
import com.example.fooddelivery.service.FoodService;
import com.example.fooddelivery.service.FoodtypeService;
import com.example.fooddelivery.service.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrdersRestController {
	
	@Autowired
	private OrdersService ordersService;
	
	@GetMapping
	public List<Orders> getOrderss(){
		return ordersService.getAllOrderss();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOrdersById(@PathVariable int id){
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("orders", ordersService.getOrdersById(id));
			return ResponseEntity.ok(map);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(map);
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> addOrders(@RequestBody Orders orders){
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("orders", ordersService.addNewOrders(orders));
			return ResponseEntity.ok(map);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(map);
		}
	}
	
	@PutMapping
	public ResponseEntity<Object> updateOrders(@RequestBody Orders orders){
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("orders", ordersService.updateOrders(orders));
			return ResponseEntity.ok(map);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(map);
		}
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Object> deleteOrders(@PathVariable int id){
		Map<String, Object> map = new HashMap<>();
		try {
			if(ordersService.deleteOrders(id)) {
				map.put("message", "Orders deleted successfully");
				return ResponseEntity.ok(map);
			}
		}
		catch (RuntimeException e){
			map.put("error",e.getMessage());
		}
		return ResponseEntity.badRequest().body(map);
	}

}
