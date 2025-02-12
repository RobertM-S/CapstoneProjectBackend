package com.example.fooddelivery.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Basket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid;
	private int quantity;
	private double totalprice;

    private int fid;
    
    private int uid;
    
    private int rid;

	public Basket() {}

	public Basket(int bid, int quantity, double totalprice, int fid, int uid, int rid) {
		super();
		this.bid = bid;
		this.quantity = quantity;
		this.totalprice = totalprice;
		this.fid = fid;
		this.uid = uid;
		this.rid = rid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}
	
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	@Override
	public String toString() {
		return "Basket [bid=" + bid + ", quantity=" + quantity + ", totalprice=" + totalprice + ", fid=" + fid
				+ ", uid=" + uid + ", rid=" + rid + "]";
	}

	
}
