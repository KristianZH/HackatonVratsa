import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestUI extends JFrame {

	JButton btnNewButton;
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	JButton btnNewButton_3;
	JButton btnNewButton_4;
	JButton btnNewButton_5;
	JButton btnNewButton_6;
	JButton btnNewButton_7;
	JButton btnNewButton_8;

	public TestUI() {
		getContentPane().setLayout(null);
		this.setSize(500, 500);

		btnNewButton = new JButton("0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setText("0");
			}
		});
		btnNewButton.setBounds(32, 91, 89, 23);
		getContentPane().add(btnNewButton);

		btnNewButton_1 = new JButton("0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1.setText("0");
			}
		});
		btnNewButton_1.setBounds(177, 91, 89, 23);
		getContentPane().add(btnNewButton_1);

		btnNewButton_2 = new JButton("0");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_2.setText("0");
			}
		});
		btnNewButton_2.setBounds(316, 91, 89, 23);
		getContentPane().add(btnNewButton_2);

		btnNewButton_3 = new JButton("0");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_3.setText("0");
			}
		});
		btnNewButton_3.setBounds(32, 142, 89, 23);
		getContentPane().add(btnNewButton_3);

		btnNewButton_4 = new JButton("0");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_4.setText("0");
			}
		});
		btnNewButton_4.setBounds(177, 142, 89, 23);
		getContentPane().add(btnNewButton_4);

		btnNewButton_5 = new JButton("0");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_5.setText("0");
			}
		});
		btnNewButton_5.setBounds(316, 142, 89, 23);
		getContentPane().add(btnNewButton_5);

		btnNewButton_6 = new JButton("0");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNewButton_6.setText("0");
			}
		});
		btnNewButton_6.setBounds(32, 189, 89, 23);
		getContentPane().add(btnNewButton_6);

		btnNewButton_7 = new JButton("0");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_7.setText("0");
			}
		});
		btnNewButton_7.setBounds(177, 189, 89, 23);
		getContentPane().add(btnNewButton_7);

		btnNewButton_8 = new JButton("0");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_8.setText("0");
			}
		});
		btnNewButton_8.setBounds(316, 189, 89, 23);
		getContentPane().add(btnNewButton_8);
		getContentPane().setVisible(true);
	}

	public void play() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				int a = new Random().nextInt(9);
				getButton(a).setText("1");
			}
		}, 2000, 2000);
	}

	private JButton getButton(int a) {
		switch (a) {
		case 0:
			return btnNewButton;
		case 1:
			return btnNewButton_1;
		case 2:
			return btnNewButton_2;
		case 3:
			return btnNewButton_3;
		case 4:
			return btnNewButton_4;
		case 5:
			return btnNewButton_5;
		case 6:
			return btnNewButton_6;
		case 7:
			return btnNewButton_7;
		case 8:
			return btnNewButton_8;
		default:
			return btnNewButton;
		}
	}
}
