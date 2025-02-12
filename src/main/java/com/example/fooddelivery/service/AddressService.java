package com.example.fooddelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fooddelivery.entity.Address;
import com.example.fooddelivery.entity.Food;
import com.example.fooddelivery.repo.AddressRepo;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;


@Service
public class AddressService {
	
	@Autowired
	private AddressRepo addressrepo;
	
	public List<Address> getAllAddresses(){
		return addressrepo.findAll();
	}
	
	public Address addNewAddress(Address address) {
		if(addressrepo.existsById(address.getAddressid())) {
			throw new EntityExistsException("Cannot add "+address.getAddressid()+" already exists");
		}
		return addressrepo.save(address);
	}
	
	public Address updateAddress(Address address){
		if(!addressrepo.existsById(address.getAddressid()))
			throw new EntityNotFoundException("cannot update "+address.getAddressid()+" does not exist");
		return addressrepo.save(address);
	}
	
	public boolean deleteAddress(int id){
		if(!addressrepo.existsById(id))
			throw new EntityNotFoundException("cannot delete "+id+" does not exist");
		addressrepo.deleteById(id);
		return true;
	}
	
	public Address getAddressById(int id){
		if(!addressrepo.existsById(id))
			throw new EntityNotFoundException(id+" not found");
		return addressrepo.findById(id).get();
	}
	
	public List<Address> getAddressByUid(int uid){
		return addressrepo.findByUid(uid);
	}
	
	
}
