import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TestUI extends JFrame {

	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	private JButton btnTest;
	private JButton btnTest2;
	private JButton btnTest3;
	private JLabel label;
	private ArrayList<JButton> holes = new ArrayList<JButton>();
	private int move = 2;
	private int clicks = 1;
	private JButton btnNewButton_9;
	private int life = 50;
	private Random rand = new Random();

	public TestUI() {
		getContentPane().setLayout(null);
		this.setSize(900, 700);
		this.setLocationRelativeTo(null);

//		btnNewButton = new JButton("0");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				btnNewButton.setText("0");
//			}
//		});
//		btnNewButton.setBounds(32, 91, 89, 23);
//		getContentPane().add(btnNewButton);
//
//		btnNewButton_1 = new JButton("0");
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				btnNewButton_1.setText("0");
//			}
//		});
//		btnNewButton_1.setBounds(177, 91, 89, 23);
//		getContentPane().add(btnNewButton_1);
//
//		btnNewButton_2 = new JButton("0");
//		btnNewButton_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				btnNewButton_2.setText("0");
//			}
//		});
//		btnNewButton_2.setBounds(316, 91, 89, 23);
//		getContentPane().add(btnNewButton_2);
//
//		btnNewButton_3 = new JButton("0");
//		btnNewButton_3.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				btnNewButton_3.setText("0");
//			}
//		});
//		btnNewButton_3.setBounds(32, 142, 89, 23);
//		getContentPane().add(btnNewButton_3);
//
//		btnNewButton_4 = new JButton("0");
//		btnNewButton_4.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				btnNewButton_4.setText("0");
//			}
//		});
//		btnNewButton_4.setBounds(177, 142, 89, 23);
//		getContentPane().add(btnNewButton_4);
//
//		btnNewButton_5 = new JButton("0");
//		btnNewButton_5.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				btnNewButton_5.setText("0");
//			}
//		});
//		btnNewButton_5.setBounds(316, 142, 89, 23);
//		getContentPane().add(btnNewButton_5);
//
//		btnNewButton_6 = new JButton("0");
//		btnNewButton_6.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				btnNewButton_6.setText("0");
//			}
//		});
//		btnNewButton_6.setBounds(32, 189, 89, 23);
//		getContentPane().add(btnNewButton_6);
//
//		btnNewButton_7 = new JButton("0");
//		btnNewButton_7.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				btnNewButton_7.setText("0");
//			}
//		});
//		btnNewButton_7.setBounds(177, 189, 89, 23);
//		getContentPane().add(btnNewButton_7);
//
//		btnNewButton_8 = new JButton("0");
//		btnNewButton_8.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				btnNewButton_8.setText("0");
//			}
//		});
//		btnNewButton_8.setBounds(316, 189, 89, 23);
//		getContentPane().add(btnNewButton_8);
		
		label = new JLabel("0");
		label.setBounds(68, 423, 46, 14);
		getContentPane().add(label);
		
		btnTest = new JButton("test");
		btnTest.setBounds(rand.nextInt(317) + 128, 11, 43, 39);
		//makeNewDirection(btnTest);
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTest.setBounds(rand.nextInt(317) + 128, 11, btnTest.getWidth(), btnTest.getHeight());
				while(btnTest.getBounds().intersects(btnTest2.getBounds()) || btnTest.getBounds().intersects(btnTest3.getBounds())){
					btnTest.setBounds(rand.nextInt(317) + 128, 11, btnTest.getWidth(), btnTest.getHeight());
				}
				//makeNewDirection(btnTest, btnTest2, btnTest3);
				clicks++;
				label.setText(String.valueOf(clicks));
				//getContentPane().remove(btnTest);
			}
		});
		btnTest3 = new JButton("test");
		btnTest3.setBounds(rand.nextInt(317) + 128, 11, 43, 39);
		while(btnTest3.getBounds().intersects(btnTest.getBounds())){
			btnTest3.setBounds(rand.nextInt(317) + 128, 11, btnTest3.getWidth(), btnTest3.getHeight());
		}
		//makeNewDirection(btnTest3, btnTest);
		btnTest3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTest3.setBounds(rand.nextInt(317) + 128, 11, btnTest3.getWidth(), btnTest3.getHeight());
				while(btnTest3.getBounds().intersects(btnTest2.getBounds()) || btnTest3.getBounds().intersects(btnTest.getBounds())){
					btnTest3.setBounds(rand.nextInt(317) + 128, 11, btnTest3.getWidth(), btnTest3.getHeight());
				}
				//makeNewDirection(btnTest3, btnTest, btnTest2);
				clicks++;
				label.setText(String.valueOf(clicks));
				//getContentPane().remove(btnTest);
			}
		});
		btnTest2 = new JButton("test");
		btnTest2.setBounds(rand.nextInt(317) + 128, 11, 43, 39);
		while(btnTest2.getBounds().intersects(btnTest3.getBounds()) || btnTest2.getBounds().intersects(btnTest.getBounds())){
			btnTest2.setBounds(rand.nextInt(317) + 128, 11, btnTest2.getWidth(), btnTest2.getHeight());
		}
		//makeNewDirection(btnTest2, btnTest, btnTest3);
		btnTest2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTest2.setBounds(rand.nextInt(317) + 128, 11, btnTest2.getWidth(), btnTest2.getHeight());
				while(btnTest2.getBounds().intersects(btnTest3.getBounds()) || btnTest2.getBounds().intersects(btnTest.getBounds())){
					btnTest2.setBounds(rand.nextInt(317) + 128, 11, btnTest2.getWidth(), btnTest2.getHeight());
				}
				//makeNewDirection(btnTest2, btnTest, btnTest3);
				clicks++;
				label.setText(String.valueOf(clicks));
				//getContentPane().remove(btnTest);
			}
		});
		getContentPane().add(btnTest2);
		getContentPane().add(btnTest3);
		getContentPane().add(btnTest);
		
		JLabel lblScore = new JLabel("Score : ");
		lblScore.setBounds(21, 423, 37, 14);
		getContentPane().add(lblScore);
		
		btnNewButton_9 = new JButton("50");
		btnNewButton_9.setBounds(128, 445, 543, 179);
		getContentPane().add(btnNewButton_9);
		this.setVisible(false);
		
		
	}
	
	private void makeNewDirection(JButton btn, JButton... buttons){
		boolean flag = true;
		while(flag){
			flag = false;
			btn.setBounds(new Random().nextInt(317) + 128, 11, btn.getWidth(), btn.getHeight());
			for(JButton b : buttons){
				if(btn.getBounds().intersects(b.getBounds())){
					flag = true;
				}
			}
			//btn.setBounds(new Random().nextInt(300) + 100, 11, btn.getWidth(), btn.getHeight());
		}
	}

	public void play() {
//		Timer timer = new Timer();
//		timer.schedule(new TimerTask() {
//			@Override
//			public void run() {
//				Random rand = new Random();
//				int a = rand.nextInt(9);
//				if(getButton(a).getText().equals("1")){
//					a = rand.nextInt(9);
//				}
//				getButton(a).setText("1");
//			}
//		}, 2000, 1000);
		
//		Timer generateHoles = new Timer();
//		generateHoles.schedule(new TimerTask(){
//			@Override
//			public void run(){
//				holes.add(new JButton());
//				getContentPane().add(holes.get(holes.size() - 1));
//				holes.get(holes.size() - 1).setLocation(new Random().nextInt(450), 11);
//				holes.get(holes.size() - 1).addActionListener(new ActionListener() {
//					
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						getContentPane().remove(btnTest);
//					}
//				});
//				Timer movingHoles = new Timer();
//				movingHoles.schedule(new TimerTask(){
//					@Override
//					public void run(){
//						Rectangle r = holes.get(holes.size() - 1).getBounds();
//						r.width = 43;
//						r.height = 39;
//						r.setLocation((int)r.getX(), (int)r.getY() + 2);
//						holes.get(holes.size() - 1).setBounds(r);
//					}
//				}, 1000, 10);
//				
//			}
//		}, 1000, 1000);
		
		Timer movingHoles = new Timer();
		movingHoles.schedule(new TimerTask(){
			@Override
			public void run(){
//				if(clicks % 10 == 0){
//					move++;
//					clicks = 1;
				
				//push
				//push2
//				}
				Rectangle r = btnTest.getBounds();
				Rectangle r2 = btnTest2.getBounds();
				Rectangle r3 = btnTest3.getBounds();
				r.setLocation((int)r.getX(), (int)r.getY() + move);
				r2.setLocation((int)r2.getX(), (int)r2.getY() + move);
				r3.setLocation((int)r3.getX(), (int)r3.getY() + move);
				btnTest.setBounds(r);
				btnTest2.setBounds(r2);
				btnTest3.setBounds(r3);
				if(btnTest.getBounds().intersects(btnNewButton_9.getBounds())){
					life -= 10;
					btnTest.setBounds(rand.nextInt(317) + 128, 11, btnTest.getWidth(), btnTest.getHeight());
					while(btnTest.getBounds().intersects(btnTest2.getBounds()) || btnTest.getBounds().intersects(btnTest3.getBounds())){
						btnTest.setBounds(rand.nextInt(317) + 128, 11, btnTest.getWidth(), btnTest.getHeight());
					}
				} else if(btnTest2.getBounds().intersects(btnNewButton_9.getBounds())){
					life -= 10;
					btnTest2.setBounds(rand.nextInt(317) + 128, 11, btnTest2.getWidth(), btnTest2.getHeight());
					while(btnTest2.getBounds().intersects(btnTest3.getBounds()) || btnTest2.getBounds().intersects(btnTest.getBounds())){
						btnTest2.setBounds(rand.nextInt(317) + 128, 11, btnTest2.getWidth(), btnTest2.getHeight());
					}
				} else if(btnTest3.getBounds().intersects(btnNewButton_9.getBounds())){
					life -= 10;
					btnTest3.setBounds(rand.nextInt(317) + 128, 11, btnTest3.getWidth(), btnTest3.getHeight());
					while(btnTest3.getBounds().intersects(btnTest2.getBounds()) || btnTest3.getBounds().intersects(btnTest.getBounds())){
						btnTest3.setBounds(rand.nextInt(317) + 128, 11, btnTest3.getWidth(), btnTest3.getHeight());
					}
				}
				btnNewButton_9.setText(String.valueOf(life));
				if(life <= 0){
					JOptionPane.showMessageDialog(getContentPane(), "Game Over!");
					//System.exit(0);
					this.cancel();
					setVisible(false);
					Test.main(null);
				}
			}
		}, 1000, 30);
		
		Timer increaseSpeed = new Timer();
		increaseSpeed.schedule(new TimerTask(){
			@Override
			public void run(){
				move++;
			}
		}, 1000, 10000);
		
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
