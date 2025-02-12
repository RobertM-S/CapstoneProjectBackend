package com.example.fooddelivery.entity;

public class BasketEdit {

	private int fid;
	private int uid;
	private int rid;
	private int quantity;
	private int totalprice;
	
	public BasketEdit() {}
	
	public BasketEdit(int fid, int uid, int rid, int quantity, int totalprice) {
		super();
		this.fid = fid;
		this.uid = uid;
		this.rid = rid;
		this.quantity = quantity;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	@Override
	public String toString() {
		return "BasketEdit [fid=" + fid + ", uid=" + uid + ", rid=" + rid + ", quantity=" + quantity + ", totalprice=" + totalprice+ "]";
	}
	
}
