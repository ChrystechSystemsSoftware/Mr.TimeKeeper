package edu.ctechUWF.TimeKeeping.landing;

import javax.swing.*;
import javax.swing.UIManager.*;
import javax.swing.border.BevelBorder;
//import javax.swing.border.Border;
//import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;

import javax.swing.JScrollPane;

import edu.ctechUWF.TimeKeeping.ClientData.ClientsIn;
//import edu.ctechUWF.TimeKeeping.inputScreen.inputScreen;
//import edu.ctechUWF.TimeKeeping.landing.Buffer;
import edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper;
import edu.ctechUWF.TimeKeeping.timerInitWindow.timerInitWindow;
import edu.ctechUWF.TimeKeeping.timerInitWindow.Timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//import java.util.ArrayList;

public class landing {
	GridBagConstraints Constraints = new GridBagConstraints();
	GridBagConstraints TitleConstraints = new GridBagConstraints();
	GridBagConstraints ConstraintsLow = new GridBagConstraints();
	final Dimension MAXPANEWIDTH = new Dimension(300, 100);
	JTextArea Welcome = new JTextArea();
	public JButton submitButton;
	public JButton startAndSubmitButton;
	public JMenuItem newTimer;
	public JMenuItem reset;
	JMenu File;
	JMenu Development;
	JMenuBar mb;
	public ArrayList<String> ActionsSaved = new ArrayList<String>(1);
	public ArrayList<String> CliProTsk = new ArrayList<String>(1);
	public ArrayList<String> Display = new ArrayList<String>(1);

	public JComboBox<?> ASaved;
	public JComboBox<?> TimersActions;

	public JTextArea CurrentTimers;
	JScrollPane container;
	// public JTextArea TasksRunning;
	// JPanel TaskPanel;
	JPanel FillPanel;
	JPanel dummy;
	JPanel OptPanel;
	JFrame Landing;
	String xArray[];

	public GridBagConstraints mainConstraints() {
		Constraints.gridheight = 6;
		Constraints.gridwidth = GridBagConstraints.REMAINDER;
		Constraints.anchor = GridBagConstraints.CENTER;
		Constraints.weightx = 400;
		Constraints.gridheight = 100;
		Constraints.gridwidth = 200;
		Constraints.fill = GridBagConstraints.HORIZONTAL;
		return Constraints;
	}

	public GridBagConstraints TitleConstraints() {
		TitleConstraints.anchor = GridBagConstraints.NORTH;
		TitleConstraints.weightx = 400;
		TitleConstraints.weighty = 0;
		TitleConstraints.gridheight = 100;
		TitleConstraints.gridwidth = 200;
		TitleConstraints.fill = GridBagConstraints.HORIZONTAL;
		return TitleConstraints;
	}

	public GridBagConstraints ConstraintsLow() {
		ConstraintsLow.gridheight = 6;
		ConstraintsLow.gridwidth = GridBagConstraints.REMAINDER;
		ConstraintsLow.anchor = GridBagConstraints.SOUTH;
		ConstraintsLow.weightx = 400;
		ConstraintsLow.gridheight = 100;
		ConstraintsLow.gridwidth = 200;
		ConstraintsLow.fill = GridBagConstraints.HORIZONTAL;
		return ConstraintsLow;
	}

	public JTextArea Welcome() {
		Welcome.setEditable(false);
		Welcome.setFocusable(false);
		Welcome.setPreferredSize(new Dimension(400, 25));
		Welcome.setText("Welcome to TimeKeeper");
		return Welcome;
	}

