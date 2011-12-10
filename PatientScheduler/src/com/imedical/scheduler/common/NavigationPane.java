package com.imedical.scheduler.common;

import com.vaadin.ui.Tree;

public class NavigationPane extends Tree {
	public static final Object NEW_PATIENT = "New Patient";
	public static final Object WEEK_VIEW = "Week View";
	public static final Object DAY_VIEW = "Day View";
	
	public NavigationPane(){
		addItem(NEW_PATIENT);
		addItem(WEEK_VIEW);
		addItem(DAY_VIEW);
	}

}
