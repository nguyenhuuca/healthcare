package com.canh.healthcare.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.canh.healthcare.model.MedicineDto;

@Entity
@Table(name = "medicine")
@NamedNativeQueries({
	@NamedNativeQuery(name = "findMedicineById",query = " select * from Medicine p where p.medicineId = :medicineId ",resultClass = Medicine.class
	)
})
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int medicineId;
	String name;
	String unit;
	Long unitPriceBuy;
	Long unitPriceSell;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "medicine")
	List<PatientBillDetails> patientBillDetails = new ArrayList<PatientBillDetails>();
	
	public Medicine(){
		
	}
	public Medicine(MedicineDto medicineDto){
		if(medicineDto.getId()!=0){
			this.medicineId = medicineDto.getId();
		}
		this.name = medicineDto.getName();
		this.unit =  medicineDto.getUnit();
		this.unitPriceBuy = medicineDto.getUnitPriceSell();
		this.unitPriceSell = medicineDto.getUnitPriceSell();
	}

	public int getId() {
		return medicineId;
	}

	public void setId(int id) {
		this.medicineId = id;
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
	public List<PatientBillDetails> getPatientBillDetails() {
		return patientBillDetails;
	}
	public void setPatientBillDetails(List<PatientBillDetails> patientBillDetails) {
		this.patientBillDetails = patientBillDetails;
	}
	

}
