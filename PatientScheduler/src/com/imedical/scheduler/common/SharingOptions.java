package com.imedical.scheduler.common;

import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

public class SharingOptions extends Window {
	public SharingOptions(){
		setModal(true);
		setWidth("50%");
		center();
		setCaption("Sharing options");
		addComponent(new Label("You can modify contact sharing"));
		addComponent(new CheckBox("Gmail"));
		addComponent(new CheckBox("Gmail"));
		Button close = new Button("OK");
		addComponent(close);
		
	}

}
