package com.example.fooddelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fooddelivery.entity.Address;
import com.example.fooddelivery.entity.User;
import com.example.fooddelivery.repo.UserRepo;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userrepo;
	
	public long getTotalUserCount() {
		return userrepo.count();
	}
	
	public List<User> getAllUsers(){
		return userrepo.findAll();
	}
	
	public User addNewUser(User user) {
		if(userrepo.existsById(user.getuid())) {
			throw new EntityExistsException("Cannot add "+user.getuid()+" already exists");
		}
		return userrepo.save(user);
	}
	
	public User updateUser(User user){
		if(!userrepo.existsById(user.getuid()))
			throw new EntityNotFoundException("cannot update "+user.getuid()+" does not exist");
		return userrepo.save(user);
	}
	
	public boolean deleteUser(int id){
		if(!userrepo.existsById(id))
			throw new EntityNotFoundException("cannot delete "+id+" does not exist");
		userrepo.deleteById(id);
		return true;
	}
	
	public User getUserById(int id){
		if(!userrepo.existsById(id))
			throw new EntityNotFoundException(id+" not found");
		return userrepo.findById(id).get();
	}
	
	public List<Address> findAllAddressesOfUser(int uid) {
		return userrepo.findAllAddressesOfUser(uid);
	}
	
}
