package com.example.fooddelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fooddelivery.entity.Food;
import com.example.fooddelivery.entity.Foodtype;
import com.example.fooddelivery.repo.FoodRepo;
import com.example.fooddelivery.repo.FoodtypeRepo;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FoodtypeService {
	
	@Autowired
	private FoodtypeRepo foodtyperepo;
	
	public long getTotalFoodtypeCount() {
		return foodtyperepo.count();
	}
	
	public List<Foodtype> getAllFoodtypes(){
		return foodtyperepo.findAll();
	}
	
	public Foodtype addNewFoodtype(Foodtype foodtype) {
		if(foodtyperepo.existsById(foodtype.getCsid())) {
			throw new EntityExistsException("Cannot add "+foodtype.getCsid()+" already exists");
		}
		return foodtyperepo.save(foodtype);
	}
	
	public Foodtype updateFoodtype(Foodtype foodtype){
		if(!foodtyperepo.existsById(foodtype.getCsid()))
			throw new EntityNotFoundException("cannot update "+foodtype.getCsid()+" does not exist");
		return foodtyperepo.save(foodtype);
	}
	
	public boolean deleteFoodtype(int id){
		if(!foodtyperepo.existsById(id))
			throw new EntityNotFoundException("cannot delete "+id+" does not exist");
		foodtyperepo.deleteById(id);
		return true;
	}
	
	public Foodtype getFoodtypeById(int id){
		if(!foodtyperepo.existsById(id))
			throw new EntityNotFoundException(id+" not found");
		return foodtyperepo.findById(id).get();
	}
	
}
