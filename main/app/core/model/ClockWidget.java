package main.app.core.model;

/*
 * Interface to use when introducing new clock widgets.
 */
public interface ClockWidget {
	/*
	 * initialize the design
	 */
	void initUI();
	
	/*
	 * configures the clock widget
	 */
	void config();
}
