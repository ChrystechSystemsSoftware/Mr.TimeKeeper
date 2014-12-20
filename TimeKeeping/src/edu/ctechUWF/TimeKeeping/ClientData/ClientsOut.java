package edu.ctechUWF.TimeKeeping.ClientData;

import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ClientsOut {

	Scanner read = null;
	Scanner readData = null;

	// public ArrayList<String> Clients = new ArrayList<String>(0);
	// public ArrayList<String> Projects = new ArrayList<String>(0);
	// public ArrayList<String> Tasks = new ArrayList<String>(0);
	public ClientsOut() {
		try {
			File clitxt = new File("Clients.txt");
			//if (clitxt.exists())
			
			File clidattxt = new File("ClientsData.txt");
			//if(clidattxt.exists())
			
			if (!clitxt.exists()) {
				try {
					clitxt.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (!clidattxt.exists()) {
				try {
					clidattxt.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			read = new Scanner(clitxt);
			readData = new Scanner(clidattxt);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void get() {
		try {
			File filer = new File("Clients.xml");
			if (!filer.exists()) {
				ClientsIn.createFile();
			} else if (filer.length() == 0) {
				System.out.println("File Empty");
			} else {
				System.out.println(filer.length());
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory
						.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(filer);
				doc.getDocumentElement().normalize();
				NodeList Clients = doc.getElementsByTagName("Client");
				NodeList Projects = doc.getElementsByTagName("Project");
				NodeList Tasks = doc.getElementsByTagName("Tasks");
				ArrayList<String> ClientsList = new ArrayList<String>(0);
				ArrayList<String> ProjectsList = new ArrayList<String>(0);
				ArrayList<String> TasksList = new ArrayList<String>(0);
				System.out.println(Clients.getLength() + " "
						+ Projects.getLength() + " " + Tasks.getLength());
				for (int i = 0; i < Clients.getLength(); i++) {
					ClientsList.add(Clients.item(i).getTextContent());
				}
				for (int i = 0; i < Projects.getLength(); i++) {
					ProjectsList.add(Projects.item(i).getTextContent());
				}
				for (int i = 0; i < Tasks.getLength(); i++) {
					TasksList.add(Tasks.item(i).getTextContent());
				}
				if (ClientsList.size() != ProjectsList.size()
						|| ProjectsList.size() != TasksList.size()) {
					System.out
							.println("FATAL ERROR: File Input (Tags Mismatch Format Specifications -- CORRUPT)");
					System.exit(1);
				}
			}

		} catch (FileNotFoundException a) {
			System.out.println("The File Isn't There");
			a.printStackTrace();
		} catch (ParserConfigurationException p) {
			System.out.println("Wrong Format");
			p.printStackTrace();
		} catch (IOException o) {
			System.out.println("Read Error, Do You Have Permission?");
			o.printStackTrace();
		} catch (SAXException s) {
			System.out.println("Sax Exception");
			s.printStackTrace();
		}
	}

	public void getTXT() {
		System.out.println("PING-getTXT");
		File txtFile = new File("Clients.txt");
		System.out.println(txtFile.exists());
		File txtDataFile = new File("ClientsData.txt");
		System.out.println(txtDataFile.exists());
		System.out.println(txtFile.length());
		System.out.println(txtDataFile.length());
		if (!txtFile.exists()) {
			try {
				txtFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (!txtDataFile.exists()) {
			try {
				txtDataFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(txtFile.exists() + " " + txtDataFile.exists());
		if (read.hasNextLine())
			read.nextLine();
		while (read.hasNextLine()) {
			// System.out.println("PING");

			if (read.hasNextLine())
				edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.Clients.add(read
						.nextLine());
			// System.out.println(read.nextLine());
			// System.out
			// .println(edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.Clients);
			// }
			if (read.hasNextLine())
				edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.Projects
						.add(read.nextLine());
			if (read.hasNextLine())
				edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.Tasks.add(read
						.nextLine());
		}
		if (readData.hasNextLine())
			readData.nextLine();
		while (readData.hasNextLine()) {
			if (readData.hasNextLine()) {
				System.out.println("Next Line " + readData.hasNextLine());
				String temp1 = null;
				String temp2 = null;
				String temp3 = null;
				int tempH = 0;
				int tempM = 0;
				if (readData.hasNext()) {
					String tmp = readData.next();
					System.out.println("tmp1 = " + tmp);
					temp1 = tmp;
				}
				if (readData.hasNext()) {
					String tmp = readData.next();
					System.out.println("tmp2 = " + tmp);
					temp2 = tmp;
				}
				if (readData.hasNext()) {
					String tmp = readData.next();
					System.out.println("tmp3 = " + tmp);
					temp3 = tmp;
				}
				System.out.println(temp1);
				System.out.println(temp2);
				System.out.println(temp3);
				System.out.println("temp3 " + temp3);
				int colonAt = temp3.lastIndexOf(':');
				System.out.println(colonAt);
				System.out.println(Integer.parseInt(temp3.substring(0, colonAt)
						.trim()));
				tempH = Integer.parseInt(temp3.substring(0, colonAt).trim());
				System.out.println(tempH);
				System.out.println(Integer.parseInt(temp3.substring(
						colonAt + 1, temp3.length())));
				tempM = Integer.parseInt(temp3.substring(colonAt + 1,
						temp3.length()));
				System.out.println(tempM);
				edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.ClientHCurr
						.add(tempH);
				edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.ClientMCurr
						.add(tempM);
				edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.ClientsData
						.add(temp1 + " " + temp2 + " " + temp3);

			}

		}

		System.out
				.println(edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.Clients);
		System.out
				.println(edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.Projects);
		System.out
				.println(edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.Tasks);
		System.out
				.println(edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.ClientsData);
		System.out
				.println(edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.ClientHCurr);
		System.out
				.println(edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.ClientMCurr);

		if (edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.Clients.size() != edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.Projects
				.size()
				|| edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.Projects
						.size() != edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.Tasks
						.size()
				|| edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.Tasks.size() != edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.ClientsData
						.size()
				|| edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.ClientsData
						.size() != edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.ClientHCurr
						.size()
				|| edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.ClientHCurr
						.size() != edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.ClientMCurr
						.size()) {
			System.out.println("File data mismatch: CORRUPT");
			System.exit(1);
		}
		read.close();
		readData.close();
	}
}
