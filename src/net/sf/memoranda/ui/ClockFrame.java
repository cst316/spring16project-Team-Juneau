package net.sf.memoranda.ui;

import java.awt.Font;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;

/**
 * A class to build a frame and populate it with the
 * current date and time.
 * @author TAR
 *
 */
public class ClockFrame {
	private JFrame clockFrame;
	private JLabel lblClock;
	
	/**
	 * Builds the frame to display the clock
	 */
	public ClockFrame(){
		clockFrame = new JFrame();
		lblClock = new JLabel("Place Holder");
		
		clockFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		clockFrame.getContentPane().setLayout(null);
		clockFrame.setSize(650, 110);
		
		lblClock.setFont(new Font("Georgia", Font.BOLD, 24));
		lblClock.setText("SOME TEXT FOR MY CLOCK");
		lblClock.setBounds(10, 5, 630, 80);
		clockFrame.getContentPane().add(lblClock);
		
		clock();
		
		clockFrame.getContentPane().setVisible(true);
		clockFrame.setVisible(true);
		
	}
	
	/**
	 * Retrieves the current date/time and updates the lblClock text to reflect.
	 */
	public void clock(){
		Thread clockTread = new Thread(){
			public void run(){
				try {
					while(true){

						Calendar calendar = new GregorianCalendar();
						int day = calendar.get(Calendar.DAY_OF_MONTH);
						int month = calendar.get(Calendar.MONTH+1);
						int year = calendar.get(Calendar.YEAR);
						int second = calendar.get(Calendar.SECOND);
						int minute = calendar.get(Calendar.MINUTE);
						int hour = calendar.get(Calendar.HOUR);
						String time = ("Current Time:" + hour + ":" + minute + ":" + second);
						String date = ("Today's Date:" + month + "/" + day + "/" + year);
						
						lblClock.setText(time + " " + date);
						sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		};
		
		clockTread.start();
	}
}
