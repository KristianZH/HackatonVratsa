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

import java.awt.Font;

public class TestUI extends JFrame {

	private JButton btnHole1;
	private JButton btnHole2;
	private JButton btnHole3;
	private JLabel labelPoint;
	private int move = 2;
	private int clicks = 0;
	public static int points = 0;
	public static int life;
	private Random rand = new Random();
	private JLabel road;
	private JLabel lblHealth2;
	private JLabel lblHealth;
	private JLabel lblScore;
	private JButton btnFilledHole1 = new JButton();
	private JButton btnFilledHole2 = new JButton();
	private JButton btnFilledHole3 = new JButton();
	private JButton btnFilledHole4 = new JButton();
	private JButton btnFilledHole5 = new JButton();
	private JButton btnFilledHole6 = new JButton();
	private JButton btnFilledHole7 = new JButton();
	private JButton btnFilledHole8 = new JButton();
	private JButton btnFilledHole9 = new JButton();
	private JButton btnFilledHole10 = new JButton();
	private JButton[] filledHoles = { btnFilledHole1, btnFilledHole2, btnFilledHole3, btnFilledHole4,
			btnFilledHole5, btnFilledHole6, btnFilledHole7, btnFilledHole8, btnFilledHole9, btnFilledHole10};
	private boolean[] available = { true, true, true, true, true, true, true, true, true, true};
	public static JButton btnCar;

	public TestUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setSize(900, 700);
		this.setLocationRelativeTo(null);

		life = 50 + Shop.life;

		labelPoint = new JLabel("0");
		labelPoint.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelPoint.setBounds(781, 43, 63, 35);
		getContentPane().add(labelPoint);
		
		declareFilledHoles();

