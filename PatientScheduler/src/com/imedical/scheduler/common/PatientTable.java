package com.imedical.scheduler.common;

import java.util.List;

import com.imedical.scheduler.data.PatientContainer;
import com.imedical.scheduler.data.PatientVO;
import com.vaadin.data.Property;
import com.vaadin.ui.Table;

public class PatientTable extends Table {

	public PatientTable(PatientschedulerApplication app) {
		// for (PatientVO p : patients){
		// System.out.println(p.getFirstName());
		setSizeFull();

		setContainerDataSource(app.getPatientContainer());
		setSelectable(true);
		setImmediate(true);
		addListener((Property.ValueChangeListener) app);
		setNullSelectionAllowed(false);
//		setVisibleColumns(PatientContainer.NATUAL_COL_ORDER);
//		setColumnHeaders(PatientContainer.COL_HEADERS_ENGLISH);

		// }
	}


}
