package com.imedical.scheduler.common;

import com.imedical.scheduler.data.PatientVO;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

public class PatientForm extends Form implements ClickListener {
	private Button save = new Button("save", (ClickListener) this);
	private Button cancel = new Button("cancel", (ClickListener) this);
	private Button edit = new Button("edit", (ClickListener) this);
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
			setReadOnly(false);
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
