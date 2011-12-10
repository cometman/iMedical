package com.imedical.scheduler.common;

import java.util.List;

import com.imedical.scheduler.data.PatientVO;
import com.vaadin.ui.Table;

public class PatientTable extends Table{
	
	public PatientTable(List<PatientVO> patients){
		for (PatientVO p : patients){
			addContainerProperty("First Name", String.class, p.getFirstName());
			addContainerProperty("Last Name", String.class, p.getLastName());
			addItem();
			setSizeFull();			
		}
	}
	

}
