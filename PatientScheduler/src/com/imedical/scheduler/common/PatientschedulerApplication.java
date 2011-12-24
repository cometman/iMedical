package com.imedical.scheduler.common;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imedical.scheduler.calendar.CalendarContainerView;
import com.imedical.scheduler.calendar.CalendarForm;
import com.imedical.scheduler.calendar.EventProvider;
import com.imedical.scheduler.calendar.MainCalendar;
import com.imedical.scheduler.data.IPatientDAO;
import com.imedical.scheduler.data.PatientContainer;
import com.imedical.scheduler.data.PatientDAO;
import com.imedical.scheduler.session.UserAppData;
import com.vaadin.Application;
import com.vaadin.addon.calendar.event.CalendarEvent;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.EventClick;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.EventClickHandler;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Window.Notification;

public class PatientschedulerApplication extends Application implements
		Button.ClickListener, Property.ValueChangeListener, ItemClickListener, EventClickHandler {

	private static final long serialVersionUID = 7845062585965253129L;
	private Logger logger = LoggerFactory
			.getLogger(PatientschedulerApplication.class);
	private HorizontalSplitPanel horizontalSplit = new HorizontalSplitPanel();
	private static final int LEFT_MENU_SIZE = 200;
	private NavigationPane navPane = new NavigationPane(this);
	private PatientListView patientListView = null;
	private PatientTable patientTable = null;
	private PatientForm patientForm = null;
	private SharingOptions sharingOptionsWindow = null;
	private HelpWindow helpWindow = null;
	private PatientContainer dataSource = null;
	private IPatientDAO patientDAO = new PatientDAO();
	private SearchView searchView = null;
	private Button searchPatients = new Button();
	private MainCalendar mainCalendar = null;
	private CalendarContainerView calendarContainer = null;
	private CalendarForm calendarForm = null;
	private Button helpButton = new Button();

	// Test Data
	DataTestSets testData = DataTestSets.getInstance();

	@Override
	public void init() {
		logger.debug("Patient Scheduler started");

		// Setup the session for the user
		UserAppData sessionData = new UserAppData(this);

		// Register it as a listener
		getContext().addTransactionListener(sessionData);

		// LOCALE NOT WORKING!
		// Initialize the session-global data
		// UserAppData.initLocale(getLocale(),
		// PatientschedulerApplication.class.getName());

		// Set the user
		UserAppData.setUserData(DataTestSets.testUser());

		// Set the theme for the application
		setTheme("scheduler");

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

		lo.setMargin(true);
		lo.setSpacing(true);

		return lo;
	}

	public void setMainComponent(Component c) {
		horizontalSplit.setSecondComponent(c);
	}

	private PatientListView getPatientListView() {
		if (patientListView == null) {
			if (patientTable == null) {
				patientTable = new PatientTable(this);
			}

			patientForm = new PatientForm(this);
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
			dataSource = dataSource.loadInitialData();
		}

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

	private void showPatientView() {
		setMainComponent(getPatientListView());
	}

	public void valueChange(ValueChangeEvent event) {
		Property property = event.getProperty();
		if (property == patientTable) {
			Item item = patientTable.getItem(patientTable.getValue());
			if (item != patientForm.getItemDataSource()) {
				patientForm.setItemDataSource(item);
			}
		}
	}

	public void itemClick(ItemClickEvent event) {
		if (event.getSource() == navPane) {
			Object itemId = event.getItemId();
			if (itemId != null) {
				if (NavigationPane.ALL_PATIENTS.equals(itemId)) {
					getPatientContainer().removeAllContainerFilters();
					showPatientView();
				} else if (NavigationPane.SEARCH.equals(itemId)) {
					showSearchView();
				} else if (itemId instanceof SearchFilter) {
					search((SearchFilter) itemId);
				} else if (NavigationPane.NEW_PATIENT.equals(itemId)) {
					addNewPatient();
				} else if (NavigationPane.WEEK_VIEW.equals(itemId)) {
					showCalendar();
				} else if (NavigationPane.DAY_VIEW.equals(itemId)) {
					showCalendarDay();

				}
			}
		}
	}

	private void showCalendarDay() {
		setMainComponent(getCalendarDay());

	}

	private Component getCalendarDay() {
		// TODO Auto-generated method stub
		return null;
	}

	private void showCalendar() {

		setMainComponent(this.getCalendar());
	}

	public CalendarContainerView getCalendar() {
		if (mainCalendar == null) {
			mainCalendar = new MainCalendar(this);
			mainCalendar.setEventProvider(new EventProvider(this));
			calendarForm = new CalendarForm(this);
			calendarContainer = new CalendarContainerView(mainCalendar, calendarForm);
		}

		return calendarContainer;
	}

	private void addNewPatient() {
		showPatientView();
		patientForm.addPatient();
	}

	public void search(SearchFilter searchFilter) {
		getPatientContainer().removeAllContainerFilters();
		getPatientContainer().addContainerFilter(searchFilter.getPropertyId(),
				searchFilter.getTerm(), true, false);
		showPatientView();
		getMainWindow().showNotification(
				"Searched for *" + searchFilter.getTerm() + "* found "
						+ getPatientContainer().size() + " results.",
				Notification.TYPE_TRAY_NOTIFICATION);
	}

	public void saveSearch(SearchFilter searchFilter) {
		navPane.addItem(searchFilter);
		navPane.setParent(searchFilter, NavigationPane.SEARCH);
		navPane.setChildrenAllowed(searchFilter, false);
		navPane.expandItem(NavigationPane.SEARCH);
		navPane.setValue(searchFilter);
	}

	public void eventClick(EventClick event) {
		if (event.getCalendarEvent() != null){
			System.out.println("here");
		}
		
	}

}
