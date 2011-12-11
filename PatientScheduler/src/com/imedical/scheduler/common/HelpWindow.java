package com.imedical.scheduler.common;

import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

public class HelpWindow extends Window {
	private static final String HELP_HTML_SNIPPET = "This is " +
			"the first <strong>Help Window</strong>";
	
	public HelpWindow(){
		setCaption("Wizard Help");
		addComponent(new Label(HELP_HTML_SNIPPET, Label.CONTENT_XHTML));
	}

}
