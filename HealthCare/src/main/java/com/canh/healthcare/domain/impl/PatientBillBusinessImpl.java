package com.canh.healthcare.domain.impl;

import java.util.ArrayList;
import java.util.List;

import com.canh.healthcare.domain.interfaces.PatientBillBusiness;
import com.canh.healthcare.domain.interfaces.PatientBusiness;
import com.canh.healthcare.jpa.entity.Medicine;
import com.canh.healthcare.jpa.entity.PatientBill;
import com.canh.healthcare.jpa.entity.PatientBillDetails;
import com.canh.healthcare.model.PatientBillDetailsDto;
import com.canh.healthcare.model.PatientBillDto;
import com.canh.healthcare.model.PatientDto;
import com.canh.healthcare.services.impl.PatientBillServiceImpl;
import com.canh.healthcare.services.interfaces.PatientBillService;

public class PatientBillBusinessImpl implements PatientBillBusiness {
	PatientBillService service = PatientBillServiceImpl.getInstance();
	PatientBusiness patientServcie = new PatientBusinessImpl();

	@Override
	public void create(PatientBillDto patientBillDto, PatientDto patientDto) {
		PatientBill patientBill = convertToPatientBill(patientBillDto);
		int patientBillId = service.create(patientBill);
		for (int i = 0; i < patientDto.getPattientRecords().size(); i++) {
			patientDto.getPattientRecords().get(i).setPatientBillId(patientBillId);

		}
		patientServcie.update(patientDto);

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

	@Override
	public PatientBill searchPatientBillById(int id) {
		PatientBill patientBill = service.findById(id);
		return patientBill;
	}

}
