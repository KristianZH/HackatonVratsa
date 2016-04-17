import java.awt.Color;
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

	private JButton btnTest;
	private JButton btnTest2;
	private JButton btnTest3;
	private JLabel label;
	private int move = 2;
	private int clicks = 0;
	public static int points = 0;
	public static int life;
	private Random rand = new Random();
	private JLabel lblNewLabel;
	private JLabel lblHealth2;
	private JLabel lblHealth;
	private JLabel lblScore;
	private JButton lblTest = new JButton();
	private JButton lblTest2 = new JButton();
	private JButton lblTest3 = new JButton();
	private JButton lblTest4 = new JButton();
	private JButton lblTest5 = new JButton();
	private JButton lblTest6 = new JButton();
	private JButton lblTest7 = new JButton();
	private JButton lblTest8 = new JButton();
	private JButton lblTest9 = new JButton();
	private JButton lblTest10 = new JButton();
	private JButton[] filledHoles = { lblTest, lblTest2, lblTest3, lblTest4,
			lblTest5, lblTest6, lblTest7, lblTest8, lblTest9, lblTest10};
	private boolean[] available = { true, true, true, true, true, true, true, true, true, true};
//	 private JButton btnTree1;
//	 private JButton btnTree2;
//	 private JButton btnTree3;
	public static JButton btnCar;

	public TestUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setSize(900, 700);
		this.setLocationRelativeTo(null);

		life = 50 + Shop.life;

		label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(781, 43, 63, 35);
		getContentPane().add(label);
		
		declareFilledHoles();

		btnTest = new JButton();
		ImageIcon test = new ImageIcon("pictures\\newHole.png");
		btnTest.setIcon(test);
		btnTest.setBounds(275, 68, 100, 100);
		setTransparent(btnTest);
		// makeNewDirection(btnTest);
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 10; i++) {
					if (available[i]) {
						filledHoles[i].setBounds(btnTest.getBounds());
						filledHoles[i].setVisible(true);
						available[i] = false;
						break;
					}
				}
				btnTest.setBounds(rand.nextInt(457) + 124, 11,
						btnTest.getWidth(), btnTest.getHeight());
				makeNewDirection(btnTest, btnTest2, btnTest3);
				clicks++;
				label.setText(String.valueOf(clicks));
				// getContentPane().remove(btnTest);

			}
		});
		btnTest3 = new JButton();
		ImageIcon test3 = new ImageIcon("pictures\\newHole.png");
		btnTest3.setIcon(test3);
		btnTest3.setBounds(155, 215, 100, 100);
		setTransparent(btnTest3);
		makeNewDirection(btnTest3, btnTest);
		btnTest3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 10; i++) {
					if (available[i]) {
						filledHoles[i].setBounds(btnTest3.getBounds());
						filledHoles[i].setVisible(true);
						available[i] = false;
						break;
					}
				}
				btnTest3.setBounds(rand.nextInt(457) + 124, 11,
						btnTest3.getWidth(), btnTest3.getHeight());
				makeNewDirection(btnTest3, btnTest, btnTest2);
				clicks++;
				label.setText(String.valueOf(clicks));
				// getContentPane().remove(btnTest);
			}
		});
		btnTest2 = new JButton();
		btnTest2.setBounds(513, 0, 100, 100);
		ImageIcon test2 = new ImageIcon("pictures\\newHole.png");
		setTransparent(btnTest2);
		btnTest2.setIcon(test2);
		makeNewDirection(btnTest2, btnTest, btnTest3);
		btnTest2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 10; i++) {
					if (available[i]) {
						filledHoles[i].setBounds(btnTest2.getBounds());
						filledHoles[i].setVisible(true);
						available[i] = false;
						break;
					}
				}
				btnTest2.setBounds(rand.nextInt(457) + 124, 11,
						btnTest2.getWidth(), btnTest2.getHeight());
				makeNewDirection(btnTest2, btnTest, btnTest3);
				clicks++;
				label.setText(String.valueOf(clicks));
				// getContentPane().remove(btnTest);
			}
		});

		getContentPane().add(btnTest2);
		getContentPane().add(btnTest3);
		getContentPane().add(btnTest);

		getContentPane().add(lblTest);
		getContentPane().add(lblTest2);
		getContentPane().add(lblTest3);
		getContentPane().add(lblTest4);
		getContentPane().add(lblTest5);
		getContentPane().add(lblTest6);
		getContentPane().add(lblTest7);

		lblScore = new JLabel("Score : ");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblScore.setBounds(681, 43, 90, 32);
		getContentPane().add(lblScore);

		btnCar = new JButton("");
		setTransparent(btnCar);
		btnCar.setBounds(220, 446, 367, 215);
		setCarIcon();
		getContentPane().add(btnCar);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(124, 0, 547, 661);
		getContentPane().add(lblNewLabel);

		lblNewLabel.setIcon(new ImageIcon("pictures\\realRoad.png"));

		lblHealth2 = new JLabel("Health: ");
		lblHealth2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHealth2.setBounds(681, 90, 90, 32);
		getContentPane().add(lblHealth2);

		lblHealth = new JLabel(String.valueOf(life));
		lblHealth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHealth.setBounds(781, 89, 63, 35);
		getContentPane().add(lblHealth);

