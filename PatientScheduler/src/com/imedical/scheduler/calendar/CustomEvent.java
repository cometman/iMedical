package com.imedical.scheduler.calendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vaadin.addon.calendar.event.CalendarEventEditor;
import com.vaadin.addon.calendar.event.CalendarEvent.EventChangeNotifier;

public class CustomEvent implements CalendarEventEditor, EventChangeNotifier {

	private Date start;
	private Date end;
	private String caption;
	private String description;
	private String styleName;
	private boolean isAllDay;
	private List<EventChangeListener> listeners = new ArrayList<EventChangeListener>();

	public Date getStart() {
		return start;
	}

	public Date getEnd() {
		return end;
	}

	public String getCaption() {
		return caption;
	}

	public String getDescription() {
		return description;
	}

	public String getStyleName() {
		return styleName;
	}

	public boolean isAllDay() {
		return isAllDay;
	}

	public void setCaption(String caption) {
		this.caption = caption;
		fireEventChange();

	}

	public void setDescription(String description) {
		this.description = description;
		fireEventChange();
	}

	public void setEnd(Date end) {
		this.end = end;
		fireEventChange();
	}

	public void setStart(Date start) {
		this.start = start;
		fireEventChange();
	}

	public void setStyleName(String styleName) {
		this.styleName = styleName;
		fireEventChange();
	}

	public void setAllDay(boolean isAllDay) {
		this.isAllDay = isAllDay;
		fireEventChange();
	}

	public void addListener(EventChangeListener listener) {
		listeners.add(listener);
	}

	public void removeListener(EventChangeListener listener) {
		listeners.remove(listener);
	}

	protected void fireEventChange() {
		EventChange event = new EventChange(this);
		
		for (EventChangeListener listener : listeners){
			listener.eventChange(event);
		}
	}

}