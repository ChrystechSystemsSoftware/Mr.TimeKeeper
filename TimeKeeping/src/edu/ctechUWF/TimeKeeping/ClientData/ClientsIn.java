package edu.ctechUWF.TimeKeeping.ClientData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class ClientsIn {
	ArrayList<String> inFile = new ArrayList<String>(0);

	// FileWriter FW;

	public ClientsIn() {

	}

	public static void createFile() {
		File FileToCreate = new File("Clients.xml");

		try {
			FileToCreate.createNewFile();

		} catch (IOException e) {
			System.out
					.println("File Couldn't Be Created, Is this program on a Read-Only Filesystem?");
			e.printStackTrace();
		}
	}

	public void CloseFile() {
		if (!inFile.get(inFile.size() - 1).equals("</File>")) {
			inFile.add(inFile.size(), "</File>");
		}
	}

	public void Post() {
		FileWriter write = null;

		File filer = new File("Clients.xml");
		boolean exists = filer.exists();
		if (!exists) {
			createFile();
		}
		try {
			write = new FileWriter(filer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scanner scanMe = null;
		String currInFile;
		try {
			scanMe = new Scanner(filer);
		} catch (FileNotFoundException e) {
			System.out.println("No File");
		}
		while (scanMe.hasNextLine()) {
			currInFile = scanMe.nextLine();
			inFile.add(currInFile);
		}
		scanMe.close();
		try {
			scanMe = new Scanner(filer);
		} catch (FileNotFoundException e) {
			System.out.println("No File");
		}
		if (inFile.size() == 0) {
			try {
				write.write("<File>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void PostTXT() {
		PrintWriter pw = null;
		PrintWriter DataWriter = null;

		if (edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.Clients.size() == edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.Projects
				.size()
				&& edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.Projects
						.size() == edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.Tasks
						.size()
				// && edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.Tasks ==
				// edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.ClientsData
				&& edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.Clients
						.size() != 0) {
			try {
				// FW = new FileWriter("Clients.txt");
				pw = new PrintWriter("Clients.txt");
				DataWriter = new PrintWriter("ClientsData.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.Clients
					.size(); i++) {
				System.out.println(i);
				/*
				 * try (OutputStream out = new BufferedOutputStream(
				 * Files.newOutputStream(CREATE, APPEND))) { out.write(data, 0,
				 * data.length); } catch (IOException x) {
				 * System.err.println(x); }
				 */
				pw.print("\n"
						+ edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.Clients
								.get(i));
				pw.print("\n"
						+ edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.Projects
								.get(i));
				pw.print("\n"
						+ edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.Tasks
								.get(i));
				System.out
						.println(edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.ClientsData);
				if (edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.ClientsData.size() > i)
					edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.ClientsData
							.remove(i);
				edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.ClientsData
						.add(i,
								edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.land.Display
										.get(i + 1)
										.substring(
												edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.land.Display
														.get(i + 1)
														.lastIndexOf('~') + 1,
												edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.land.Display
														.get(i + 1).length())
										.trim());
				System.out
						.println("ClientsData Current: "
								+ edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.ClientsData);
				DataWriter
						.print("\n"
								+ edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.ClientsData
										.get(i).trim());
			}
		}
		if (pw != null)
		pw.close();
		if (DataWriter != null)
		DataWriter.close();
	}
}
