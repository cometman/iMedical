package com.imedical.scheduler.data;

import com.vaadin.data.util.BeanItemContainer;

public class PatientContainer extends BeanItemContainer<PatientVO> {

	private static final long serialVersionUID = -698172118637714620L;

	public PatientContainer() throws IllegalArgumentException {
		super(PatientVO.class);
	}

}
