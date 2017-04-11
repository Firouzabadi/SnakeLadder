import javax.swing.JLabel;

public class TimeThread extends Thread {
	JLabel label;
	private boolean flag = false;
	private Integer time;
	{
		setTime(0);
	}

	public TimeThread(Integer time, JLabel label) {
		setTime(time);
		this.label = label;
	}

	@Override
	public void run() {
		while (true) {
			if (flag) {
				label.setText(getTime().toString());
				try {
					Thread.sleep(990);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				setTime(getTime() + 1);
			}

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}