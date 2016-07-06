package main.app.core.view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClockWidgetGUI extends JFrame {
	
	private JLabel lblSs; // label for hour
	private JLabel lblColMs; // colon between hour and minute
	private JLabel lblMm; // label for minute
	private JLabel lblColHm; // label for colon between minute and second
	private JLabel lblHh; // label for second
	
	public ClockWidgetGUI() {
		getContentPane().setLayout(null);
		
		lblSs = new JLabel("HH"); 
		lblSs.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblSs.setBounds(120, 11, 30, 50);
		getContentPane().add(lblSs);
		
		lblColMs = new JLabel(":"); 
		lblColMs.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblColMs.setBounds(103, 11, 11, 50);
		getContentPane().add(lblColMs);
		
		lblMm = new JLabel("MM");
		lblMm.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblMm.setBounds(59, 11, 34, 50);
		getContentPane().add(lblMm);
		
		lblColHm = new JLabel(":");
		lblColHm.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblColHm.setBounds(42, 11, 11, 50);
		getContentPane().add(lblColHm);
		
		lblHh = new JLabel("SS");
		lblHh.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblHh.setBounds(10, 11, 27, 50);
		getContentPane().add(lblHh);
		setSize(185, 111);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void setHour(String hour) {
		lblHh.setText(hour);
	}
	
	public void setMinute(String minute) {
		lblMm.setText(minute);
	}
	
	public void setSecond(String second) {
		lblSs.setText(second);
	}
	
	public String getTime() {
		return lblHh + ":" + lblMm + ":" + lblSs;
	}
}