	public JButton submitButton() {
		submitButton = new JButton();
		submitButton.setRolloverEnabled(true);
		submitButton.setText("Submit");
		submitButton.addActionListener(new Actions());
		submitButton.setForeground(Color.WHITE);
		submitButton.setBackground(Color.BLUE);
		submitButton.setEnabled(true);
		submitButton.setContentAreaFilled(true);
		submitButton.setPreferredSize(new Dimension(100, 50));
		submitButton.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.RAISED));
		return submitButton;
	}

	public JButton startAndSubmitButton() {
		startAndSubmitButton = new JButton();
		startAndSubmitButton.setRolloverEnabled(true);
		startAndSubmitButton.setText("Save and Submit");
		return startAndSubmitButton;
	}

	public void LnF() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				System.out.println(info.getName());
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
		}
	}

	public JMenuItem newTimer() {
		newTimer = new JMenuItem();
		newTimer.addActionListener(new Actions());
		newTimer.setText("New Timer");
		newTimer.setEnabled(true);
		return newTimer;
	}

	public JMenuItem reset() {
		reset = new JMenuItem();
		reset.addActionListener(new Actions());
		reset.setText("Reset");
		reset.setEnabled(true);
		return reset;
	}

	public JMenu File() {
		File = new JMenu();
		File.setText("File");
		File.setBackground(Color.BLACK);
		File.setForeground(Color.BLACK);
		File.add(newTimer);
		return File;
	}

	public JMenu Development() {
		Development = new JMenu();
		Development.setText("Development");
		Development.setBackground(Color.BLACK);
		Development.setForeground(Color.BLACK);
		Development.add(reset);
		return Development;
	}

	public JMenuBar mb() {
		mb = new JMenuBar();
		mb.setBackground(Color.BLACK);
		mb.setForeground(Color.BLACK);
		mb.add(File);
		mb.add(Development);
		mb.setVisible(true);
		return mb;
	}

	public void savedUpdate() {

	}

	public JComboBox<?> ASaved() {
		ActionsSaved.add("Actions");
		ActionsSaved.add("Open New Item Dialog");
		ActionsSaved.add("Start Timer");
		ActionsSaved.add("Stop Timer");
		// TODO Enable this when ready to remove timers from file after getting
		// file saving working.//ActionsSaved.add("Remove Timer");
		ActionsSaved.add("Save Data");
		// ActionsSaved.add("Generate Report");
		/*String[] acts = new String[ActionsSaved.size()];
		for (int i = 0; i < ActionsSaved.size(); i++) {
			acts[i] = (String) ActionsSaved.get(i);
		}*/
		String[] acts = new String[ActionsSaved.size()];
		acts = edu.ctechUWF.TimeKeeping.landing.Buffer.convertALtoARRAY(ActionsSaved, acts);
		ASaved = new JComboBox<Object>(acts);
		ASaved.setEditable(false);
		ASaved.setPreferredSize(new Dimension(200, 24));
		ASaved.setSelectedIndex(0);
		return ASaved;
	}

	public JComboBox<?> TimersActions() {
		xArray = edu.ctechUWF.TimeKeeping.landing.Buffer.convertALtoARRAY(
				CliProTsk, xArray);
		for (int qual = 0; qual < xArray.length; qual++) {
			System.out.println("Qual: " + qual);
			System.out.println(xArray[qual] + " : " + CliProTsk.get(qual));
		}
		TimersActions = new JComboBox<Object>(xArray);
		for (int ind = 0; ind < xArray.length; ind++) {
			System.out.println("ind: " + ind);
			System.out.println("XARRAY[" + ind + "]: " + xArray[ind]);
			System.out.println("TimersActions.getItemAt(" + ind + "): "
					+ TimersActions.getItemAt(ind));
		}
		TimersActions.setEditable(false);
		TimersActions.setPreferredSize(new Dimension(200, 24));
		//TimersActions.setSelectedIndex(0);
		//System.out.println("XARRAY: " + xArray);
		return TimersActions;
	}

	/*
	 * public JTextArea TasksRunning() { TasksRunning = new JTextArea();
	 * TasksRunning.setText("Tasks"); return TasksRunning; }
	 */

	/*
	 * public JPanel TaskPanel() { TaskPanel = new JPanel();
	 * TaskPanel.setSize(400, 400); TaskPanel.setLayout(new GridBagLayout());
	 * TaskPanel.setBackground(Color.GREEN); TaskPanel.add(TasksRunning); return
	 * TaskPanel; }
	 */

	public ArrayList<?> Display() {
		return Display;
	}

	public void UpdateTimers() {
		// CurrentTimers.removeAll();
		CurrentTimers.setText("");
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
		}
		for (int i = 0; i < Display.size(); i++) {
			CurrentTimers.append(Display.get(i));
		}
	}

	public void addTimerRule() {
		System.out.println("addTimerRule()");
		Display.add("Client Project Task MM/DD/YYYY HH:MM:SS currentHours:currentMinutes\n\n");
	}

	public JTextArea CurrentTimers() {
		CurrentTimers = new JTextArea("");
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
		}
		CurrentTimers.setAutoscrolls(true);
		// CurrentTimers.setPreferredSize(new Dimension(700,300));
		CurrentTimers.setLineWrap(true);

		UpdateTimers();
		return CurrentTimers;
	}

	public JScrollPane container() {
		container = new JScrollPane(CurrentTimers);
		container.setPreferredSize(new Dimension(700, 300));
		container.setAutoscrolls(true);
		return container;
	}

	public String[] newXArray() {
		xArray = new String[CliProTsk.size()];
		return xArray;
	}

	public void addCliProTskDefaults() {
		// CliProTsk.add("Client, Project, Task");
		// CliProTsk.add("");
	}

	public JPanel FillPanel() {
		FillPanel = new JPanel();
		FillPanel.setSize(400, 400);
		FillPanel.setLayout(new GridBagLayout());
		FillPanel.setBackground(Color.GREEN);
		FillPanel.add(container);
		return FillPanel;
	}

	public JPanel dummy() {
		dummy = new JPanel();
		dummy.setBackground(Color.GREEN);
		return dummy;
	}

	public JPanel OptPanel() {
		OptPanel = new JPanel();
		OptPanel.setSize(200, 400);
		OptPanel.setLayout(new GridBagLayout());
		OptPanel.setBackground(Color.GREEN);
		OptPanel.add(ASaved, TitleConstraints);
		OptPanel.add(TimersActions, TitleConstraints);
		return OptPanel;
	}

	public void DisplayRefresh() {
		CurrentTimers.setVisible(true);
	}

	public void LandingRefresh() {
		edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.land.Landing
				.setEnabled(false);
		TimersActions.setVisible(true);
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// OptPanel.remove(TimersActions);
		// OptPanel.remove(TimersActions);
		OptPanel.removeAll();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		OptPanel.add(ASaved);
		/*
		 * try { Thread.sleep(500); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */
		OptPanel.add(TimersActions, TitleConstraints);
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/*
		 * OptPanel.setVisible(false);try { Thread.sleep(50); } catch
		 * (InterruptedException e) { e.printStackTrace(); }
		 */
		OptPanel.setVisible(true);
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CurrentTimers.setVisible(true);
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// FillPanel.removeAll();
		// FillPanel.add(CurrentTimers);
		// FillPanel.setVisible(false);
		FillPanel.setVisible(true);
		// Landing.setVisible(false);
		// Landing.setVisible(true);
		// TimeKeeper.init.box().isVisible();
		/*
		 * if (tf) { TimeKeeper.init.box().setVisible(false);
		 * TimeKeeper.init.box().setVisible(true); }
		 */
		edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.land.Landing
				.setEnabled(true);

	}

	public JFrame Landing(double Version, String VersionType) {
		Landing = new JFrame();
		Landing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Landing.setSize(1200, 600);
		Landing.setLayout(new BorderLayout());
		Landing.setJMenuBar(mb);
		// Landing.add(TaskPanel, BorderLayout.EAST);
		// Landing.add(FillPanel, BorderLayout.CENTER);
		Landing.add(FillPanel, BorderLayout.EAST);
		Landing.add(dummy, BorderLayout.CENTER);
		Landing.add(OptPanel, BorderLayout.WEST);
		Landing.add(submitButton, BorderLayout.SOUTH);
		Landing.setTitle("TimeKeeper: " + VersionType + " " + Version);
		Landing.setBackground(Color.GREEN);
		Landing.setEnabled(true);
		Landing.setVisible(true);
		return Landing;
	}

	public landing(double Version, String VersionType) {

		LnF();

		mainConstraints();

		TitleConstraints();

		ConstraintsLow();

		submitButton();

		startAndSubmitButton();

		newTimer();

		reset();

		File();

		Development();

		mb();

		savedUpdate();

		ASaved();

		// TasksRunning();

		Display();

		addTimerRule();

		CurrentTimers();

		container();

		addCliProTskDefaults();

		newXArray();

		TimersActions();

		// TaskPanel();

		FillPanel();

		dummy();

		OptPanel();

		Landing(Version, VersionType);

		/**
		 * Menu Items File Menu: Contains all items for File operations (new
		 * Timer) Development Menu: Contains all items for testing/enabling and
		 * disabling functionality of the program
		 */
		/**************
		 * Item New Timer is in the File menu Item Reset is in the Development
		 * menu
		 **************/
		/** Menu bar on window = mb */
		/** The Window on the screen = Landing */
		// Window started verification for console (Debug)
		System.out.println("Window Started");
	}

	public landing(String[] Items) {

	}
}

