package com.imedical.scheduler.common;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.imedical.scheduler.StartServer;
import com.imedical.scheduler.data.IPatientDAO;
import com.imedical.scheduler.data.PatientDAO;
import com.imedical.scheduler.data.PatientVO;
import com.imedical.scheduler.session.UserAppData;

public class UnitTest {

	IPatientDAO patientDAO = new PatientDAO();

	private List<PatientVO> patients = new ArrayList<PatientVO>();

	@Test
	public void applicationDidCreateAndFetch5Patients() {

		for (PatientVO p : patientDAO.getAllPatients()) {
			patients.add(p);
		}

		assertEquals(2, patients.size());

	}

	public List<PatientVO> getPatients() {
		return patients;
	}

	@Test
	public void didAuthUse() {
		assertTrue(UserAppData.getUserData() != null);
	}

	@Test
	public void testDataDoesContainCalevents() {
		DataTestSets testData = DataTestSets.getInstance();
		assertEquals(1, testData.getCalendarEvents().size());
	}

	@Test
	public void serverDidStart() {
		try {
			StartServer.main(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
