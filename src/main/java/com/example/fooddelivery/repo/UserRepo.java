package com.example.fooddelivery.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.fooddelivery.entity.Address;
import com.example.fooddelivery.entity.Food;
import com.example.fooddelivery.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	  @Query(value = "select a.aid, a.city, a.postcode, a.street, a.number from address a join useraddress on useraddress.aid = a.aid join user on user.uid = useraddress.uid where user.uid = ?;", nativeQuery = true)
	  List<Address> findAllAddressesOfUser(int userId);
	
	  List<User> findByUsername(String username);
}
