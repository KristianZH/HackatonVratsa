import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
	private int  clicks = 0;
	public static int points = 0;
	public static  JButton btnNewButton_9;
	public static  int  life;
	private Random rand = new Random();

	public TestUI() {
		getContentPane().setLayout(null);
		this.setSize(900, 700);
		this.setLocationRelativeTo(null);
		
		label = new JLabel("0");
		label.setBounds(68, 423, 46, 14);
		getContentPane().add(label);
		
		btnTest = new JButton();
		btnTest.setIcon(new ImageIcon("pictures\\hole.png"));
		btnTest.setBounds(249, 55, 78, 62);
		btnTest.setOpaque(false);
		btnTest.setContentAreaFilled(false);
		btnTest.setBorderPainted(false);
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
		btnTest3.setBounds(169, 55, 78, 62);
		btnTest3.setOpaque(false);
		btnTest3.setContentAreaFilled(false);
		btnTest3.setBorderPainted(false);
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
		btnTest2.setBounds(90, 55, 78, 62);
		btnTest2.setOpaque(false);
		btnTest2.setContentAreaFilled(false);
		btnTest2.setBorderPainted(false);
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
		
		btnNewButton_9 = new JButton("");
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
		}
	}

	public void play() {
		
		Timer movingHoles = new Timer();
		movingHoles.schedule(new TimerTask(){
			@Override
			public void run(){
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
					points+=clicks;
					MainMenu.saveData();
					life = 20;
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
}
