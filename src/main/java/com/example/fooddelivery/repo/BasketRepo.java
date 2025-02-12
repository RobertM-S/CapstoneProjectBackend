package com.example.fooddelivery.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.fooddelivery.entity.Address;
import com.example.fooddelivery.entity.Basket;
import com.example.fooddelivery.entity.Restaurant;
import com.example.fooddelivery.entity.User;

public interface BasketRepo extends JpaRepository<Basket, Integer> {

	  @Modifying
	  @Query(value = "delete from basket where uid=?;", nativeQuery = true)
	  void deleteByUser(int uid);	
	  
	  void deleteByUid(int uid);

	  Basket findByFidAndRidAndUid(int fid, int rid, int uid);
	  
	  Basket[] findByUid(int uid);
	  
}
