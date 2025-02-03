package com.example.fooddelivery.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Foodtype {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int csid;
	private String foodtype;
	
    @OneToMany(mappedBy = "foodtype")
    Set<Cuisine> cuisine;
	
	Foodtype() {}

	public Foodtype(int csid, String foodtype) {
		super();
		this.csid = csid;
		this.foodtype = foodtype;
	}

	public int getCsid() {
		return csid;
	}

	public void setCsid(int csid) {
		this.csid = csid;
	}

	public String getFoodtype() {
		return foodtype;
	}

	public void setFoodtype(String foodtype) {
		this.foodtype = foodtype;
	}

	@Override
	public String toString() {
		return "Foodtype [csid=" + csid + ", foodtype=" + foodtype + "]";
	}
}
