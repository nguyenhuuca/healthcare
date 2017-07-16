package com.canh.healthcare.model;

public class MedicineDto {
	int id;
	String name;
	String unit;
	Long unitPriceBuy;
	Long unitPriceSell;
	Long totaCost;
	int quantity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Long getUnitPriceBuy() {
		return unitPriceBuy;
	}
	public void setUnitPriceBuy(Long unitPriceBuy) {
		this.unitPriceBuy = unitPriceBuy;
	}
	public Long getUnitPriceSell() {
		return unitPriceSell;
	}
	public void setUnitPriceSell(Long unitPriceSell) {
		this.unitPriceSell = unitPriceSell;
	}
	
	public String toString(){
		return name;
	}
	public Long getTotaCost() {
		return unitPriceSell*quantity;
		
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

}
