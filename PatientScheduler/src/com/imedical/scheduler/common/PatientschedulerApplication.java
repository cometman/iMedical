package com.imedical.scheduler.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imedical.scheduler.data.IPatientDAO;
import com.imedical.scheduler.data.PatientContainer;
import com.imedical.scheduler.data.PatientDAO;
import com.vaadin.Application;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

public class PatientschedulerApplication extends Application implements
		Button.ClickListener, Property.ValueChangeListener {

	private static final long serialVersionUID = 7845062585965253129L;
	private Logger logger = LoggerFactory
			.getLogger(PatientschedulerApplication.class);
	private HorizontalSplitPanel horizontalSplit = new HorizontalSplitPanel();
	private static final int LEFT_MENU_SIZE = 200;
	private NavigationPane navPane = new NavigationPane();
	private PatientListView patientListView = null;
	private PatientTable patientTable = null;
	private NewPatientForm patientForm = null;
	private SharingOptions sharingOptionsWindow = null;
	private HelpWindow helpWindow = null;
	private PatientContainer dataSource = null;
	private IPatientDAO patientDAO = new PatientDAO();
	private SearchView searchView = null;
	private Button searchPatients = new Button();
	private Button helpButton = new Button();

	// Test Data
	DataTestSets testData = new DataTestSets();

	@Override
	public void init() {
		logger.debug("Patient Scheduler started");

		// Setup initial home page screen
		Window mainWindow = new Window("Patient Scheduler");
		setMainWindow(mainWindow);

		// Create the layout
		VerticalLayout verticalLayout = new VerticalLayout();
		verticalLayout.setSizeFull();
		verticalLayout.addComponent(createToolbar());
		verticalLayout.addComponent(horizontalSplit);

		verticalLayout.setExpandRatio(horizontalSplit, 1);

		horizontalSplit.setSplitPosition(LEFT_MENU_SIZE,
				HorizontalSplitPanel.UNITS_PIXELS);
		horizontalSplit.setFirstComponent(navPane);

		getMainWindow().setContent(verticalLayout);
		setMainComponent(getPatientListView());
	}

	/*
	 * Creating the main tool bar for the layout
	 */
	private HorizontalLayout createToolbar() {
		HorizontalLayout lo = new HorizontalLayout();
		helpButton.setCaption("Help");
		searchPatients.setCaption("Search");
		lo.addComponent(helpButton);
		helpButton.addListener((Button.ClickListener) this);
		lo.addComponent(searchPatients);
		searchPatients.addListener((Button.ClickListener) this);
		return lo;
	}

	private void setMainComponent(Component c) {
		horizontalSplit.setSecondComponent(c);
	}

	private PatientListView getPatientListView() {
		if (patientListView == null) {
			patientTable = new PatientTable(this);

			patientForm = new NewPatientForm();
			patientListView = new PatientListView(patientTable, patientForm);
		}
		return patientListView;
	}

	private SharingOptions getSharingOptions() {
		if (sharingOptionsWindow == null) {
			sharingOptionsWindow = new SharingOptions();
		}
		return sharingOptionsWindow;
	}

	private HelpWindow getHelpWindow() {
		if (helpWindow == null) {
			helpWindow = new HelpWindow();
		}
		return helpWindow;
	}

	public PatientContainer getPatientContainer() {
		if (dataSource == null) {
			dataSource = new PatientContainer();
			dataSource.addAll(patientDAO.getAllPatients());
		}
		dataSource.addAll(patientDAO.getAllPatients());
		return dataSource;
	}

	private SearchView getSearchView() {
		if (searchView == null) {
			searchView = new SearchView(this);
		}
		return searchView;
	}

	public void buttonClick(ClickEvent event) {
		final Button source = event.getButton();
		if (source == searchPatients) {
			showSearchView();
		} else if (source == helpButton) {
			getMainWindow().addWindow(getHelpWindow());
		}

	}

	private void showSearchView() {
		setMainComponent(getSearchView());

	}

	public void valueChange(ValueChangeEvent event) {
		Property property = event.getProperty();
		if (property == patientTable){
			Item item = patientTable.getItem(patientTable.getValue());
			if (item != patientForm.getItemDataSource()){
				patientForm.setItemDataSource(item);
			}
		}
		
	}

}
