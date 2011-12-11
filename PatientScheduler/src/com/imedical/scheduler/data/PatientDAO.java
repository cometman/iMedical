package com.imedical.scheduler.data;

import java.util.ArrayList;
import java.util.List;

import com.imedical.scheduler.common.DataTestSets;
import com.imedical.scheduler.common.UnitTest;

public class PatientDAO implements IPatientDAO {

	private List<PatientVO> patients = new ArrayList<PatientVO>();
	
	//Test Data
	
	

	public List<PatientVO> getPatientByString(String searchQuery) {
		return null;
	}

	public List<PatientVO> getAllPatients() {
		DataTestSets testData = new DataTestSets();
		patients.addAll(testData.getTestPatients());
		return patients;
	}

	public void addNewPatient(PatientVO patient) {
		patients.add(patient);
	}

}
