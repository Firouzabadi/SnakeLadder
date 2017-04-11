
public class MainTimer {

	static boolean pauseStatus;
	static double startTime;
	public static void main(String[] args) {
		
		
		TimeThread currentTime = new TimeThread();
		
		while (!pauseStatus) {			
			currentTime.run();
			try {
				currentTime.wait(1000, 0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	
}
