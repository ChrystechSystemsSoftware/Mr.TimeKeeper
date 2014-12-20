/**
 * This Program is created for the client expectations given during project SE1:TimeKeeper:TeamSandwich
 * This Program is written by Louis LeDuc with the help of Team Sandwich.
 * Please do not try to disassemble and use our program without express permission.
 * 
 * Reminder: All items not explicitly defined as "Creative Commons" is subject to Copyright Law as a creative work.
 */

package edu.ctechUWF.TimeKeeping.timeKeeper;

//import edu.ctechUWF.TimeKeeping.inputScreen.inputScreen;
import edu.ctechUWF.TimeKeeping.landing.landing;
import edu.ctechUWF.TimeKeeping.timeKeeper.InitialDisplayRefresh;
import edu.ctechUWF.TimeKeeping.timerInitWindow.timerInitWindow;
import edu.ctechUWF.TimeKeeping.timerInitWindow.Timer;
import edu.ctechUWF.TimeKeeping.ClientData.ClientsOut;

import java.util.ArrayList;

public class TimeKeeper {
	private static double Version = 009.500;
	private static String VersionType = "Beta";
	public static timerInitWindow init;
	public static landing land;
	// public static inputScreen iScreen;
	public static Timer time;
	public static ArrayList<Object> TasksArrayList;
	// public static ClientsIn cliIn;
	public static ClientsOut cliOut;
	public static ArrayList<String> Clients = new ArrayList<String>(0);
	public static ArrayList<String> Projects = new ArrayList<String>(0);
	public static ArrayList<String> Tasks = new ArrayList<String>(0);
	public static ArrayList<String> ClientsData = new ArrayList<String>(0);
	public static ArrayList<Integer> ClientHCurr = new ArrayList<Integer>(0);
	public static ArrayList<Integer> ClientMCurr = new ArrayList<Integer>(0);

	public static void main(String[] args) {

		System.out.println("Starting up...");
		TasksArrayList = new ArrayList<Object>(1);
		cliOut = new ClientsOut();
		cliOut.getTXT();
		land = new landing(Version, VersionType);
		Thread idr = new Thread(new InitialDisplayRefresh());
		idr.start();
		Thread refresh = new Thread(new DisplayRefresh());
		refresh.start();
		/*
		 * for (int i = 0; i < Clients.size(); i++){
		 * land.CliProTsk.add(Clients.get(i) + ", " + Projects.get(i) + ", " +
		 * Tasks.get(i)); } for (int i = 0; i < Clients.size(); i++){
		 * land.Display.add(Clients.get(i) + ", " + Projects.get(i) + ", " +
		 * Tasks.get(i) + " " + ClientsData.get(i) + "\n"); }
		 */
		System.out.println(land.Display);
		for (int i = 0; i < Clients.size(); i++) {
			Timer z = new Timer(Clients.get(i), Projects.get(i), Tasks.get(i),
					(int) ClientHCurr.get(i), (int) ClientMCurr.get(i));
			z.StopCounting();
			Thread x = new Thread(z);
			x.start();
			TimeKeeper.TasksArrayList.add(x);
			TimeKeeper.TasksArrayList.add(z);

		}
		System.out.println(land.Display);

		edu.ctechUWF.TimeKeeping.timerInitWindow.Timer.refreshLanding();
		System.out.println(land.Display);

		// cliIn = new ClientsIn();
		// cliIn.PostTXT();
	}
}