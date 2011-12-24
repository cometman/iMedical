package com.imedical.scheduler.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.data.util.BeanItemContainer;

public class PatientContainer extends BeanItemContainer<PatientVO> implements
		Serializable {

	private static final long serialVersionUID = -698172118637714620L;
	private static IPatientDAO patientDAO = null;
	private static List<PatientVO> patients = new ArrayList<PatientVO>();
	PatientContainer c;
	public static final Object[] NATUAL_COL_ORDER = new Object[] { "firstName",
			"lastName", "middleName", "email", "age", "phoneNumber",
			"reasonForVisit", "referral", "paymentType",
			 "nextAppointment" };
	public static final String[] COL_HEADERS_ENGLISH = new String[] {
			"First name", "Last name", "Middle name", "email", "Age", "Phone",
			"Visit reason", "Referral", "Payment",
			"Next appt." };

	public PatientContainer() throws IllegalArgumentException {
		super(PatientVO.class);

	}

	public PatientContainer loadInitialData() {
		System.out.println("test");
		if (patientDAO == null) {
			patientDAO = new PatientDAO();
			patients = patientDAO.getAllPatients();
		}

		if (c == null) {
			c = new PatientContainer();
			for (PatientVO p : patients) {
				System.out.println("here");
				c.addItem(p);
			}

		}

		return c;
	}

}
