package com.example.fooddelivery.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.fooddelivery.entity.Checkout;
import com.example.fooddelivery.entity.Food;
import com.example.fooddelivery.entity.Restaurant;

public interface FoodRepo extends JpaRepository<Food, Integer> {

	  @Query(value = "select menu.mid, f.fid, f.foodname, f.description, menu.image, menu.price from food f join menu on menu.fid = f.fid;", nativeQuery = true)
	  List<Food> getAllFoods();
	  
	  @Query(value = "select menu.mid, f.fid, f.foodname, f.description, menu.image, menu.price from food f join menu on menu.fid = f.fid where f.fid=?;", nativeQuery = true)
	  Food getFood(int id);
	  
	  @Query(value = "select menu.mid, f.fid, f.foodname, menu.image, menu.price, quantity, totalprice, menu.rid from basket join food f on basket.fid = f.fid join menu on menu.fid = f.fid and menu.rid = basket.rid where basket.uid=?;", nativeQuery = true)
	  List<Checkout> getFoodFromBasket(int id);
	  
	  @Query(value = "select menu.mid, f.fid, f.foodname, f.description, menu.image, menu.price from food f join menu on f.fid = menu.fid where menu.rid = ? and f.fid = ?;", nativeQuery = true)
	  Food getMenuDetails(int rid, int fid);
	
}
