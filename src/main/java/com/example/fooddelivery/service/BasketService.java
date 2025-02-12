package com.example.fooddelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fooddelivery.entity.Address;
import com.example.fooddelivery.entity.Basket;
import com.example.fooddelivery.entity.BasketEdit;
import com.example.fooddelivery.entity.Food;
import com.example.fooddelivery.repo.AddressRepo;
import com.example.fooddelivery.repo.BasketRepo;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;


@Service
public class BasketService {
	
	@Autowired
	private BasketRepo basketrepo;
	
	public List<Basket> getAllBaskets(){
		return basketrepo.findAll();
	}
	
	public Basket addNewBasket(Basket basket) {
		Basket basket2 = basketrepo.findByFidAndRidAndUid(basket.getFid(), basket.getRid(), basket.getUid());
		if(basket2 == null) {
			return basketrepo.save(basket);
		}
		basket.setQuantity(basket2.getQuantity() + basket.getQuantity());
		basket.setTotalprice(basket2.getTotalprice() + basket.getTotalprice());
		basket.setBid(basket2.getBid());
		return basketrepo.save(basket);
	}
	
	public Basket updateBasket(Basket basket){
		if(!basketrepo.existsById(basket.getBid()))
			throw new EntityNotFoundException("cannot update "+basket.getBid()+" does not exist");
		return basketrepo.save(basket);
	}
	
	public boolean deleteBasket(int id){
		if(!basketrepo.existsById(id))
			throw new EntityNotFoundException("cannot delete "+id+" does not exist");
		basketrepo.deleteById(id);
		return true;
	}
	
	public Basket getBasketById(int id){
		if(!basketrepo.existsById(id))
			throw new EntityNotFoundException(id+" not found");
		return basketrepo.findById(id).get();
	}
	
	public boolean deleteByUser(int id) {
		Basket[] basketList = basketrepo.findByUid(id);
		for(Basket basket : basketList) {
			basketrepo.deleteById(basket.getBid());
		}
		return true;
	}
	
	public Basket editBasket(BasketEdit checkout) {
		if(checkout.getQuantity() == 0) {
			Basket basket2 = basketrepo.findByFidAndRidAndUid(checkout.getFid(), checkout.getRid(), checkout.getUid());
			basketrepo.deleteById(basket2.getBid());
			return null;
		}
		Basket basket2 = basketrepo.findByFidAndRidAndUid(checkout.getFid(), checkout.getRid(), checkout.getUid());
		Basket basket = new Basket(basket2.getBid(), checkout.getQuantity(), checkout.getTotalprice(), checkout.getFid(), checkout.getUid(), checkout.getRid());
		return basketrepo.save(basket);
	}
	
}
