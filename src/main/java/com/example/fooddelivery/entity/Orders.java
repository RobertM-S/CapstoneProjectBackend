package com.example.fooddelivery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oid;
	private int fid;
	private int rid;
	private Integer uid;
    private int orderblock;
    private double totalprice;
    private int quantity;
    
    public Orders() {}

	public Orders(int oid, int fid, int rid, Integer uid, int orderblock, double totalprice, int quantity) {
		super();
		this.oid = oid;
		this.fid = fid;
		this.rid = rid;
		this.uid = uid;
		this.orderblock = orderblock;
		this.totalprice = totalprice;
		this.quantity = quantity;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public int getOrderblock() {
		return orderblock;
	}

	public void setOrderblock(int orderblock) {
		this.orderblock = orderblock;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", fid=" + fid + ", rid=" + rid + ", uid=" + uid + ", orderblock=" + orderblock
				+ ", totalprice=" + totalprice + ", quantity=" + quantity + "]";
	}
    
}