class Actions implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("\nSelected: " + e.getActionCommand());
		if (e.getActionCommand().equals("New Timer")) {
			System.out.println("New Timer Button Pressed");
		}
		if (e.getActionCommand().equals("Submit")) {
			System.out.println("Submit Button Pressed");
			String Returned = TimeKeeper.land.ASaved.getSelectedItem()
					.toString();
			System.out.println("Returned: " + Returned);
			System.out.println("SelectedTimersActionsIndex: "
					+ TimeKeeper.land.TimersActions.getSelectedIndex());
			 String Subject =
			 TimeKeeper.land.TimersActions.getItemAt(TimeKeeper.land.TimersActions.getSelectedIndex()).toString();
			//String Subject = Integer.toString(TimeKeeper.land.TimersActions
				//	.getSelectedIndex());
			System.out.println("Subject: " + Subject);
			System.out.println("Field: "
					+ TimeKeeper.land.TimersActions.getItemAt(
							TimeKeeper.land.TimersActions.getSelectedIndex())
							.toString());
			System.out.println("Subject = Field: "
					+ TimeKeeper.land.TimersActions.getSelectedItem()
							.toString().equals(Subject));
			// System.out.println(Subject);
			if (Returned.equals("Open New Item Dialog")) {
				TimeKeeper.init = new timerInitWindow();
			}
			if (Returned.equals("Save Data")) {
				new ClientsIn().PostTXT();
			}
			if (Returned.equalsIgnoreCase("Start Timer")) {
				System.out.println("{" + Subject + "}" + " -- " + Returned);
				System.out
						.println(edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.TasksArrayList);
				//if (((TimeKeeper.land.TimersActions.getSelectedIndex() * 2) + 1) >= 1) {
					System.out.println((TimeKeeper.land.TimersActions
							.getSelectedIndex() * 2) + 1);
				//} else {
					//TimeKeeper.land.TimersActions.setSelectedIndex(1);
				//}
				System.out
						.println("Timer Affected: " + edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.TasksArrayList
								.get(((TimeKeeper.land.TimersActions
										.getSelectedIndex()) * 2) + 1));
				Timer d = (Timer) edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.TasksArrayList
						.get(((TimeKeeper.land.TimersActions.getSelectedIndex()) * 2) + 1);
				d.StartCounting();
			}
			if (Returned.equalsIgnoreCase("Stop Timer")) {
				/*
				 *  System.out.println("{" + Subject + "}" + " -- " + Returned);
				 *  System.out.println(edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.TasksArrayList.get(((TimeKeeper.land.TimersActions.getSelectedIndex()) * 2) + 1));
				 *  Timer d = (Timer) edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.TasksArrayList.get(((TimeKeeper.land.TimersActions.getSelectedIndex()) * 2) + 1);
				 *  d.StopCounting();
				 */
				
				
				System.out.println("{" + Subject + "}" + " -- " + Returned);
				System.out
						.println(edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.TasksArrayList);
				if (((TimeKeeper.land.TimersActions.getSelectedIndex() * 2) + 1) >= 1) {
					System.out.println((TimeKeeper.land.TimersActions
							.getSelectedIndex() * 2) + 1);
				} else {
					TimeKeeper.land.TimersActions.setSelectedIndex(1);
				}
				System.out
						.println("Timer Affected: " + edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.TasksArrayList
								.get(((TimeKeeper.land.TimersActions
										.getSelectedIndex()) * 2) + 1));
				Timer d = (Timer) edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.TasksArrayList
						.get(((TimeKeeper.land.TimersActions.getSelectedIndex()) * 2) + 1);
				
				d.StopCounting();
			}

			System.out.println(Returned);
			TimeKeeper.land.ASaved.setSelectedIndex(0);
			TimeKeeper.land.TimersActions.setSelectedIndex(0);
		}
		if (e.getActionCommand().equals("Reset")) {
			System.out.println("Resetting window buttons");
			TimeKeeper.land.newTimer.setEnabled(true);
		}
	}
}