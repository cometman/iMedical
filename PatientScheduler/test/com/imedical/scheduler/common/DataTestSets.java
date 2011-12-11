package com.imedical.scheduler.common;

import java.util.ArrayList;
import java.util.List;

import com.imedical.scheduler.data.PatientVO;

public class DataTestSets {
	private PatientVO bob = new PatientVO();
	private PatientVO clay = new PatientVO();
	private static List<PatientVO> patients = new ArrayList<PatientVO>();

	public DataTestSets() {
		bob.setFirstName("Bob");
		bob.setLastName("Boya");
		clay.setFirstName("Clay");
		clay.setLastName("Selby");

		patients.add(bob);
		patients.add(clay);
	}

	public List<PatientVO> getTestPatients() {
		return patients;
	}

}