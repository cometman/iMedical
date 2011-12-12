package com.imedical.scheduler.common;

import com.imedical.scheduler.data.PatientContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;

public class SearchView extends Panel {

	private TextField tf;
	private NativeSelect fieldToSearch;
	private CheckBox saveSearch;
	private TextField searchName;
	private PatientschedulerApplication app;

	public SearchView(final PatientschedulerApplication app) {
		this.app = app;

		setCaption("Search Patients");
		setSizeFull();

		FormLayout formLayout = new FormLayout();
		setContent(formLayout);

		tf = new TextField("Search Term");
		fieldToSearch = new NativeSelect("Field to search");
		saveSearch = new CheckBox("Save search");
		searchName = new TextField("Search name");
		Button search = new Button("Search");

		for (int i = 0; i < PatientContainer.NATUAL_COL_ORDER.length; i++) {
			fieldToSearch.addItem(PatientContainer.NATUAL_COL_ORDER[i]);
			fieldToSearch.setItemCaption(PatientContainer.NATUAL_COL_ORDER[i],
					PatientContainer.COL_HEADERS_ENGLISH[i]);
		}

		fieldToSearch.setValue("lastName");
		fieldToSearch.setNullSelectionAllowed(false);

		saveSearch.setValue(true);
		saveSearch.setImmediate(true);
		saveSearch.addListener(new ClickListener() {

			public void buttonClick(ClickEvent event) {
				searchName.setVisible(event.getButton().booleanValue());

			}
		});

		search.addListener(new Button.ClickListener() {

			public void buttonClick(ClickEvent event) {
				performSearch();

			}
		});
		addComponent(tf);
		addComponent(fieldToSearch);
		addComponent(saveSearch);
		addComponent(searchName);
		addComponent(search);

	}

	private void performSearch() {
		String searchTerm = (String) tf.getValue();
		SearchFilter searchFilter = new SearchFilter(fieldToSearch.getValue(),
				searchTerm, (String) searchName.getValue());
		if (saveSearch.booleanValue()) {
			app.saveSearch(searchFilter);
		}
		app.search(searchFilter);
	}
}
