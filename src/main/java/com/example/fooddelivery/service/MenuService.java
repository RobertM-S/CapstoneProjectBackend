package com.example.fooddelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fooddelivery.entity.Food;
import com.example.fooddelivery.entity.Menu;
import com.example.fooddelivery.repo.FoodRepo;
import com.example.fooddelivery.repo.MenuRepo;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepo menurepo;
	
	public List<Menu> getAllMenus(){
		return menurepo.findAll();
	}
	
	public List<Menu> findPriceOfFood(int rid, int fid) {

		return menurepo.getMenuByRidAndFid(rid, fid);
	}
	
}
