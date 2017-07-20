package com.canh.healthcare.domain.impl;

import java.util.ArrayList;
import java.util.List;

import com.canh.healthcare.domain.interfaces.PatientBillBusiness;
import com.canh.healthcare.jpa.entity.Medicine;
import com.canh.healthcare.jpa.entity.PatientBill;
import com.canh.healthcare.jpa.entity.PatientBillDetails;
import com.canh.healthcare.model.PatientBillDetailsDto;
import com.canh.healthcare.model.PatientBillDto;
import com.canh.healthcare.services.impl.PatientBillServiceImpl;
import com.canh.healthcare.services.interfaces.PatientBillService;

public class PatientBillBusinessImpl implements PatientBillBusiness {
	PatientBillService service = new PatientBillServiceImpl();

	@Override
	public void create(PatientBillDto patientBillDto) {
		PatientBill patientBill = convertToPatientBill(patientBillDto);
		service.create(patientBill);

	}

	@Override
	public void update(PatientBillDto patientBilDto) {
		// TODO Auto-generated method stub

	}

	public PatientBill convertToPatientBill(PatientBillDto patientBillDto) {
		PatientBill patientBill = new PatientBill(patientBillDto);
		List<PatientBillDetails> patientBillDetailList = new ArrayList<PatientBillDetails>();
		for (PatientBillDetailsDto patientBillDetailDto : patientBillDto.getPatientBillDetails()) {
			PatientBillDetails patientBillDetail = convertToPatientDetail(patientBillDetailDto);
			patientBillDetailList.add(patientBillDetail);
		}
		patientBill.setPatientBillDetails(patientBillDetailList);
		return patientBill;
	}

	public PatientBillDetails convertToPatientDetail(PatientBillDetailsDto patientDetailDto) {
		PatientBillDetails billDetail = new PatientBillDetails();
		Medicine medicine = new Medicine(patientDetailDto.getMedicine());
		PatientBill patientBill = new PatientBill();
		billDetail.setMedicine(medicine);
		billDetail.setPatientBill(patientBill);
		billDetail.setQuantity(patientDetailDto.getQuantity());
		return billDetail;

	}

}
