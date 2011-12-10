package com.imedical.scheduler.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientVO {
	private String first_name;
	private String last_name;
	private String middle_name;
	private String age;
	private String phoneNumber;
	private String reasonForVisit;
	private String referral;
	private String paymentType;
	private boolean scheduleNewAppointment;
	private List<Note> patientNotes = new ArrayList<Note>();
	private Date nextAppointment;
	public String getFirstName() {
		return first_name;
	}
	public void setFirstName(String name) {
		this.first_name = name;
	}
	
	public String getLastName() {
		return last_name;
	}
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	public String getMiddleName() {
		return middle_name;
	}
	public void setMiddleName(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getReasonForVisit() {
		return reasonForVisit;
	}
	public void setReasonForVisit(String reasonForVisit) {
		this.reasonForVisit = reasonForVisit;
	}
	public String getReferral() {
		return referral;
	}
	public void setReferral(String referral) {
		this.referral = referral;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public boolean isScheduleNewAppointment() {
		return scheduleNewAppointment;
	}
	public void setScheduleNewAppointment(boolean scheduleNewAppointment) {
		this.scheduleNewAppointment = scheduleNewAppointment;
	}
	public List<Note> getPatientNotes() {
		return patientNotes;
	}
	public void setPatientNotes(List<Note> patientNotes) {
		this.patientNotes = patientNotes;
	}
	public Date getNextAppointment() {
		return nextAppointment;
	}
	public void setNextAppointment(Date nextAppointment) {
		this.nextAppointment = nextAppointment;
	}
	
}
