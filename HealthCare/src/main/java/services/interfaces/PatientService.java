package services.interfaces;

import com.canh.healthcare.model.Patient;

public interface PatientService {
	public void create();
	public void update();
	public Patient findPatientById(int id);

}
