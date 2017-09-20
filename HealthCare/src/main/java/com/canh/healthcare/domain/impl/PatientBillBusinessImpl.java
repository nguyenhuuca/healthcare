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
import com.canh.healthcare.utils.ResultInfo;

public class PatientBillBusinessImpl implements PatientBillBusiness {
	PatientBillService service = PatientBillServiceImpl.getInstance();
	PatientBusiness patientServcie = new PatientBusinessImpl();

	@Override
	public void create(PatientBillDto patientBillDto, PatientDto patientDto) {
		PatientBill patientBill = convertToPatientBill(patientBillDto);
		// int patientBillId = service.create(patientBill);
		ResultInfo resultInfo = service.create(patientBill);
		int patientBillId = ((PatientBill) resultInfo.getObject()).getPatientBillId();
		for (int i = 0; i < patientDto.getPattientRecords().size(); i++) {
			patientDto.getPattientRecords().get(i).setPatientBillId(patientBillId);

		}
		patientServcie.update(patientDto);

	}

	@Override
	public void update(PatientBillDto patientBilDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public PatientBillDto searchPatientBillById(int id) {
		PatientBill patientBill = service.findById(id);
		return convertToPatientBillDto(patientBill);
	}

	public static PatientBill convertToPatientBill(PatientBillDto patientBillDto) {
		PatientBill patientBill = new PatientBill(patientBillDto);
		List<PatientBillDetails> patientBillDetailList = new ArrayList<PatientBillDetails>();
		for (PatientBillDetailsDto patientBillDetailDto : patientBillDto.getPatientBillDetails()) {
			PatientBillDetails patientBillDetail = convertToPatientBillDetail(patientBillDetailDto);
			patientBillDetailList.add(patientBillDetail);
		}
		patientBill.setPatientBillDetails(patientBillDetailList);
		return patientBill;
	}

	public static PatientBillDetails convertToPatientBillDetail(PatientBillDetailsDto patientDetailDto) {
		PatientBillDetails billDetail = new PatientBillDetails();
		Medicine medicine = new Medicine(patientDetailDto.getMedicine());
		PatientBill patientBill = new PatientBill();
		billDetail.setMedicine(medicine);
		billDetail.setPatientBill(patientBill);
		billDetail.setQuantity(patientDetailDto.getQuantity());
		return billDetail;

	}

	public static PatientBillDetailsDto convertToPatientBillDetailDto(PatientBillDetails patientBillDetail) {
		PatientBillDetailsDto patientBillDetailsDto = new PatientBillDetailsDto();
		patientBillDetailsDto.setQuantity(patientBillDetail.getQuantity());
		//patientBillDetailsDto.setPatientBill(PatientBillBusinessImpl.convertToPatientBillDto(patientBillDetail.getPatientBill()));
		patientBillDetailsDto.setMedicine(MedicineBusinessImpl.convertToMedicineDto(patientBillDetail.getMedicine()));
		return patientBillDetailsDto;

	}

	public static PatientBillDto convertToPatientBillDto(PatientBill patientBill) {
		PatientBillDto patientBillDto = new PatientBillDto();
		patientBillDto.setCreateDate(patientBill.getCreateDate());
		patientBillDto.setPatientBillId(patientBill.getPatientBillId());
		patientBillDto.setPatient(PatientBusinessImpl.convertToPatientDto(patientBill.getPatient()));
		List<PatientBillDetailsDto> patientBillDetailDtoLst = new ArrayList<PatientBillDetailsDto>();
		for (PatientBillDetails patientBillDetail : patientBill.getPatientBillDetails()) {
			PatientBillDetailsDto patientBillDetailsDto = convertToPatientBillDetailDto(patientBillDetail);
			patientBillDetailDtoLst.add(patientBillDetailsDto);
		}
		patientBillDto.setPatientBillDetails(patientBillDetailDtoLst);
		return patientBillDto;
	}

}
