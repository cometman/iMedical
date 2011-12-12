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
		bob.setPhoneNumber("325.668.1534");
		bob.setAge("42");
		bob.setMiddleName("Rob");
		bob.setPaymentType("Cash");
		bob.setEmail("cometman@gmail.com");
		clay.setFirstName("Clay");
		clay.setLastName("Selby");
		clay.setPhoneNumber("325.338.1264");
		clay.setAge("21");
		clay.setMiddleName("Robert");
		clay.setPaymentType("Credit");
		clay.setEmail("csbuiss@gmail.com");

		patients.add(bob);
		patients.add(clay);
	}

	public List<PatientVO> getTestPatients() {
		return patients;
	}

}
