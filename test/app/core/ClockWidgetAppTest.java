package test.app.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import main.app.core.ClockWidgetApp;

import org.junit.Test;

public class ClockWidgetAppTest {
	@Test
	public void shouldInitializeGUI() {
		// given
		ClockWidgetApp app = new ClockWidgetApp();
		
		// when
		app.initUI();
		
		// then
		assertEquals(true, app.isVisible());
	}
	
	@Test
	public void shouldConfigureClock() {
		// given
		ClockWidgetApp app = new ClockWidgetApp();
		
		// when
		app.config();
		
		// then
		assertEquals(true, app.isReady());
	}
	
	@Test
	public void shouldUpdateTime() throws InterruptedException {
		// given
		ClockWidgetApp app = new ClockWidgetApp();
		app.initUI();
		String currentTime = app.getTime();
		
		// when
		Thread.sleep(1000);
		app.updateTime();
		
		// then
		assertNotSame(currentTime, app.getTime());
	}
	
	@Test
	public void shouldStartTime() {
		// given
		ClockWidgetApp app = new ClockWidgetApp();
		app.initUI();
		
		// when
		app.start();
		
		// then
		assertEquals(true, app.isRunning());
	}
	
	@Test
	public void shouldStopTime() {
		// given
		ClockWidgetApp app = new ClockWidgetApp();
		app.initUI();
		app.start();
		assertEquals(true, app.isRunning());
		
		// when
		app.stop();
		
		// then
		assertEquals(false, app.isRunning());
	}
}
