package com.canh.healthcare.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medicine")
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String unit;
	Long unitPriceBuy;
	Long unitPriceSell;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name_medicine")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "unit")
	public String getUnit() {
		
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "unit_price_buy")
	public Long getUnitPriceBuy() {
		return unitPriceBuy;
	}

	public void setUnitPriceBuy(Long unitPriceBuy) {
		this.unitPriceBuy = unitPriceBuy;
	}

	@Column(name = "unit_price_sell")
	public Long getUnitPriceSell() {
		return unitPriceSell;
	}

	public void setUnitPriceSell(Long unitPriceSell) {
		this.unitPriceSell = unitPriceSell;
	}

}
