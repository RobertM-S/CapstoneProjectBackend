package com.example.fooddelivery.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.fooddelivery.entity.Food;
import com.example.fooddelivery.entity.Menu;

public interface MenuRepo extends JpaRepository<Menu, Integer> {

	  @Query(value = "select menu.mid, menu.fid, menu.rid, menu.price, menu.image from menu where rid = ? and fid = ?;", nativeQuery = true)
	  List<Menu> getMenuByRidAndFid(int rid, int fid);
	
}
