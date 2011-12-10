package com.imedical.scheduler.data;

public class PatientFactory {

	private static IPatientDAO instance;

	public static IPatientDAO getInstance() {

		return instance;

	}

}
