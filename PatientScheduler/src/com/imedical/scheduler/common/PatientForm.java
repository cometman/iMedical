package com.imedical.scheduler.common;

import java.util.Date;

import net.sourceforge.htmlunit.corejs.javascript.ast.ObjectProperty;

import org.apache.tools.ant.types.selectors.DateSelector;

import com.gargoylesoftware.htmlunit.AlertHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.imedical.scheduler.data.PatientVO;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.Notification;

public class PatientForm extends Form implements ClickListener {
	private Button save = new Button("save", (ClickListener) this);
	private Button cancel = new Button("cancel", (ClickListener) this);
	private Button edit = new Button("edit", (ClickListener) this);
	private Button schedule = new Button("schedule", (ClickListener) this);
	private PatientschedulerApplication app;
	private boolean newPatientMode = false;
	private PatientVO newPatient = null;

	public PatientForm(PatientschedulerApplication app) {
		this.app = app;

		// Enable buffering so that commit() must be called to send data.
		setWriteThrough(false);

		HorizontalLayout footer = new HorizontalLayout();

		footer.setSpacing(true);
		footer.addComponent(save);
		footer.addComponent(cancel);
		footer.addComponent(edit);
		footer.addComponent(schedule);

		footer.setVisible(false);

		setFooter(footer);
	}

	public void buttonClick(ClickEvent event) {
		Button source = event.getButton();

		if (source == save) {
			if (!isValid()) {
				return;
			}
			commit();
			if (newPatientMode) {
				Item addedItem = app.getPatientContainer().addItem(newPatient);
				setItemDataSource(addedItem);
				newPatientMode = false;
			}

			setReadOnly(true);
		} else if (source == cancel) {
			if (newPatientMode) {
				newPatientMode = false;
				setItemDataSource(null);
			} else {
				discard();
			}
			setReadOnly(true);
		} else if (source == edit) {
			getItemProperty("nextAppointment").setReadOnly(true);
			setReadOnly(false);
		} else if (source == schedule) {
			Window scheduleWindow = new Window();
			final DateField dateField = new DateField();
			scheduleWindow.addComponent(dateField);
			Button submitButton = new Button("Schedule", new ClickListener() {
				
				public void buttonClick(ClickEvent event) {
					Notification addedTime = new Notification("Added new appointment");
					app.getMainWindow().showNotification(addedTime);
					getItemDataSource().getItemProperty("nextAppointment").setValue(dateField.getValue());

				}
			});
			Button cancelButton = new Button("Cancel");

			HorizontalLayout popUpPanel = new HorizontalLayout();

			popUpPanel.addComponent(submitButton);
			popUpPanel.addComponent(cancelButton);

			scheduleWindow.addComponent(popUpPanel);
			app.getMainWindow().addWindow(scheduleWindow);

		}

	}

	@Override
	public void setItemDataSource(Item newDataSource) {
		newPatientMode = false;
		if (newDataSource != null) {
			super.setItemDataSource(newDataSource);
			setReadOnly(true);
			getFooter().setVisible(true);

		} else {
			super.setItemDataSource(null);
			getFooter().setVisible(false);
		}

	}
	

	@Override
	public void setReadOnly(boolean readOnly) {
		super.setReadOnly(readOnly);
		save.setVisible(!readOnly);
		cancel.setVisible(!readOnly);
		edit.setVisible(readOnly);
	}

	public void addPatient() {
		newPatient = new PatientVO();
		setItemDataSource(new BeanItem(newPatient));
		newPatientMode = true;
		setReadOnly(false);

	}

}
