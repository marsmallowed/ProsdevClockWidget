package main.app.core.controller;

import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

import main.app.core.model.ClockWidget;
import main.app.core.model.ICheckConfiguration;
import main.app.core.model.ICheckRunning;
import main.app.core.model.IGetTime;
import main.app.core.model.IStartClock;
import main.app.core.model.IStopClock;
import main.app.core.model.IUpdateTime;
import main.app.core.model.TimeThread;
import main.app.core.view.ClockWidgetGUI;

/** CONTROLLER */

public class ClockWidgetApp implements ClockWidget, ICheckConfiguration, ICheckRunning, IGetTime, IStartClock, IStopClock, IUpdateTime {
	/**
	 * auto generated serial version UID imposed by JFrame
	 */
//	private static final long serialVersionUID = -8951174492255254603L;
	
	private ClockWidgetGUI view;
	
	private int updateInt;
	private boolean stop;
	private boolean ready;
	
	/*
	 * initialize the UI(non-Javadoc)
	 * @see main.app.core.ClockWidget#initUI()
	 */
	public void initUI() {
		view = new ClockWidgetGUI();
	}
	
	/*
	 * method for configuring this clock object(non-Javadoc)
	 * @see main.app.core.ClockWidget#config()
	 */
	public void config() {
		updateInt = 100; // updates every 100 milliseconds
		ready = true;
	}
	
	/*
	 * returns true if this clock is configured, false otherwise(non-Javadoc)
	 * @see main.app.core.ClockWidget#isReady()
	 */
	public boolean isReady() {
		return ready;
	}
	
	/*
	 * updates the time based from system time (hour (12hrs format), minute, second)(non-Javadoc)
	 * @see main.app.core.ClockWidget#updateTime()
	 */
	public void updateTime() {
		setHour();
		setMinute();
		setSecond();
	}
	
	private void setHour() {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR);
		String sHour = (hour < 10 ? "0" : "") + hour;
		view.setHour(sHour);
	}
	
	private void setMinute() {
		Calendar cal = Calendar.getInstance();
		int minute = cal.get(Calendar.MINUTE);
		String sMinute = (minute < 10 ? "0" : "") + minute;
		view.setMinute(sMinute);
	}

	private void setSecond() {
		Calendar cal = Calendar.getInstance();
		int second = cal.get(Calendar.SECOND);
		String sSecond = (second < 10 ? "0" : "") + second;
		view.setSecond(sSecond);
	}

	/*
	 * starts this clock object by spawning a thread and starting it(non-Javadoc)
	 * @see main.app.core.ClockWidget#start()
	 */
	public void start() {
		new TimeThread(updateInt, stop, ready).run();
	}
	
	
	/*
	 * stops this clock(non-Javadoc)
	 * @see main.app.core.ClockWidget#stop()
	 */
	public void stop() {
		stop = true;
	}

	/*
	 * returns the time using appropriate format HH:MM:SS(non-Javadoc)
	 * @see main.app.core.ClockWidget#getTime()
	 */
	public String getTime() {
		return view.getTime();
	}

	/*
	 * returns true if this clock is running false otherwise(non-Javadoc)
	 * @see main.app.core.ClockWidget#isRunning()
	 */
	public boolean isRunning() {
		return !stop;
	}
}