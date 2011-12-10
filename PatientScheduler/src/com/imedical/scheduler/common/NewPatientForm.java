package com.imedical.scheduler.common;

import com.vaadin.ui.Button;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

public class NewPatientForm extends Form {
	private Button save = new Button("save");
	private Button cancel = new Button("cancel");

	public NewPatientForm() {
		addField("First Name", new TextField("First Name"));
		addField("Last Name", new TextField("Last Name"));
		HorizontalLayout footer = new HorizontalLayout();
		footer.setSpacing(true);
		footer.addComponent(save);
		footer.addComponent(cancel);
		setFooter(footer);
	}

}
