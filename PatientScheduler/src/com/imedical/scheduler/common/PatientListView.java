package com.imedical.scheduler.common;

import com.vaadin.ui.HorizontalSplitPanel;

public class PatientListView extends HorizontalSplitPanel {
	public PatientListView(PatientTable personTable, NewPatientForm patientForm) {
		setFirstComponent(personTable);
		setSecondComponent(patientForm);
		setSplitPosition(40);
	}

}