		btnHole1 = new JButton();
		ImageIcon test = new ImageIcon("pictures\\newHole.png");
		btnHole1.setIcon(test);
		btnHole1.setBounds(275, 68, 100, 100);
		setTransparent(btnHole1);
		btnHole1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 10; i++) {
					if (available[i]) {
						filledHoles[i].setBounds(btnHole1.getBounds());
						filledHoles[i].setVisible(true);
						available[i] = false;
						break;
					}
				}
				btnHole1.setBounds(rand.nextInt(457) + 124, 11,
						btnHole1.getWidth(), btnHole1.getHeight());
				makeNewDirection(btnHole1, btnHole2, btnHole3);
				clicks++;
				labelPoint.setText(String.valueOf(clicks));
			}
		});
		
		btnHole2 = new JButton();
		btnHole2.setBounds(513, 0, 100, 100);
		ImageIcon test2 = new ImageIcon("pictures\\newHole.png");
		setTransparent(btnHole2);
		btnHole2.setIcon(test2);
		makeNewDirection(btnHole2, btnHole1);
		btnHole2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 10; i++) {
					if (available[i]) {
						filledHoles[i].setBounds(btnHole2.getBounds());
						filledHoles[i].setVisible(true);
						available[i] = false;
						break;
					}
				}
				btnHole2.setBounds(rand.nextInt(457) + 124, 11,
						btnHole2.getWidth(), btnHole2.getHeight());
				makeNewDirection(btnHole2, btnHole1, btnHole3);
				clicks++;
				labelPoint.setText(String.valueOf(clicks));
			}
		});
		
		btnHole3 = new JButton();
		ImageIcon test3 = new ImageIcon("pictures\\newHole.png");
		btnHole3.setIcon(test3);
		btnHole3.setBounds(155, 215, 100, 100);
		setTransparent(btnHole3);
		makeNewDirection(btnHole3, btnHole1, btnHole2);
		btnHole3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 10; i++) {
					if (available[i]) {
						filledHoles[i].setBounds(btnHole3.getBounds());
						filledHoles[i].setVisible(true);
						available[i] = false;
						break;
					}
				}
				btnHole3.setBounds(rand.nextInt(457) + 124, 11,
						btnHole3.getWidth(), btnHole3.getHeight());
				makeNewDirection(btnHole3, btnHole1, btnHole2);
				clicks++;
				labelPoint.setText(String.valueOf(clicks));
			}
		});

		getContentPane().add(btnHole2);
		getContentPane().add(btnHole3);
		getContentPane().add(btnHole1);

		getContentPane().add(btnFilledHole1);
		getContentPane().add(btnFilledHole2);
		getContentPane().add(btnFilledHole3);
		getContentPane().add(btnFilledHole4);
		getContentPane().add(btnFilledHole5);
		getContentPane().add(btnFilledHole6);
		getContentPane().add(btnFilledHole7);

		lblScore = new JLabel("Score : ");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblScore.setBounds(681, 43, 90, 32);
		getContentPane().add(lblScore);

		btnCar = new JButton("");
		setTransparent(btnCar);
		btnCar.setBounds(220, 446, 367, 215);
		setCarIcon();
		getContentPane().add(btnCar);

		road = new JLabel("New label");
		road.setBounds(124, 0, 547, 661);
		getContentPane().add(road);

		road.setIcon(new ImageIcon("pictures\\realRoad.png"));

		lblHealth2 = new JLabel("Health: ");
		lblHealth2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHealth2.setBounds(681, 90, 90, 32);
		getContentPane().add(lblHealth2);

		lblHealth = new JLabel(String.valueOf(life));
		lblHealth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHealth.setBounds(781, 89, 63, 35);
		getContentPane().add(lblHealth);

		this.setVisible(false);

	}
	
	private void setTransparent(JButton  btn){
		btn.setOpaque(false);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
	}

	private void declareFilledHoles() {
		for(int i = 0; i < 10; i++){
			filledHoles[i].setIcon(new ImageIcon("pictures\\fillerDone.png"));
			setTransparent(filledHoles[i]);
		}
	}

	private void setCarIcon() {
		switch (Shop.flag1) {
		case 0:
			btnCar.setIcon(new ImageIcon("pictures\\old car.png"));
			break;
		case 1:
			btnCar.setIcon(new ImageIcon("pictures\\lamboPlay.png"));
			break;
		case 2:
			btnCar.setIcon(new ImageIcon("pictures\\lambo2Play.png"));
			break;
		case 3:
			btnCar.setIcon(new ImageIcon("pictures\\mercPlay.png"));
			break;
		case 4:
			btnCar.setIcon(new ImageIcon("pictures\\viperPlay.png"));
			break;
		default:
			break;
		}
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
				Rectangle r = btnHole1.getBounds();
				Rectangle r2 = btnHole2.getBounds();
				Rectangle r3 = btnHole3.getBounds();

				Rectangle l = btnFilledHole1.getBounds();
				Rectangle l2 = btnFilledHole2.getBounds();
				Rectangle l3 = btnFilledHole3.getBounds();
				Rectangle l4 = btnFilledHole4.getBounds();
				Rectangle l5 = btnFilledHole5.getBounds();
				Rectangle l6 = btnFilledHole6.getBounds();
				Rectangle l7 = btnFilledHole7.getBounds();
				Rectangle l8 = btnFilledHole8.getBounds();
				Rectangle l9 = btnFilledHole9.getBounds();
				Rectangle l10 = btnFilledHole10.getBounds();

				r.setLocation((int) r.getX(), (int) r.getY() + move);
				r2.setLocation((int) r2.getX(), (int) r2.getY() + move);
				r3.setLocation((int) r3.getX(), (int) r3.getY() + move);

				l.setLocation((int) l.getX(), (int) l.getY() + move);
				l2.setLocation((int) l2.getX(), (int) l2.getY() + move);
				l3.setLocation((int) l3.getX(), (int) l3.getY() + move);
				l4.setLocation((int) l4.getX(), (int) l4.getY() + move);
				l5.setLocation((int) l5.getX(), (int) l5.getY() + move);
				l6.setLocation((int) l6.getX(), (int) l6.getY() + move);
				l7.setLocation((int) l7.getX(), (int) l7.getY() + move);
				l8.setLocation((int) l8.getX(), (int) l8.getY() + move);
				l9.setLocation((int) l9.getX(), (int) l9.getY() + move);
				l10.setLocation((int) l10.getX(), (int) l10.getY() + move);

				btnHole1.setBounds(r);
				btnHole2.setBounds(r2);
				btnHole3.setBounds(r3);

				btnFilledHole1.setBounds(l);
				btnFilledHole2.setBounds(l2);
				btnFilledHole3.setBounds(l3);
				btnFilledHole4.setBounds(l4);
				btnFilledHole5.setBounds(l5);
				btnFilledHole6.setBounds(l6);
				btnFilledHole7.setBounds(l7);
				btnFilledHole8.setBounds(l8);
				btnFilledHole9.setBounds(l9);
				btnFilledHole10.setBounds(l10);

				for (int i = 0; i < 10; i++) {
					if (filledHoles[i].getBounds().intersects(
							btnCar.getBounds())) {
						filledHoles[i].setVisible(false);
						available[i] = true;
					}

				}

				if (btnHole1.getBounds().intersects(btnCar.getBounds())) {
					life -= 10;
					lblHealth.setText(String.valueOf(life));
					btnHole1.setBounds(rand.nextInt(457) + 124, 11,
							btnHole1.getWidth(), btnHole1.getHeight());
					while (btnHole1.getBounds().intersects(btnHole2.getBounds())
							|| btnHole1.getBounds().intersects(
									btnHole3.getBounds())) {
						btnHole1.setBounds(rand.nextInt(457) + 124, 11,
								btnHole1.getWidth(), btnHole1.getHeight());
					}
				} else if (btnHole2.getBounds().intersects(
						btnCar.getBounds())) {
					life -= 10;
					lblHealth.setText(String.valueOf(life));
					btnHole2.setBounds(rand.nextInt(457) + 124, 11,
							btnHole2.getWidth(), btnHole2.getHeight());
					while (btnHole2.getBounds()
							.intersects(btnHole3.getBounds())
							|| btnHole2.getBounds().intersects(
									btnHole1.getBounds())) {
						btnHole2.setBounds(rand.nextInt(457) + 124, 11,
								btnHole2.getWidth(), btnHole2.getHeight());
					}
				} else if (btnHole3.getBounds().intersects(
						btnCar.getBounds())) {
					life -= 10;
					lblHealth.setText(String.valueOf(life));
					btnHole3.setBounds(rand.nextInt(457) + 124, 11,
							btnHole3.getWidth(), btnHole3.getHeight());
					while (btnHole3.getBounds()
							.intersects(btnHole2.getBounds())
							|| btnHole3.getBounds().intersects(
									btnHole1.getBounds())) {
						btnHole3.setBounds(rand.nextInt(457) + 124, 11,
								btnHole3.getWidth(), btnHole3.getHeight());
					}
				}
				btnCar.setText(String.valueOf(life));
				if (life <= 0) {
					points += clicks;
					MainMenu.saveData();

					GameOverFrame frameOver = new GameOverFrame();
					frameOver.setVisible(true);
					frameOver.setLocation(200, 300);
					JOptionPane.showMessageDialog(null, "Game Over");
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
