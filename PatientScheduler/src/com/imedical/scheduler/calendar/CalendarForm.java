package com.imedical.scheduler.calendar;

import com.imedical.scheduler.common.PatientschedulerApplication;
import com.vaadin.data.Item;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Form;
import com.vaadin.ui.TextArea;

public class CalendarForm extends Form implements ClickListener{
	private TextArea description = new TextArea("Description");
	public CalendarForm(PatientschedulerApplication app) {

	}

	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setItemDataSource(Item newDataSource) {
		if (newDataSource != null) {
			super.setItemDataSource(newDataSource);
			setReadOnly(true);
			getFooter().setVisible(true);

		} else {
			super.setItemDataSource(null);
			getFooter().setVisible(false);
		}

	}
}
