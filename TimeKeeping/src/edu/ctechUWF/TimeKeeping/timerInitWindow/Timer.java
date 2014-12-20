package edu.ctechUWF.TimeKeeping.timerInitWindow;

import java.util.Date;
//import edu.ctechUWF.TimeKeeping.timeKeeper.*;
//import edu.ctechUWF.TimeKeeping.landing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

//import edu.ctechUWF.TimeKeeping.timerInitWindow.*;

public class Timer implements Runnable {
	String Client;
	String Project;
	String Task;
	String startDate;
	// final int FIFTEENMINUTES = 900000;
	final int MINUTE = 60000;
	public int updateInterval = 1;
	double hCurr;
	double mCurr;
	Date date = new Date();
	DateFormat time = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	private boolean count = false;

	public Timer(String Client, String Project, String Task) {
		this.Client = Client;
		this.Project = Project;
		this.Task = Task;
		edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.Clients.add(Client);
		edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.Projects.add(Project);
		edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.Tasks.add(Task);
		hCurr = 0.00;
		mCurr = 0.00;
	}

	public Timer(String Client, String Project, String Task, int hCur, int mCur) {
		this.Client = Client;
		this.Project = Project;
		this.Task = Task;
		hCurr = hCur;
		mCurr = mCur;
	}

	public Timer() {

	}

	public void getStartDate() {
		date = new Date();
		startDate = time.format(date);
	}

	public void timeAddFifteen() {
		if (count == true) {
			mCurr += updateInterval;
			if (mCurr >= 60) {
				mCurr -= 60;
				hCurr++;
			}
		}
	}

	public void DispTimeCurrent() {
		System.out.println(hCurr + " " + mCurr);
	}

	public double getCurrHours() {
		return hCurr;
	}

	public double getCurrMinutes() {
		return mCurr;
	}

	public void StartCounting() {
		count = true;
	}

	public void StopCounting() {
		count = false;
	}

	public void UpdateCliProTsk() {
		edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.land.CliProTsk
				.add(Client + ", " + Project + ", " + Task);
		refreshLanding();
	}

	public static void refreshDisplay() {
		edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.land.newXArray();
		edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.land.TimersActions();
		edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.land.UpdateTimers();
		edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.land.DisplayRefresh();
	}

	public static void refreshLanding() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.land.newXArray();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.land.TimersActions();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.land.UpdateTimers();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.land.LandingRefresh();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		// String Client = "";
		String currDate = null;
		edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.land.Display.add(Client
				+ " " + Project + " " + Task + "\n");
		int size = edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.land.Display
				.size();
		UpdateCliProTsk();
		while (true) {
			/*
			 * try { Client =
			 * edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.time.Client; }
			 * catch (Exception igloo) { igloo.printStackTrace(); }
			 */
			date = new Date();
			currDate = time.format(date);
			timeAddFifteen();

			System.out.print(Client + " " + currDate + "\n");

			DispTimeCurrent();
			edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.land.Display
					.remove(size - 1);
			edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.land.Display.add(
					(size - 1), Client + ", " + Project + ", " + Task + " ~"
							+ currDate + " " + (int) hCurr + ":" + (int) mCurr
							+ "" + "\n");
			edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.land.UpdateTimers();
			edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.land
					.LandingRefresh();

			try {
				Thread.sleep(updateInterval * MINUTE);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
