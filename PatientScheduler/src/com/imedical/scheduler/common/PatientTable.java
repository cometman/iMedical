package com.imedical.scheduler.common;

import java.util.List;

import com.imedical.scheduler.data.PatientVO;
import com.vaadin.ui.Table;

public class PatientTable extends Table{
	
	public PatientTable(PatientschedulerApplication app){
	//	for (PatientVO p : patients){
		//	System.out.println(p.getFirstName());
			setSizeFull();
			setContainerDataSource(app.getPatientContainer());
		//}
	}
	

}
