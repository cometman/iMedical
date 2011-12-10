package com.imedical.scheduler.data;

import java.util.Date;

public class AppointmentVO {
	private String title;
	private Date date;
	private Date time;
	private Date duration;
	private String room;
	private String hospital;
	private PatientVO patient;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Date getDuration() {
		return duration;
	}
	public void setDuration(Date duration) {
		this.duration = duration;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public PatientVO getPatient() {
		return patient;
	}
	public void setPatient(PatientVO patient) {
		this.patient = patient;
	}	
	
	
}
