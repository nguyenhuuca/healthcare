package com.canh.healthcare.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Patient_Bill_Items")
public class PatientBillItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int itemId;
	String name;
	String uniPrice;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	@Column(name = "item_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "unit_price")
	public String getUniPrice() {
		return uniPrice;
	}
	public void setUniPrice(String uniPrice) {
		this.uniPrice = uniPrice;
	}
	
}
