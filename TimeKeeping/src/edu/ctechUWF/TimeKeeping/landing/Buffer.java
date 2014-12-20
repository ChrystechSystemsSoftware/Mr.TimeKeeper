package edu.ctechUWF.TimeKeeping.landing;

import java.util.ArrayList;

//import edu.ctechUWF.TimeKeeping.timerInitWindow.Timer;
//read on ArrayList
public class Buffer {
	String[] newClients;
	String[] newProjects;
	String[] newTasks;
	String[] newItem1;
	Thread[] newThread1;
	public Buffer(String[] Clients, String[] Projects, String[] Tasks){
		newClients = new String[Clients.length + 1];
		newProjects = new String[Projects.length + 1];
		newTasks = new String[Tasks.length + 1];
		
		for(int i = 0; i < Clients.length; i++){
			newClients[i] = Clients[i];
		}
		for(int i = 0; i < Projects.length; i++){
			newProjects[i] = Projects[i];
		}
		for(int i = 0; i < Tasks.length; i++){
			newTasks[i] = Tasks[i];
		}
		
		Clients = new String[newClients.length];
		Projects = new String[newProjects.length];
		Tasks = new String[newTasks.length];
		
		for(int i = 0; i < Clients.length; i++){
			Clients[i] = newClients[i];
		}
		for(int i = 0; i < Projects.length; i++){
			Projects[i] = newProjects[i];
		}
		for(int i = 0; i < Tasks.length; i++){
			Tasks[i] = newTasks[i];
		}
	}
	public Buffer(){}
	public Buffer(String[] item1){
		newItem1 = new String[item1.length + 1];
		for(int i = 0; i < item1.length; i++){
			newItem1[i] = item1[i];
		}
		item1 = new String[newItem1.length];
		for(int i = 0; i < item1.length; i++){
			item1[i] = newItem1[i];
		}
	}
	public void add(int numAdd, String[] item1){
		newItem1 = new String[item1.length + numAdd];
		for(int i = 0; i < item1.length; i++){
			newItem1[i] = item1[i];
		}
		item1 = new String[newItem1.length];
		for(int i = 0; i < item1.length; i++){
			item1[i] = newItem1[i];
		}
	}
	public void add (int numAdd, String[] item1, Thread[] thread1){
		newItem1 = new String[item1.length + numAdd];
		newThread1 = new Thread[thread1.length + numAdd];
		for(int i = 0; i < item1.length; i++){
			newItem1[i] = item1[i];
			newThread1[i] = thread1[i];
		}
		item1 = new String[newItem1.length];
		thread1 = new Thread[newThread1.length];
		for(int i = 0; i < item1.length; i++){
			item1[i] = newItem1[i];
			thread1[i] = newThread1[i];
		}
		
	}
	public static String[] convertALtoARRAY(ArrayList<String> AL, String[] ARRAY){
		for (int i = 0; i < AL.size(); i++){
			ARRAY[i] = (String)AL.get(i);
		}
		return ARRAY;
	}
	public void display(Object[] obj){
		System.out.println(obj.length);
	}
	public void display(Object[] obj, int x){
		System.out.println((String)obj[x]);
	}
}
