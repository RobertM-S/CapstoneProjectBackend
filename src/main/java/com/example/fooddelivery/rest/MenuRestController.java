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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fooddelivery.entity.Food;
import com.example.fooddelivery.entity.Menu;
import com.example.fooddelivery.service.FoodService;
import com.example.fooddelivery.service.MenuService;

@RestController
@RequestMapping("/menus")
public class MenuRestController {
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping
	public List<Menu> getMenus(){
		return menuService.getAllMenus();
	}

}
