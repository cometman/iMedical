package com.imedical.scheduler.data;

import com.vaadin.data.util.BeanItemContainer;

public class PatientContainer extends BeanItemContainer<PatientVO> {

	private static final long serialVersionUID = -698172118637714620L;

	public static final Object[] NATUAL_COL_ORDER = new Object[] {
			"first_name", "last_name", "middle_name", "age", "phoneNumber",
			"reasonForVisit", "referral", "paymentType",
			"scheduleNewAppointment", "patientNotes", "nextAppointment" };
	public static final String[] COL_HEADERS_ENGLISH = new String[] {
			"First name", "Last name", "Middle name", "Age", "Phone",
			"New Appointment", "Payment", "Referral", "Notes", "Next appt." };

	public PatientContainer() throws IllegalArgumentException {
		super(PatientVO.class);
	}

}
