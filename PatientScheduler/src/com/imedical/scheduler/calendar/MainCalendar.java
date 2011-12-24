package com.imedical.scheduler.calendar;

import javax.swing.text.TableView.TableRow;

import com.imedical.scheduler.common.PatientschedulerApplication;
import com.imedical.scheduler.session.UserAppData;
import com.vaadin.addon.calendar.event.BasicEvent;
import com.vaadin.addon.calendar.event.CalendarEvent;
import com.vaadin.addon.calendar.ui.Calendar;
import com.vaadin.addon.calendar.ui.CalendarTargetDetails;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.EventClick;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.EventClickHandler;
import com.vaadin.data.Item;
import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptAll;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Window;
import com.vaadin.ui.Table.TableTransferable;
import com.vaadin.ui.Window.Notification;

public class MainCalendar extends Calendar {

	private static final long serialVersionUID = -8355843922579293004L;
	private EventProvider eventProvider;
	private PatientschedulerApplication apps;

	public MainCalendar(final PatientschedulerApplication app) {
		apps = app;
		eventProvider = new EventProvider(app);
		HorizontalSplitPanel panel = new HorizontalSplitPanel();
		// panel.addComponent(calendar);
		// System.out.println("Hello" +
		// UserAppData.getUserData().getFirstName());
		this.setHandler(new EventClickHandler() {
			private static final long serialVersionUID = -4632383901759824486L;

			public void eventClick(EventClick event) {
				CalendarEvent calEvent = event.getCalendarEvent();
				Window detailWindow = new Window();
				app.getMainWindow().showNotification("Test");
			}
		});

	}

	public Calendar createCalendar() {
		Calendar calendar = new Calendar();

		calendar.setDropHandler(new DropHandler() {

			public AcceptCriterion getAcceptCriterion() {
				return AcceptAll.get();
			}

			public void drop(DragAndDropEvent event) {
				CalendarTargetDetails details = (CalendarTargetDetails) event
						.getTargetDetails();
				TableTransferable transferable = (TableTransferable) event
						.getTransferable();
				eventProvider.createEvent(details, transferable);
				eventProvider.removeEvent(transferable);
			}
		});

		// When an event is clicked, we do this!

		return calendar;
	}

}
