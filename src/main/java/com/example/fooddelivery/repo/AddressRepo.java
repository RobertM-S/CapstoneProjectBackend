package com.example.fooddelivery.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.fooddelivery.entity.Address;
import com.example.fooddelivery.entity.Food;

public interface AddressRepo extends JpaRepository<Address, Integer> {

	  @Query(value = "select address.aid, address.city, address.postcode, address.street, address.number from address join useraddress on address.aid = useraddress.aid where useraddress.uid = ?;", nativeQuery = true)
	  List<Address> findByUid(int uid);
	  	
	
}
