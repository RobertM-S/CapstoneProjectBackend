package com.example.fooddelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fooddelivery.entity.Checkout;
import com.example.fooddelivery.entity.Food;
import com.example.fooddelivery.repo.FoodRepo;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FoodService {
	
	@Autowired
	private FoodRepo foodrepo;
	
	public long getTotalFoodCount() {
		return foodrepo.count();
	}
	
	public List<Food> getAllFoods(){
		return foodrepo.getAllFoods();
	}
	
	public Food addNewFood(Food food) {
		if(foodrepo.existsById(food.getFoodid())) {
			throw new EntityExistsException("Cannot add "+food.getFoodid()+" already exists");
		}
		return foodrepo.save(food);
	}
	
	public Food updateFood(Food food){
		if(!foodrepo.existsById(food.getFoodid()))
			throw new EntityNotFoundException("cannot update "+food.getFoodid()+" does not exist");
		return foodrepo.save(food);
	}
	
	public boolean deleteFood(int id){
		if(!foodrepo.existsById(id))
			throw new EntityNotFoundException("cannot delete "+id+" does not exist");
		foodrepo.deleteById(id);
		return true;
	}
	
	public Food getFood(int id){
		if(!foodrepo.existsById(id))
			throw new EntityNotFoundException(id+" not found");
		return foodrepo.getFood(id);
	}
	
	public List<Checkout> getFoodFromBasket(int id) {
		return foodrepo.getFoodFromBasket(id);
	}
	
	public Food getMenuDetails(int rid, int fid) {
		return foodrepo.getMenuDetails(rid, fid);
	}
	
}
