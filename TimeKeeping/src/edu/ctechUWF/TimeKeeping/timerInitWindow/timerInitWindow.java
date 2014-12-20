package edu.ctechUWF.TimeKeeping.timerInitWindow;

import javax.swing.*;
import javax.swing.UIManager.*;
import javax.swing.border.BevelBorder;
//import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

//import edu.ctechUWF.TimeKeeping.inputScreen.inputScreen;
import edu.ctechUWF.TimeKeeping.landing.Buffer;
import edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper;
import edu.ctechUWF.TimeKeeping.timerInitWindow.Timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
//import java.util.ArrayList;

public class timerInitWindow {

	public JMenuItem newClient;
	GridBagConstraints Constraints = new GridBagConstraints();
	public GridBagConstraints ConstraintsLow = new GridBagConstraints();
	public final Dimension MAXPANEWIDTH = new Dimension(300, 100);
	public JButton submitButton;
	public JButton startAndSubmitButton;
	JMenuItem reset;
	JMenu File;
	JMenu Job;
	JMenu Development;
	JMenuBar mb;
	// inputScreen ThanksScreen;
	JFrame box;
	public JFrame iScreen;
	public Timer TimeThis;
	public Thread[] Timers = new Thread[0];
	public String[] Clients = new String[0];
	Buffer ThreadBuffer = new Buffer();
	public JComboBox<?> ClientEntry;
	public JComboBox<?> ProjectEntry;
	public JComboBox<?> TaskEntry;
	JPanel ClientPanel;
	JPanel ProjectPanel;
	JPanel TaskPanel;
	JPanel ButtonsBox;

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

