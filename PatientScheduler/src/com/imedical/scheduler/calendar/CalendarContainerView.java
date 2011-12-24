package com.imedical.scheduler.calendar;

import com.vaadin.ui.HorizontalSplitPanel;

public class CalendarContainerView extends HorizontalSplitPanel {
	private static final long serialVersionUID = 6277110002504050313L;
	
	public CalendarContainerView(MainCalendar calendar, CalendarForm form){
		setFirstComponent(calendar);
		setSecondComponent(form);
	}

}
