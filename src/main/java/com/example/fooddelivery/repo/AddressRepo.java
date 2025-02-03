package com.example.fooddelivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddelivery.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