	public GridBagConstraints Constraints() {
		Constraints.gridheight = 6;
		Constraints.gridwidth = GridBagConstraints.REMAINDER;
		Constraints.anchor = GridBagConstraints.CENTER;
		Constraints.weightx = 400;
		Constraints.gridheight = 100;
		Constraints.gridwidth = 200;
		Constraints.fill = GridBagConstraints.HORIZONTAL;
		return Constraints;
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

	public JButton submitButton() {
		submitButton = new JButton();
		submitButton.setRolloverEnabled(true);
		submitButton.setText("Submit Job Without Starting");
		submitButton.addActionListener(new Actions());
		submitButton.setForeground(Color.WHITE);
		submitButton.setEnabled(true);
		submitButton.setContentAreaFilled(true);
		submitButton.setBackground(Color.BLUE);
		submitButton.setPreferredSize(new Dimension(200, 50));
		submitButton.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.RAISED));
		return submitButton;
	}

	public JButton startAndSubmitButton() {
		startAndSubmitButton = new JButton();
		startAndSubmitButton.setRolloverEnabled(true);
		startAndSubmitButton.setText("Start and Submit Job");
		startAndSubmitButton.addActionListener(new Actions());
		startAndSubmitButton.setForeground(Color.WHITE);
		startAndSubmitButton.setEnabled(true);
		startAndSubmitButton.setContentAreaFilled(true);
		startAndSubmitButton.setBackground(Color.BLUE);
		startAndSubmitButton.setPreferredSize(new Dimension(200, 50));
		startAndSubmitButton.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.RAISED));
		return startAndSubmitButton;
	}

	public JMenuItem newClient() {
		newClient = new JMenuItem();
		newClient.addActionListener(new Actions());
		newClient.setText("New Client");
		newClient.setEnabled(true);
		return newClient;
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
		File.add(newClient);
		return File;
	}

	public JMenu Job() {
		Job = new JMenu();
		Job.setText("Job");
		Job.setBackground(File.getBackground());
		Job.setForeground(File.getForeground());
		return Job;
	}

	public JMenu Development() {
		Development = new JMenu();
		Development.setText("Development");
		Development.setBackground(File.getBackground());
		Development.setForeground(File.getForeground());
		Development.add(reset);
		return Development;
	}

	public JMenuBar mb() {
		mb = new JMenuBar();
		mb.setBackground(Color.BLACK);
		mb.setForeground(Color.BLACK);
		mb.add(File);
		// mb.add(Job);
		mb.add(Development);
		mb.setVisible(true);
		return mb;
	}

	public JComboBox<?> ClientEntry() {
		String x[] = { "Client" };
		ClientEntry = new JComboBox<Object>(x);
		// ClientEntry.setText("Client");
		ClientEntry.setEditable(true);
		ClientEntry.setMaximumSize(MAXPANEWIDTH);
		ClientEntry.setMinimumSize(MAXPANEWIDTH);
		ClientEntry.setBounds(~200, ~0, 100, 200);
		ClientEntry.setPreferredSize(new Dimension(200, 30));
		ClientEntry.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEtchedBorder(EtchedBorder.RAISED),
				BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)));
		ClientEntry.setEditable(true);
		// ClientEntry.selectAll();
		ClientEntry.setFocusable(true);
		ClientEntry.setEnabled(true);
		return ClientEntry;
	}

	public JComboBox<?> ProjectEntry() {
		String x[] = { "Project" };
		ProjectEntry = new JComboBox<Object>(x);

		ProjectEntry.setMaximumSize(MAXPANEWIDTH);
		ProjectEntry.setMinimumSize(MAXPANEWIDTH);
		ProjectEntry.setBounds(~400, ~0, 100, 200);
		ProjectEntry.setPreferredSize(new Dimension(200, 30));
		ProjectEntry.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEtchedBorder(EtchedBorder.RAISED),
				BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)));
		ProjectEntry.setEditable(true);
		ProjectEntry.setFocusable(true);
		ProjectEntry.setEnabled(true);
		return ProjectEntry;
	}

	public JComboBox<?> TaskEntry() {
		String x[] = { "Task" };
		TaskEntry = new JComboBox<Object>(x);
		// TaskEntry.setText("Task");
		TaskEntry.setMaximumSize(MAXPANEWIDTH);
		TaskEntry.setMinimumSize(MAXPANEWIDTH);
		TaskEntry.setBounds(~200, ~0, 100, 200);
		TaskEntry.setPreferredSize(new Dimension(200, 30));
		TaskEntry.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEtchedBorder(EtchedBorder.RAISED),
				BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)));
		TaskEntry.setEditable(true);
		TaskEntry.setFocusable(true);
		TaskEntry.setEnabled(true);
		return TaskEntry;
	}

	public JPanel ClientPanel() {
		ClientPanel = new JPanel();
		ClientPanel.setSize(400, 400);
		ClientPanel.setLayout(new GridBagLayout());
		ClientPanel.add(ClientEntry, Constraints);
		ClientPanel.setBackground(Color.GREEN);
		return ClientPanel;
	}

	public JPanel ProjectPanel() {
		ProjectPanel = new JPanel();
		ProjectPanel.setSize(400, 400);
		ProjectPanel.setLayout(new GridBagLayout());
		ProjectPanel.add(ProjectEntry, Constraints);
		ProjectPanel.setBackground(Color.GREEN);
		return ProjectPanel;
	}

	public JPanel TaskPanel() {
		TaskPanel = new JPanel();
		TaskPanel.setSize(400, 400);
		TaskPanel.setLayout(new GridBagLayout());
		TaskPanel.add(TaskEntry, Constraints);
		TaskPanel.setBackground(Color.GREEN);
		return TaskPanel;
	}

	public JPanel ButtonsBox() {
		ButtonsBox = new JPanel();
		ButtonsBox.setLayout(new BorderLayout());
		ButtonsBox.add(submitButton, BorderLayout.EAST);
		ButtonsBox.add(startAndSubmitButton, BorderLayout.WEST);
		ButtonsBox.setBackground(Color.GREEN);
		return ButtonsBox;
	}

	public JFrame box() {
		box = new JFrame();
		box.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		box.setSize(700, 500);
		box.setLayout(new BorderLayout());
		box.setJMenuBar(mb);
		box.add(ClientPanel, BorderLayout.WEST);
		box.add(ProjectPanel, BorderLayout.CENTER);
		box.add(TaskPanel, BorderLayout.EAST);
		box.add(ButtonsBox, BorderLayout.SOUTH);
		box.setTitle("Initialization Window");
		box.repaint();
		box.setBackground(Color.GREEN);
		box.setEnabled(true);
		box.setVisible(true);
		return box;
	}

	public void verifyWindow() {
		System.out.println("Window Started");
	}

	public timerInitWindow() {

		LnF();
		Constraints();
		ConstraintsLow();
		submitButton();
		startAndSubmitButton();
		newClient();
		reset();
		File();
		Job();
		Development();
		mb();
		ClientEntry();
		ProjectEntry();
		TaskEntry();
		ClientPanel();
		ProjectPanel();
		TaskPanel();
		ButtonsBox();
		box();
		verifyWindow();
	}

	public timerInitWindow(String[] Items) {

	}

	/*
	 * public void thankYou() { iScreen = new JFrame("Thank you"); ThanksScreen
	 * = new inputScreen("open", iScreen, "std"); JTextPane Thankyou = new
	 * JTextPane(); Thankyou.setText("Thank you for testing!!!!!");
	 * Thankyou.setBackground(Color.YELLOW); Thankyou.setEditable(false);
	 * Thankyou.setPreferredSize(new Dimension(200, 50)); iScreen.setLayout(new
	 * GridBagLayout()); iScreen.add(Thankyou);
	 * 
	 * if (iScreen.isVisible() == false) {
	 * TimeKeeper.init.submitButton.setForeground(Color.WHITE);
	 * TimeKeeper.init.submitButton.setEnabled(true); } }
	 */
}

