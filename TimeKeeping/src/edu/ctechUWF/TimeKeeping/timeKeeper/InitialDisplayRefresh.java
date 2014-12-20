package edu.ctechUWF.TimeKeeping.timeKeeper;
import edu.ctechUWF.TimeKeeping.timerInitWindow.Timer;
public class InitialDisplayRefresh implements Runnable {
	public void run(){
		new edu.ctechUWF.TimeKeeping.timerInitWindow.Timer();
			//while (true){
			try {
				Timer.refreshLanding();
				Thread.sleep(100);
				Timer.refreshDisplay();
				//Timer.refreshLanding();
				Thread.sleep(100);
				Timer.refreshDisplay();
				//Timer.refreshLanding();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		//}
	}
}
