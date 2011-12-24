package com.imedical.scheduler.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ibm.icu.util.GregorianCalendar;
import com.imedical.scheduler.data.PatientVO;
import com.imedical.scheduler.session.UserVO;
import com.vaadin.addon.calendar.event.BasicEvent;
import com.vaadin.addon.calendar.gwt.client.ui.schedule.CalendarEvent;

public class DataTestSets {
	private PatientVO bob = new PatientVO();
	private PatientVO clay = new PatientVO();
	private static List<PatientVO> patients = new ArrayList<PatientVO>();
	private static DataTestSets instance = null;

	public DataTestSets() {
		bob.setFirstName("Bob");
		bob.setLastName("Boya");
		bob.setPhoneNumber("325.668.1534");
		bob.setAge("42");
		bob.setMiddleName("Rob");
		bob.setPaymentType("Cash");
		bob.setEmail("cometman@gmail.com");
		bob.setReasonForVisit("My back hurts");
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		cal.add(GregorianCalendar.HOUR, 5);
		Date time = cal.getTime();
		bob.setNextAppointment(time);

		clay.setNextAppointment(new Date());
		clay.setFirstName("Clay");
		clay.setLastName("Selby");
		clay.setPhoneNumber("325.338.1264");
		clay.setAge("21");
		clay.setMiddleName("Robert");
		clay.setPaymentType("Credit");
		clay.setEmail("csbuiss@gmail.com");
		clay.setReasonForVisit("my knee hurts");

		patients.add(bob);
		patients.add(clay);
	}

	public List<PatientVO> getTestPatients() {

		return patients;
	}

	public static UserVO testUser() {
		UserVO user = new UserVO();
		user.setEmail("csbuiss@gmail.com");
		user.setFirstName("Clay");
		user.setLastName("Selby");
		user.setPassword("halflife");
		user.setUserid("cometman");

		return user;
	}

	public static List<CalendarEvent> getCalendarEvents() {
		List<CalendarEvent> events = new ArrayList<CalendarEvent>();
		GregorianCalendar cal = new GregorianCalendar();

		Date start = cal.getTime();
		Date end = cal.getTime();

		CalendarEvent event = new CalendarEvent();
		event.setCaption("My Event");
		event.setDescription("Test Desctip");
		event.setStart(start);
		event.setEnd(end);
		events.add(event);
		return events;
	}

	public static DataTestSets getInstance() {
		if (instance == null) {
			instance = new DataTestSets();
		}
		return instance;
	}

}
