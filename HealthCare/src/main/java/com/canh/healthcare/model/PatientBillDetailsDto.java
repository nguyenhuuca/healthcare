package com.canh.healthcare.model;

public class PatientBillDetailsDto {
	MedicineDto medicine;
	//PatientBillDto patientBill;
	int quantity;
	int patientBillId;
	public MedicineDto getMedicine() {
		return medicine;
	}
	public void setMedicine(MedicineDto medicine) {
		this.medicine = medicine;
	}
	/*public PatientBillDto getPatientBill() {
		return patientBill;
	}
	public void setPatientBill(PatientBillDto patientBill) {
		this.patientBill = patientBill;
	}*/
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPatientBillId() {
		return patientBillId;
	}
	public void setPatientBillId(int patientBillId) {
		this.patientBillId = patientBillId;
	}
	
	
}
