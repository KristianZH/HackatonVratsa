import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

public class Shop extends JFrame  {
	private JButton use1;
	private JButton use2;
	private JButton use3;
	private JButton use4;
	private JButton buy1;
	private JButton buy2;
	private JButton buy3;
	private JButton buy4;
	static String b1IsBought="false";
    static String b2IsBought="false";
	static String b3IsBought="false";
	static String b4IsBought="false";
	static int flag1=0;

	

	static int life;

	
	
	
	
	private void checkPrice(JLabel points) {
		if (Integer.valueOf(points.getText()) < 100) {
			buy1.setEnabled(false);
		}
		if (Integer.valueOf(points.getText()) < 250) {
			buy2.setEnabled(false);
		}
		if (Integer.valueOf(points.getText()) < 500) {
			buy3.setEnabled(false);
		}
		if (Integer.valueOf(points.getText()) < 1000) {
			buy4.setEnabled(false);
		}
	}
	
	

	public Shop() {
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel points = new JLabel("0");
		points.setBounds(105, 588, 46, 14);
		points.setText(String.valueOf(Integer.valueOf(Integer.valueOf(points.getText())
				+ Integer.valueOf(TestUI.points))));
		getContentPane().add(points);
		

		this.setSize(900, 700);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		JLabel lbl1 = new JLabel("+10 life");
		lbl1.setBounds(201, 105, 46, 14);
		getContentPane().add(lbl1);

		JLabel lbl2 = new JLabel("+20 life");
		lbl2.setBounds(201, 237, 46, 14);
		getContentPane().add(lbl2);

		JLabel lbl3 = new JLabel("+30 life");
		lbl3.setBounds(201, 369, 46, 14);
		getContentPane().add(lbl3);

		JLabel lbl4 = new JLabel("+50 life");
		lbl4.setBounds(201, 501, 46, 14);
		getContentPane().add(lbl4);
		JLabel car1 = new JLabel("CAR 1");
		car1.setBounds(62, 52, 129, 121);
		getContentPane().add(car1);

		JLabel car2 = new JLabel("CAR 2");
		car2.setBounds(62, 184, 129, 121);
		getContentPane().add(car2);

		JLabel car3 = new JLabel("CAR 3");
		car3.setBounds(62, 316, 129, 121);
		getContentPane().add(car3);

		JLabel car4 = new JLabel("CAR 4");
		car4.setBounds(62, 448, 129, 121);
		getContentPane().add(car4);

		buy1 = new JButton("100p");
		if (Integer.valueOf(points.getText()) < 100) {
			buy1.setEnabled(false);
		}
		
		buy1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				use1.setVisible(true);
				TestUI.points = Integer.valueOf(points.getText()) - 100;
				points.setText(String.valueOf(Integer.valueOf(points.getText()) - 100));
				buy1.setEnabled(false);
				checkPrice(points);
				b1IsBought="true";
				MainMenu.saveData();
				
			}

		});
		buy1.setBounds(339, 92, 129, 36);
		getContentPane().add(buy1);

		buy2 = new JButton("250p");
		if (Integer.valueOf(points.getText()) < 250) {
			buy2.setEnabled(false);
		}
		buy2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				use2.setVisible(true);
				TestUI.points = Integer.valueOf(points.getText()) - 250;
				points.setText(String.valueOf(Integer.valueOf(points.getText()) - 250));
				buy2.setEnabled(false);
				checkPrice(points);
				b2IsBought="true";
				MainMenu.saveData();
			}
		});
		buy2.setBounds(339, 224, 129, 36);
		getContentPane().add(buy2);

		buy3 = new JButton("500p");
		if (Integer.valueOf(points.getText()) < 500) {
			buy3.setEnabled(false);
		}
		buy3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkPrice(points);
				use3.setVisible(true);
				TestUI.points = Integer.valueOf(points.getText()) - 500;
				points.setText(String.valueOf(Integer.valueOf(points.getText()) - 500));
				buy3.setEnabled(false);
				checkPrice(points);
				b3IsBought="true";
				MainMenu.saveData();
			}

		});
		buy3.setBounds(339, 356, 129, 36);
		getContentPane().add(buy3);

		buy4 = new JButton("1000p");
		if (Integer.valueOf(points.getText()) < 1000) {
			buy4.setEnabled(false);
		}
		buy4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				use4.setVisible(true);
				TestUI.points = Integer.valueOf(points.getText()) - 1000;
				points.setText(String.valueOf(Integer.valueOf(points.getText()) - 1000));
				buy4.setEnabled(false);
				checkPrice(points);
				b4IsBought="true";
				MainMenu.saveData();
			}
		});
		buy4.setBounds(339, 488, 129, 36);
		getContentPane().add(buy4);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Test.main(null);
			}
		});
		btnBack.setBounds(231, 585, 142, 42);
		getContentPane().add(btnBack);

		use4 = new JButton("Use");
		use4.setVisible(false);
		use4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				life = Integer.parseInt(lbl4.getText().substring(1, 3));
				use4.setEnabled(false);
				use3.setEnabled(true);
				use2.setEnabled(true);
				use1.setEnabled(true);
				flag1=4;
			}
		});
		use4.setBounds(532, 487, 57, 36);
		getContentPane().add(use4);

		use3 = new JButton("Use");
		use3.setVisible(false);
		use3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				life = Integer.parseInt(lbl3.getText().substring(1, 3));
				use3.setEnabled(false);
				use4.setEnabled(true);
				use2.setEnabled(true);
				use1.setEnabled(true);
				flag1=3;
			}
		});
		use3.setBounds(532, 356, 57, 36);
		getContentPane().add(use3);

		use2 = new JButton("Use");
		use2.setVisible(false);
		use2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				life = Integer.parseInt(lbl2.getText().substring(1, 3));
				use2.setEnabled(false);
				use3.setEnabled(true);
				use4.setEnabled(true);
				use1.setEnabled(true);
				flag1=2;
			}
		});
		use2.setBounds(532, 224, 57, 36);
		getContentPane().add(use2);

		use1 = new JButton("Use");
		use1.setVisible(false);
		use1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				life = Integer.parseInt(lbl1.getText().substring(1, 3));
				use1.setEnabled(false);
				use3.setEnabled(true);
				use2.setEnabled(true);
				use4.setEnabled(true);
				flag1=1;
			}
		});
		use1.setBounds(532, 92, 57, 36);
		getContentPane().add(use1);

		this.setVisible(false);

		if(Shop.b1IsBought.equals("true")){
			use1.setVisible(true);
			buy1.setEnabled(false);
			checkPrice(points);
			b1IsBought="true";
			
		}
		if(Shop.b2IsBought.equals("true")){
			use2.setVisible(true);
			buy2.setEnabled(false);
			checkPrice(points);
			b2IsBought="true";
			
		}
		if(Shop.b3IsBought.equals("true")){
			use3.setVisible(true);
			buy3.setEnabled(false);
			checkPrice(points);
			b3IsBought="true";
			
		}
		if(Shop.b4IsBought.equals("true")){
			use4.setVisible(true);
			buy4.setEnabled(false);
			checkPrice(points);
			b4IsBought="true";
			
		}
		
		JLabel lblCoins = new JLabel("New label");
		lblCoins.setBounds(31, 576, 46, 39);
		getContentPane().add(lblCoins);
		
		JLabel lblbackground = new JLabel("New label");
		lblbackground.setBounds(0, 0, 884, 661);
		getContentPane().add(lblbackground);
		
		
		car1.setIcon(new ImageIcon("pictures\\lambo.png"));
		car2.setIcon(new ImageIcon("pictures\\lambo2.png"));
		car3.setIcon(new ImageIcon("pictures\\merc.png"));
		car4.setIcon(new ImageIcon("pictures\\viper.png"));
		lblCoins.setIcon(new ImageIcon("pictures\\coins.jpg"));
		lblbackground.setIcon(new ImageIcon("pictures\\garage.jpg"));
		
		
		
	}
	

}
