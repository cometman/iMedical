package com.imedical.scheduler.session;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import com.vaadin.Application;
import com.vaadin.service.ApplicationContext.TransactionListener;

public class UserAppData implements TransactionListener, Serializable {

	private ResourceBundle bundle;
	private Locale locale;
	private UserVO user;

	private Application app;

	private static ThreadLocal<UserAppData> instance = new ThreadLocal<UserAppData>();

	public UserAppData(Application app) {
		this.app = app;

		instance.set(this);
	}

	public void transactionStart(Application application, Object transactionData) {
		// Set this data instance of this application
		// as the one active in the current thread.
		if (this.app == application)
			instance.set(this);
	}

	public void transactionEnd(Application application, Object transactionData) {
		// Clear the reference to avoid potential problems
		if (this.app == application)
			instance.set(null);
	}

	public static void initLocale(Locale locale, String bundleName) {
		instance.get().locale = locale;
		instance.get().bundle = ResourceBundle.getBundle(bundleName);
	}

	public static Locale getLocale() {
		return instance.get().locale;
	}

	public static String getMesssage(String msgId) {
		return instance.get().bundle.getString(msgId);
	}

	public static UserVO getUserData() {
		return instance.get().user;
	}

	public static void setUserData(UserVO userData) {
		instance.get().user = userData;
	}
}
