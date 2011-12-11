package com.imedical.scheduler.common;

import java.util.List;

import com.imedical.scheduler.data.PatientVO;
import com.vaadin.ui.Table;

public class PatientTable extends Table{
	
	public PatientTable(){
	//	for (PatientVO p : patients){
		//	System.out.println(p.getFirstName());
			addContainerProperty("First Name", String.class,"Mark");
			addContainerProperty("Last Name", String.class, "Smith");
			addItem();
			addItem();
			setSizeFull();			
		//}
	}
	

}
