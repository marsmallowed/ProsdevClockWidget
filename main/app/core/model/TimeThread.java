package main.app.core.model;

public class TimeThread implements Runnable {
	private int updateInt;
	private boolean stop;
	private boolean ready;
	
	public TimeThread(int updateInt, boolean stop, boolean ready) {
		this.updateInt = updateInt; 
		this.stop = stop;
		this.ready = ready;
	}
	
	@Override
	public void run() {
		while (!stop) {
			try {
				Thread.sleep(updateInt);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			updateTime(); // TODO: Fix this. UpdateTime() method is in controller. How to loop this method?
		}
	}
	
}
