package com.canh.healthcare.jpa.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.canh.healthcare.model.PatientDto;
@Entity
@Table(name = "patients")
@NamedNativeQueries({
	@NamedNativeQuery(name = "findPatientById",query = " select * from patients p where p.id = :idPatient ",resultClass = Patient.class
	),@NamedNativeQuery(name = "findPatientById2",query = " select * from patients p ",resultClass = Patient.class
			)
})
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String birthDay;
	boolean male;
	String address;
	String mobile;
	String familyContact;
	Date firstDateJoin = new Date();
	String urgentContact;
	List<PatientRecord> pattientRecords = new ArrayList<PatientRecord>();

	public Patient() {

	}
	public Patient(PatientDto patient) {
		this.address = patient.getAddress();
		this.birthDay = patient.getBirthDay();
		this.familyContact= patient.getFamilyContact();
		this.firstDateJoin = patient.getFirstDateJoin();
		this.male = patient.isMale();
		this.mobile = patient.getMobile();
		this.name = patient.getName();
		this.urgentContact = patient.getUrgentContact();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "patient_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "birth_date")
	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	@Column(name = "is_male")
	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "mobile")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "family_contact")
	public String getFamilyContact() {
		return familyContact;
	}

	public void setFamilyContact(String familyContact) {
		this.familyContact = familyContact;
	}

	@Column(name = "fish_date_join")
	public Date getFirstDateJoin() {
		return firstDateJoin;
	}

	public void setFirstDateJoin(Date firstDateJoin) {
		this.firstDateJoin = firstDateJoin;
	}

	@Column(name = "urgent_contact")
	public String getUrgentContact() {
		return urgentContact;
	}

	public void setUrgentContact(String urgentContact) {
		this.urgentContact = urgentContact;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	public List<PatientRecord> getPattientRecords() {
		return pattientRecords;
	}
	public void setPattientRecords(List<PatientRecord> pattientRecords) {
		this.pattientRecords = pattientRecords;
	}
	
}
