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

public class PlayGame extends JFrame {

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
	private JButton[] emptyHoles = new JButton[3];
	private JButton[] filledHoles = new JButton[10];
	private Rectangle[] holesRectangle = new Rectangle[10];
	private boolean[] available = { true, true, true, true, true, true, true,
			true, true, true };
	public static JButton btnCar;

	public PlayGame() {
		init();

	}

	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setSize(900, 700);
		this.setLocationRelativeTo(null);

		life = 50 + Shop.life;

		labelPoint = new JLabel("0");
		labelPoint.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelPoint.setBounds(781, 43, 63, 35);
		getContentPane().add(labelPoint);

		initFilledHoles();
		declareFilledHoles();

		initEmptyHoles();

		emptyHoles[0].setBounds(275, 68, 100, 100);
		emptyHoles[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isAvailable(emptyHoles[0]);
				emptyHoles[0].setBounds(rand.nextInt(457) + 124, 11,
						emptyHoles[0].getWidth(), emptyHoles[0].getHeight());
				makeNewDirection(emptyHoles[0], emptyHoles[1], emptyHoles[2]);
				clicks++;
				labelPoint.setText(String.valueOf(clicks));
			}
		});

		emptyHoles[1].setBounds(513, 0, 100, 100);
		makeNewDirection(emptyHoles[1], emptyHoles[0]);
		emptyHoles[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isAvailable(emptyHoles[1]);
				emptyHoles[1].setBounds(rand.nextInt(457) + 124, 11,
						emptyHoles[1].getWidth(), emptyHoles[1].getHeight());
				makeNewDirection(emptyHoles[1], emptyHoles[0], emptyHoles[2]);
				clicks++;
				labelPoint.setText(String.valueOf(clicks));
			}
		});

		emptyHoles[2].setBounds(155, 215, 100, 100);
		makeNewDirection(emptyHoles[2], emptyHoles[0], emptyHoles[1]);
		emptyHoles[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isAvailable(emptyHoles[2]);
				emptyHoles[2].setBounds(rand.nextInt(457) + 124, 11,
						emptyHoles[2].getWidth(), emptyHoles[2].getHeight());
				makeNewDirection(emptyHoles[2], emptyHoles[0], emptyHoles[1]);
				clicks++;
				labelPoint.setText(String.valueOf(clicks));
			}
		});

		for (int i = 0; i < 3; i++) {
			getContentPane().add(emptyHoles[i]);
		}

		addHoles();

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

	private void initEmptyHoles() {
		for (int i = 0; i < 3; i++) {
			emptyHoles[i] = new JButton();
			emptyHoles[i].setIcon(new ImageIcon("pictures\\newHole.png"));
			setTransparent(emptyHoles[i]);
		}
	}

	private void isAvailable(JButton btn) {
		for (int i = 0; i < 10; i++) {
			if (available[i]) {
				filledHoles[i].setBounds(btn.getBounds());
				filledHoles[i].setVisible(true);
				available[i] = false;
				break;
			}
		}
	}

	private void addHoles() {
		for (int i = 0; i < 10; i++) {
			getContentPane().add(filledHoles[i]);
		}
	}

	private void initFilledHoles() {
		for (int i = 0; i < 10; i++) {
			filledHoles[i] = new JButton();
		}
	}

	private void setTransparent(JButton btn) {
		btn.setOpaque(false);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
	}

	private void declareFilledHoles() {
		for (int i = 0; i < 10; i++) {
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
				Rectangle r = emptyHoles[0].getBounds();
				Rectangle r2 = emptyHoles[1].getBounds();
				Rectangle r3 = emptyHoles[2].getBounds();

				moveHole();

				r.setLocation((int) r.getX(), (int) r.getY() + move);
				r2.setLocation((int) r2.getX(), (int) r2.getY() + move);
				r3.setLocation((int) r3.getX(), (int) r3.getY() + move);

				emptyHoles[0].setBounds(r);
				emptyHoles[1].setBounds(r2);
				emptyHoles[2].setBounds(r3);

				for (int i = 0; i < 10; i++) {
					filledHoles[i].setBounds(holesRectangle[i]);
				}

				for (int i = 0; i < 10; i++) {
					if (filledHoles[i].getBounds().intersects(
							btnCar.getBounds())) {
						filledHoles[i].setVisible(false);
						available[i] = true;
					}

				}

				if (emptyHoles[0].getBounds().intersects(btnCar.getBounds())) {
					life -= 10;
					lblHealth.setText(String.valueOf(life));
					makeNewDirection(emptyHoles[0], emptyHoles[1],
							emptyHoles[2]);
				} else if (emptyHoles[1].getBounds().intersects(
						btnCar.getBounds())) {
					life -= 10;
					lblHealth.setText(String.valueOf(life));
					makeNewDirection(emptyHoles[1], emptyHoles[0],
							emptyHoles[2]);
				} else if (emptyHoles[2].getBounds().intersects(
						btnCar.getBounds())) {
					life -= 10;
					lblHealth.setText(String.valueOf(life));
					makeNewDirection(emptyHoles[2], emptyHoles[0],
							emptyHoles[1]);
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

					Main.main(null);
				}
			}

			private void moveHole() {
				for (int i = 0; i < 10; i++) {
					holesRectangle[i] = new Rectangle(filledHoles[i]
							.getBounds());
				}
				for (int i = 0; i < 10; i++) {
					holesRectangle[i].setLocation(
							(int) holesRectangle[i].getX(),
							(int) holesRectangle[i].getY() + move);
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