//		 btnTree1 = new JButton("New button");
//		 btnTree1.setBounds(692, 63, 139, 105);
//		 btnTree1.setIcon(new ImageIcon("pictures\\tree1.png"));
//		 btnTree1.setOpaque(false);
//		 btnTree1.setContentAreaFilled(false);
//		 btnTree1.setBorderPainted(false);
//		 getContentPane().add(btnTree1);
//		
//		 btnTree2 = new JButton("New button");
//		 btnTree2.setBounds(692, 245, 139, 105);
//		 btnTree2.setIcon(new ImageIcon("pictures\\tree.png"));
//		 btnTree2.setOpaque(false);
//		 btnTree2.setContentAreaFilled(false);
//		 btnTree2.setBorderPainted(false);
//		 getContentPane().add(btnTree2);
//		
//		
//		 btnTree3 = new JButton("New button");
//		 btnTree3.setBounds(692, 430, 139, 105);
//		 btnTree3.setIcon(new ImageIcon("pictures\\tree1.png"));
//		 btnTree3.setOpaque(false);
//		 btnTree3.setContentAreaFilled(false);
//		 btnTree3.setBorderPainted(false);
//		 getContentPane().add(btnTree3);

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
				Rectangle r = btnTest.getBounds();
				Rectangle r2 = btnTest2.getBounds();
				Rectangle r3 = btnTest3.getBounds();

				Rectangle l = lblTest.getBounds();
				Rectangle l2 = lblTest2.getBounds();
				Rectangle l3 = lblTest3.getBounds();
				Rectangle l4 = lblTest4.getBounds();
				Rectangle l5 = lblTest5.getBounds();
				Rectangle l6 = lblTest6.getBounds();
				Rectangle l7 = lblTest7.getBounds();
				Rectangle l8 = lblTest8.getBounds();
				Rectangle l9 = lblTest9.getBounds();
				Rectangle l10 = lblTest10.getBounds();

//				 Rectangle t1 = btnTree1.getBounds();
//				 Rectangle t2 = btnTree2.getBounds();
//				 Rectangle t3 = btnTree3.getBounds();

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

//				 t1.setLocation((int) t1.getX(), (int) t1.getY() + move);
//				 t2.setLocation((int) t2.getX(), (int) t2.getY() + move);
//				 t3.setLocation((int) t3.getX(), (int) t3.getY() + move);

				btnTest.setBounds(r);
				btnTest2.setBounds(r2);
				btnTest3.setBounds(r3);

				lblTest.setBounds(l);
				lblTest2.setBounds(l2);
				lblTest3.setBounds(l3);
				lblTest4.setBounds(l4);
				lblTest5.setBounds(l5);
				lblTest6.setBounds(l6);
				lblTest7.setBounds(l7);
				lblTest8.setBounds(l8);
				lblTest9.setBounds(l9);
				lblTest10.setBounds(l10);

//				 btnTree1.setBounds(t1);
//				 btnTree2.setBounds(t2);
//				 btnTree3.setBounds(t3);

				for (int i = 0; i < 10; i++) {
					if (filledHoles[i].getBounds().intersects(
							btnCar.getBounds())) {
						filledHoles[i].setVisible(false);
						available[i] = true;
					}

				}

//				 if (btnTree1.getBounds().getY() ==
//				 btnCar.getBounds().getY()){
//				 btnTree1.setBounds(692, 11, btnTree1.getWidth(),
//				 btnTree1.getHeight());
//				 }
//				 if(btnTree2.getBounds().getY() ==
//				 btnCar.getBounds().getY()){
//				 btnTree2.setBounds(692, 11, btnTree2.getWidth(),
//				 btnTree2.getHeight());
//				 }
//				
//				 if(btnTree3.getBounds().getY() ==
//				 btnCar.getBounds().getY()){
//				 btnTree3.setBounds(692, 11, btnTree3.getWidth(),
//				 btnTree3.getHeight());
//				 }

				if (btnTest.getBounds().intersects(btnCar.getBounds())) {
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
						btnCar.getBounds())) {
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
						btnCar.getBounds())) {
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
				btnCar.setText(String.valueOf(life));
				if (life <= 0) {
					points += clicks;
					MainMenu.saveData();

					// System.exit(0);
					GameOverFrame frameOver = new GameOverFrame();
					frameOver.setVisible(true);
					JOptionPane gameOver = new JOptionPane();
					gameOver.setLocation(10, 10);
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
