import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.Color;
import javax.swing.JLabel;

public class MainMenu extends JFrame {

	TestUI playGame;
	Shop shop;

	public MainMenu() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		readData();

		this.playGame = new TestUI();
		this.shop = new Shop();
		getContentPane().setLayout(null);
		JButton btnNewButton = new JButton("Play");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				playGame = new TestUI();
				TestUI.life = 50 + Shop.life;
				setVisible(false);
				playGame.setVisible(true);
				playGame.play();
			}
		});
		btnNewButton.setBounds(130, 175, 200, 55);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Shop");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				shop.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(130, 286, 200, 55);
		getContentPane().add(btnNewButton_1);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(130, 391, 200, 55);
		getContentPane().add(btnExit);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(0, 0, 529, 502);
		lblNewLabel.setIcon(new ImageIcon("pictures\\main menu.png"));
		getContentPane().add(lblNewLabel);
		this.setSize(545, 541);
		this.setLocationRelativeTo(null);

		this.setVisible(true);

	}

	static void saveData() {
		try (FileWriter fr = new FileWriter(new File("shop"))) {
			fr.write(String.valueOf(TestUI.points));
			fr.write("\n");
			fr.write(Shop.b1IsBought);
			fr.write("\n");
			fr.write(Shop.b2IsBought);
			fr.write("\n");
			fr.write(Shop.b3IsBought);
			fr.write("\n");
			fr.write(Shop.b4IsBought);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void readData() {
		Scanner fr = null;
		try {
			File f = new File("shop");

			fr = new Scanner(f);

			TestUI.points = Integer.valueOf(fr.nextLine());
			Shop.b1IsBought = fr.nextLine();
			Shop.b2IsBought = fr.nextLine();
			Shop.b3IsBought = fr.nextLine();
			Shop.b4IsBought = fr.nextLine();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			if (!fr.equals(null)) {
				fr.close();
			}
		}

	}
}
