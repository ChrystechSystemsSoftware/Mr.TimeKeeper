package edu.ctechUWF.TimeKeeping.timeKeeper;
import edu.ctechUWF.TimeKeeping.timerInitWindow.Timer;
public class DisplayRefresh implements Runnable {
	public void run(){
		while (true){
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Timer.refreshDisplay();
			System.out.println("CliProTsk: " + edu.ctechUWF.TimeKeeping.timeKeeper.TimeKeeper.land.CliProTsk);
			new edu.ctechUWF.TimeKeeping.ClientData.ClientsIn().PostTXT();
			
		}
	}
}