class WindowActions implements WindowListener {
	public void windowOpened(WindowEvent e) {
		System.out.println("WOPENED");
	}

	public void windowClosing(WindowEvent e) {
		System.out.println("WCLOSING");
		TimeKeeper.init.submitButton.setForeground(Color.WHITE);
		TimeKeeper.init.submitButton.setEnabled(true);
		TimeKeeper.init.newClient.setEnabled(true);
		TimeKeeper.init.iScreen.setVisible(false);
	}

	public void windowClosed(WindowEvent e) {
		System.out.println("WCLOSED");
		TimeKeeper.init.submitButton.setForeground(Color.WHITE);
		TimeKeeper.init.submitButton.setEnabled(true);
		TimeKeeper.init.newClient.setEnabled(true);
		TimeKeeper.init.iScreen.setVisible(false);
	}

	public void windowIconified(WindowEvent e) {

	}

	public void windowDeiconified(WindowEvent e) {

	}

	public void windowActivated(WindowEvent e) {

	}

	public void windowDeactivated(WindowEvent e) {

	}
}

class Actions implements ActionListener {
	public void NewClientCommand() {
		System.out.println("New Client: Button Pressed");
		// TimeKeeper.init.newClient.setEnabled(false);
	}

	public void SubmitOnlyCommand() {
		System.out.println("Submit Only: Button Pressed");
		TimeKeeper.init.submitButton.setForeground(Color.BLACK);
		TimeKeeper.init.submitButton.setEnabled(false);
		// TODO Pass Information over to landing for display.
		TimeKeeper.init.submitButton.setEnabled(true);
	}

	public void StartAndSubmitCommand() {
		System.out.println("Start and Submit: Button Pressed");
		TimeKeeper.init.startAndSubmitButton.setForeground(Color.BLACK);
		TimeKeeper.init.startAndSubmitButton.setEnabled(false);
		TimeKeeper.init.ThreadBuffer.add(1, new String[0],
				TimeKeeper.init.Timers);
		String ClientEntryString = TimeKeeper.init.ClientEntry
				.getSelectedItem().toString();
		String ProjectEntryString = TimeKeeper.init.ProjectEntry
				.getSelectedItem().toString();
		String TaskEntryString = TimeKeeper.init.TaskEntry.getSelectedItem()
				.toString();
		Timer z = new Timer(ClientEntryString, ProjectEntryString,
				TaskEntryString);
		z.StartCounting();
		Thread x = new Thread(z);
		x.start();
		TimeKeeper.TasksArrayList.add(x);
		TimeKeeper.TasksArrayList.add(z);
		
		//System.out.println(TimeKeeper.TasksArrayList.get(0));
		//Thread p = (Thread) TimeKeeper.TasksArrayList.get(0);
		//System.out.println((x.getId() == p.getId()));
		/*
		 * try { p.wait(); System.out.println(p.getState()); p.notify();
		 * System.out.println(p.getState()); } catch (Exception e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		TimeKeeper.init.startAndSubmitButton.setForeground(Color.WHITE);
		TimeKeeper.init.startAndSubmitButton.setEnabled(true);
		System.out.println(TimeKeeper.TasksArrayList);
	}

	public void ResetCommand() {
		System.out.println("Resetting window buttons");
		TimeKeeper.init.newClient.setEnabled(true);
		TimeKeeper.init.submitButton.setForeground(Color.WHITE);
		TimeKeeper.init.submitButton.setEnabled(true);
		TimeKeeper.init.startAndSubmitButton.setForeground(Color.WHITE);
		TimeKeeper.init.startAndSubmitButton.setEnabled(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("New Client")) {
			NewClientCommand();
		}
		if (e.getActionCommand().equals(TimeKeeper.init.submitButton.getText())) {
			SubmitOnlyCommand();
		}
		if (e.getActionCommand().equals(
				TimeKeeper.init.startAndSubmitButton.getText())) {
			StartAndSubmitCommand();
		}
		if (e.getActionCommand().equals("Reset")) {
			ResetCommand();
		}
	}
}