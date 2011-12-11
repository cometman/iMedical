package com.imedical.scheduler.data;

import java.util.ArrayList;
import java.util.List;

import com.imedical.scheduler.common.UnitTest;

public class PatientDAO implements IPatientDAO {

	private List<PatientVO> patients = new ArrayList<PatientVO>();
	

	public List<PatientVO> getPatientByString(String searchQuery) {
		return null;
	}

	public List<PatientVO> getAllPatients() {
		
		return patients;
	}

	public void addNewPatient(PatientVO patient) {
		patients.add(patient);
	}

}
