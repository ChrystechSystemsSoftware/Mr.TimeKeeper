package edu.ctechUWF.TimeKeeping.timeKeeper;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
//import java.io.PrintWriter;
//import java.util.Scanner;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;

public class GenerateReport {
	static String Override = "No";
	public GenerateReport(String Client, String Project, String Task,
			String TotalHrs, String TotalMins, String Desription) {
		String tempOR = Override;
		Override = "No";
		File reportGenFile = new File(Client + ".txt");
		if (reportGenFile.exists()) {
			// Scanner yN = new Scanner (System.in);
			// System.out.println("Do you want to overwrite this file?");
			JButton Yes = new JButton("Yes");
			Yes.addActionListener(new popActions());
			JButton No = new JButton("No");
			No.addActionListener(new popActions());
			Yes.setBackground(Color.GREEN);
			No.setBackground(Color.RED);
			JTextPane Message = new JTextPane();
			Message.setText("Do you want to overwrite this file?");
			JFrame Pop = new JFrame();
			Pop.setLayout(new GridBagLayout());
			Pop.setBackground(Color.CYAN);
			Pop.add(Message);
			Pop.add(Yes);
			Pop.add(No);
			Pop.setVisible(true);
		}
	}
	public GenerateReport(String Client, String Project, String Task,
			String TotalHrs, String TotalMins, String Desription, String Override) {
		File reportGenFile = new File(Client + ".txt");		
		GenerateReport.Override = Override;
		String tempOR = GenerateReport.Override;
		Override = "No";
		GenerateReport.Override = Override;
		if (reportGenFile.exists() && tempOR.equals("No")) {
			// Scanner yN = new Scanner (System.in);
			// System.out.println("Do you want to overwrite this file?");
			JButton Yes = new JButton("Yes");
			Yes.addActionListener(new popActions());
			JButton No = new JButton("No");
			No.addActionListener(new popActions());
			Yes.setBackground(Color.GREEN);
			No.setBackground(Color.RED);
			JTextPane Message = new JTextPane();
			Message.setText("Do you want to overwrite this file?");
			JFrame Pop = new JFrame();
			Pop.setLayout(new GridBagLayout());
			Pop.setBackground(Color.CYAN);
			Pop.add(Message);
			Pop.add(Yes);
			Pop.add(No);
			Pop.setVisible(true);
		}
	}
}

class popActions implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "No"){
			
		}
		//if (e.getActionCommand() == "Yes"){
		//	GenerateReport.Override = "Yes";
			//new GenerateReport(Client,Project,Task,TotalHrs,TotalMins,Description, GenerateReport.Override);
		//}
	}
}