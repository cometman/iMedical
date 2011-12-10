package com.imedical.scheduler.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.Application;
import com.vaadin.ui.*;

public class PatientschedulerApplication extends Application {

	private static final long serialVersionUID = 7845062585965253129L;
	private Logger logger = LoggerFactory
			.getLogger(PatientschedulerApplication.class);
	private HorizontalSplitPanel horizontalSplit = new HorizontalSplitPanel();
	private static final int LEFT_MENU_SIZE = 200;
	private NavigationPane navPane = new NavigationPane();
	private PatientListView patientListView = null;
	
	private PatientTable patientTable = null;
	private NewPatientForm patientForm = null;

	@Override
	public void init() {
		logger.debug("Patient Scheduler started");

		// Setup initial home page screen
		Window mainWindow = new Window("Patient Scheduler");
		setMainWindow(mainWindow);

		// Create the layout
		VerticalLayout verticalLayout = new VerticalLayout();
		verticalLayout.setSizeFull();

		verticalLayout.addComponent(horizontalSplit);

		verticalLayout.setExpandRatio(horizontalSplit, 1);

		horizontalSplit.setSplitPosition(LEFT_MENU_SIZE,
				HorizontalSplitPanel.UNITS_PIXELS);
		horizontalSplit.setFirstComponent(navPane);

		getMainWindow().setContent(verticalLayout);

	}

	private void setMainContent(Component c) {
		horizontalSplit.setSecondComponent(c);
	}

	private PatientListView getPatientListView() {
		if (patientListView == null) {
			patientTable = new PatientTable(new UnitTest().getPatients());
			patientForm = new NewPatientForm();
			patientListView = new PatientListView(patientTable, patientForm);
		}
		return patientListView;
	}

}
