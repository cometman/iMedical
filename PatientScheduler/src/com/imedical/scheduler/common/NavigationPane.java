package com.imedical.scheduler.common;

import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Tree;

public class NavigationPane extends Tree {
	public static final Object NEW_PATIENT = "New Patient";
	public static final Object ALL_PATIENTS = "All Patients";
	public static final Object WEEK_VIEW = "Week View";
	public static final Object DAY_VIEW = "Day View";
	public static final Object SEARCH = "Search";

	
	public NavigationPane(PatientschedulerApplication app){
		addItem(ALL_PATIENTS);
		addItem(NEW_PATIENT);
		addItem(WEEK_VIEW);
		addItem(DAY_VIEW);
		addItem(SEARCH);
		
		
		setSelectable(true);
		setNullSelectionAllowed(false);
		
		addListener((ItemClickListener) app);
	}

}
