package com.imedical.scheduler.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.imedical.scheduler.common.PatientschedulerApplication;
import com.imedical.scheduler.data.PatientContainer;
import com.imedical.scheduler.data.PatientVO;
import com.vaadin.addon.calendar.event.BasicEvent;
import com.vaadin.addon.calendar.event.CalendarEvent;
import com.vaadin.addon.calendar.event.CalendarEventProvider;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.EventClick;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.EventClickHandler;
import com.vaadin.addon.calendar.ui.CalendarTargetDetails;
import com.vaadin.data.Item;
import com.vaadin.ui.Button;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Table.TableTransferable;
import com.vaadin.ui.Window.Notification;

public class EventProvider implements CalendarEventProvider {
	private static final long serialVersionUID = -3759242919202378793L;
	private List<CalendarEvent> events = new ArrayList<CalendarEvent>();
	private PatientschedulerApplication app;

	public EventProvider(PatientschedulerApplication app) {
		this.app = app;
		PatientContainer patientContainer = app.getPatientContainer();

		// Populate the events for the calendar
		for (int i = 0; i < patientContainer.size(); i++) {
			PatientVO currentItem = patientContainer.getIdByIndex(i);

			CustomEvent event = new CustomEvent();
			event.setCaption(currentItem.getFirstName());
			event.setDescription(currentItem.getReasonForVisit());

			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(currentItem.getNextAppointment());

			Date start = cal.getTime();
			event.setStart(start);

			cal.add(GregorianCalendar.HOUR, 1);

			Date end = cal.getTime();
			event.setEnd(end);
			events.add(event);
		}

	}

	public List<CalendarEvent> getEvents(Date startDate, Date endDate) {

		return events;
	}

	protected void createEvent(CalendarTargetDetails details,
			TableTransferable transferable) {
		Date dropTime = details.getDropTime();
		Calendar timeCalendar = details.getTargetCalendar()
				.getInternalCalendar();
		timeCalendar.setTime(dropTime);
		timeCalendar.add(Calendar.MINUTE, 120);
		Date endTime = timeCalendar.getTime();

		Item draggedItem = transferable.getSourceComponent().getItem(
				transferable.getItemId());

		String eventType = (String) draggedItem.getItemProperty("caption")
				.getValue();

		String eventDescription = (String) draggedItem.getItemProperty(
				"description").getValue();

		CustomEvent newEvent = new CustomEvent();
		newEvent.setAllDay(!details.hasDropTime());
		newEvent.setCaption(eventType);
		newEvent.setDescription("new teswt");
		newEvent.setStart(dropTime);
		newEvent.setEnd(endTime);

		events.add(newEvent);
	}

	protected void removeEvent(TableTransferable transferable) {
		Item draggedItem = transferable.getSourceComponent().getItem(
				transferable.getItemId());

		System.out.println("here");
		for (CalendarEvent e : events) {
			System.out.println(e.getCaption());
			if (e.equals(draggedItem)) {
				events.remove(e);
			}
		}
	}
	


}
