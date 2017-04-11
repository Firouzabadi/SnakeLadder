import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Choronometer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Choronometer frame = new Choronometer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Integer time = 0;
	public Choronometer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel label = new JLabel("");
		label.setBounds(65, 26, 46, 14);
		contentPane.add(label);
		
		JButton btnStart = new JButton("Start");
		
		btnStart.setBounds(99, 65, 75, 23);
		contentPane.add(btnStart);
		
		
		JButton btnStop = new JButton("Stop");
		btnStop.setBounds(10, 65, 75, 23);
		contentPane.add(btnStop);

		TimeThread thread = new TimeThread(time, label);
		thread.start();
		
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread.setFlag(true);
			}
		});
		
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread.setFlag(false);
			}
		});
	
	}
}