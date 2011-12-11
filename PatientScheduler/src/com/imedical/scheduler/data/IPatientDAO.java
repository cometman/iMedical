package com.imedical.scheduler.data;

import java.util.List;

public interface IPatientDAO {
	public List<PatientVO> getPatientByString(String searchQuery);
	public List<PatientVO> getAllPatients();
	public void addNewPatient(PatientVO patient);
}
