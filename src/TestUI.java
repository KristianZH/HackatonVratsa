import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TestUI extends JFrame {

	private JButton btnTest;
	private JButton btnTest2;
	private JButton btnTest3;
	private JLabel label;
	private int move = 2;
	private int clicks = 0;
	public static int points = 0;
	public static JButton btnNewButton_9;
	public static int life;
	private Random rand = new Random();
	private JLabel lblNewLabel;
	private JLabel lblHealth2;
	private JLabel lblHealth;

	public TestUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setSize(900, 700);
		this.setLocationRelativeTo(null);
		
		life = 50 + Shop.life;

		label = new JLabel("0");
		label.setBounds(68, 423, 46, 14);
		getContentPane().add(label);

		btnTest = new JButton("1");
		ImageIcon test = new ImageIcon("pictures\\newHole.png");
		btnTest.setIcon(test);
		btnTest.setBounds(275, 68, 100, 100);
		btnTest.setOpaque(false);
		btnTest.setContentAreaFilled(false);
		btnTest.setBorderPainted(false);
		// makeNewDirection(btnTest);
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTest.setBounds(rand.nextInt(457) + 124, 11,
						btnTest.getWidth(), btnTest.getHeight());
				while (btnTest.getBounds().intersects(btnTest2.getBounds())
						|| btnTest.getBounds().intersects(btnTest3.getBounds())) {
					btnTest.setBounds(rand.nextInt(457) + 124, 11,
							btnTest.getWidth(), btnTest.getHeight());
				}
				// makeNewDirection(btnTest, btnTest2, btnTest3);
				clicks++;
				label.setText(String.valueOf(clicks));
				// getContentPane().remove(btnTest);

			}
		});
		btnTest3 = new JButton("3");
		ImageIcon test3 = new ImageIcon("pictures\\newHole.png");
		btnTest3.setIcon(test3);
		btnTest3.setBounds(155, 215, 100, 100);
		btnTest3.setOpaque(false);
		btnTest3.setContentAreaFilled(false);
		btnTest3.setBorderPainted(false);
		while (btnTest3.getBounds().intersects(btnTest.getBounds())) {
			btnTest3.setBounds(rand.nextInt(457) + 124, 11,
					btnTest3.getWidth(), btnTest3.getHeight());
		}
		// makeNewDirection(btnTest3, btnTest);
		btnTest3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTest3.setBounds(rand.nextInt(457) + 124, 11,
						btnTest3.getWidth(), btnTest3.getHeight());
				while (btnTest3.getBounds().intersects(btnTest2.getBounds())
						|| btnTest3.getBounds().intersects(btnTest.getBounds())) {
					btnTest3.setBounds(rand.nextInt(457) + 124, 11,
							btnTest3.getWidth(), btnTest3.getHeight());
				}
				// makeNewDirection(btnTest3, btnTest, btnTest2);
				clicks++;
				label.setText(String.valueOf(clicks));
				// getContentPane().remove(btnTest);
			}
		});
		btnTest2 = new JButton("2");
		btnTest2.setBounds(513, 0, 100, 100);
		btnTest2.setOpaque(false);
		ImageIcon test2 = new ImageIcon("pictures\\newHole.png");
		btnTest2.setIcon(test2);
		btnTest2.setContentAreaFilled(false);
		btnTest2.setBorderPainted(false);
		while (btnTest2.getBounds().intersects(btnTest3.getBounds())
				|| btnTest2.getBounds().intersects(btnTest.getBounds())) {
			btnTest2.setBounds(rand.nextInt(457) + 124, 11,
					btnTest2.getWidth(), btnTest2.getHeight());
		}
		// makeNewDirection(btnTest2, btnTest, btnTest3);
		btnTest2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTest2.setBounds(rand.nextInt(457) + 124, 11,
						btnTest2.getWidth(), btnTest2.getHeight());
				while (btnTest2.getBounds().intersects(btnTest3.getBounds())
						|| btnTest2.getBounds().intersects(btnTest.getBounds())) {
					btnTest2.setBounds(rand.nextInt(457) + 124, 11,
							btnTest2.getWidth(), btnTest2.getHeight());
				}
				// makeNewDirection(btnTest2, btnTest, btnTest3);
				clicks++;
				label.setText(String.valueOf(clicks));
				// getContentPane().remove(btnTest);
			}
		});
		getContentPane().add(btnTest2);
		getContentPane().add(btnTest3);
		getContentPane().add(btnTest);

		JLabel lblScore = new JLabel("Score : ");
		lblScore.setBounds(21, 423, 37, 14);
		getContentPane().add(lblScore);

		btnNewButton_9 = new JButton("");
		btnNewButton_9.setOpaque(false);
		btnNewButton_9.setContentAreaFilled(false);
		btnNewButton_9.setBorderPainted(false);
		btnNewButton_9.setBounds(220, 446, 367, 215);
		switch (Shop.flag1){
		case 0:
			btnNewButton_9.setIcon(new ImageIcon("pictures\\old car.png")); break;
		case 1:
			btnNewButton_9.setIcon(new ImageIcon("pictures\\lamboPlay.png")); break;
		case 2:
			btnNewButton_9.setIcon(new ImageIcon("pictures\\lambo2Play.png")); break;
		case 3:
			btnNewButton_9.setIcon(new ImageIcon("pictures\\mercPlay.png")); break;
		case 4:
			btnNewButton_9.setIcon(new ImageIcon("pictures\\viperPlay.png")); break;
		default:
			break;
		}
		getContentPane().add(btnNewButton_9);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(124, 0, 547, 661);
		getContentPane().add(lblNewLabel);

		lblNewLabel.setIcon(new ImageIcon("pictures\\realRoad.png"));
		
		lblHealth2 = new JLabel("Health: ");
		lblHealth2.setBounds(12, 474, 46, 14);
		getContentPane().add(lblHealth2);
		
		lblHealth = new JLabel(String.valueOf(life));
		lblHealth.setBounds(68, 474, 46, 14);
		getContentPane().add(lblHealth);

		this.setVisible(false);

	}

	private void makeNewDirection(JButton btn, JButton... buttons) {
		boolean flag = true;
		while (flag) {
			flag = false;
			btn.setBounds(rand.nextInt(457) + 124, 11, btn.getWidth(),
					btn.getHeight());
			for (JButton b : buttons) {
				if (btn.getBounds().intersects(b.getBounds())) {
					flag = true;
				}
			}
		}
	}

	public void play() {

		Timer movingHoles = new Timer();
		movingHoles.schedule(new TimerTask() {
			@Override
			public void run() {
				Rectangle r = btnTest.getBounds();
				Rectangle r2 = btnTest2.getBounds();
				Rectangle r3 = btnTest3.getBounds();
				r.setLocation((int) r.getX(), (int) r.getY() + move);
				r2.setLocation((int) r2.getX(), (int) r2.getY() + move);
				r3.setLocation((int) r3.getX(), (int) r3.getY() + move);
				btnTest.setBounds(r);
				btnTest2.setBounds(r2);
				btnTest3.setBounds(r3);
				if (btnTest.getBounds().intersects(btnNewButton_9.getBounds())) {
					life -= 10;
					lblHealth.setText(String.valueOf(life));
					btnTest.setBounds(rand.nextInt(457) + 124, 11,
							btnTest.getWidth(), btnTest.getHeight());
					while (btnTest.getBounds().intersects(btnTest2.getBounds())
							|| btnTest.getBounds().intersects(
									btnTest3.getBounds())) {
						btnTest.setBounds(rand.nextInt(457) + 124, 11,
								btnTest.getWidth(), btnTest.getHeight());
					}
				} else if (btnTest2.getBounds().intersects(
						btnNewButton_9.getBounds())) {
					life -= 10;
					lblHealth.setText(String.valueOf(life));
					btnTest2.setBounds(rand.nextInt(457) + 124, 11,
							btnTest2.getWidth(), btnTest2.getHeight());
					while (btnTest2.getBounds()
							.intersects(btnTest3.getBounds())
							|| btnTest2.getBounds().intersects(
									btnTest.getBounds())) {
						btnTest2.setBounds(rand.nextInt(457) + 124, 11,
								btnTest2.getWidth(), btnTest2.getHeight());
					}
				} else if (btnTest3.getBounds().intersects(
						btnNewButton_9.getBounds())) {
					life -= 10;
					lblHealth.setText(String.valueOf(life));
					btnTest3.setBounds(rand.nextInt(457) + 124, 11,
							btnTest3.getWidth(), btnTest3.getHeight());
					while (btnTest3.getBounds()
							.intersects(btnTest2.getBounds())
							|| btnTest3.getBounds().intersects(
									btnTest.getBounds())) {
						btnTest3.setBounds(rand.nextInt(457) + 124, 11,
								btnTest3.getWidth(), btnTest3.getHeight());
					}
				}
				btnNewButton_9.setText(String.valueOf(life));
				if (life <= 0) {
					points += clicks;
					MainMenu.saveData();
//					JOptionPane.showMessageDialog(getContentPane(),
//							"Game Over!");
					ImageIcon icon = new ImageIcon("pictures\\tito.jpg");
					    JOptionPane.showMessageDialog(null,icon);
					// System.exit(0);
					this.cancel();
					setVisible(false);
					Test.main(null);
				}
			}
		}, 1000, 30);

		Timer increaseSpeed = new Timer();
		increaseSpeed.schedule(new TimerTask() {
			@Override
			public void run() {
				move++;
			}
		}, 1000, 10000);

	}
}
