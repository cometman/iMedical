package com.imedical.scheduler.common;

import java.util.List;

import com.imedical.scheduler.data.PatientContainer;
import com.imedical.scheduler.data.PatientVO;
import com.vaadin.data.Property;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.Component;
import com.vaadin.ui.Link;
import com.vaadin.ui.Table;

public class PatientTable extends Table {

	public PatientTable(PatientschedulerApplication app) {

		addGeneratedColumn("email", new ColumnGenerator() {

			public Object generateCell(Table source, Object itemId,
					Object columnId) {
				PatientVO p = (PatientVO) itemId;
				Link l = new Link();
				l.setResource(new ExternalResource("mailto:"+p.getEmail()));
				l.setCaption(p.getEmail());	
				return l;
			}
		});
		
		setContainerDataSource(app.getPatientContainer());
		// for (PatientVO p : patients){
		// System.out.println(p.getFirstName());
		setSizeFull();
		setSelectable(true);
		setImmediate(true);
		addListener((Property.ValueChangeListener) app);
		setNullSelectionAllowed(false);
		setVisibleColumns(PatientContainer.NATUAL_COL_ORDER);
		setColumnHeaders(PatientContainer.COL_HEADERS_ENGLISH);	
		
		// }
	}
	
}
