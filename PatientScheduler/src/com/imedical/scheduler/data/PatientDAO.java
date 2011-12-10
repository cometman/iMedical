package com.imedical.scheduler.data;

import java.util.ArrayList;
import java.util.List;

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
