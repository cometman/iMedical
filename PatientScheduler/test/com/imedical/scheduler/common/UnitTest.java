package com.imedical.scheduler.common;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.imedical.scheduler.StartServer;
import com.imedical.scheduler.data.IPatientDAO;
import com.imedical.scheduler.data.PatientDAO;
import com.imedical.scheduler.data.PatientVO;

public class UnitTest {

	IPatientDAO patientDAO = new PatientDAO();

	PatientVO dummy1 = new PatientVO();
	PatientVO dummy2 = new PatientVO();
	PatientVO dummy3 = new PatientVO();
	PatientVO dummy4 = new PatientVO();
	PatientVO dummy5 = new PatientVO();
	private List<PatientVO> patients = new ArrayList<PatientVO>();
	
	@Test
	public void serverDidStart(){
		try {
			StartServer.main(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void applicationDidCreateAndFetch5Patients() {

		dummy1.setFirstName("Bob");
		dummy2.setFirstName("Gill");
		dummy3.setFirstName("Fred");
		dummy4.setFirstName("Gary");
		dummy5.setFirstName("George");

		patientDAO.addNewPatient(dummy1);
		patientDAO.addNewPatient(dummy2);
		patientDAO.addNewPatient(dummy3);
		patientDAO.addNewPatient(dummy4);
		patientDAO.addNewPatient(dummy5);

		for (PatientVO p : patientDAO.getAllPatients()) {
			patients.add(p);
		}

		assertEquals(5, patients.size());
		
	}
	
	public List<PatientVO> getPatients(){
		return patients;
	}

}
