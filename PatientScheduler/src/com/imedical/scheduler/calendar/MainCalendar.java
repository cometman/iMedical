package com.imedical.scheduler.calendar;

import com.imedical.scheduler.common.PatientschedulerApplication;
import com.vaadin.addon.calendar.ui.Calendar;
import com.vaadin.terminal.gwt.client.ui.VScrollTable.FooterCell;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;


public class MainCalendar extends Calendar {

	private static final long serialVersionUID = -8355843922579293004L;
	
	public MainCalendar(PatientschedulerApplication app){
		Calendar calendar = new Calendar();
		HorizontalSplitPanel panel = new HorizontalSplitPanel();
		panel.addComponent(calendar);
	}
}
