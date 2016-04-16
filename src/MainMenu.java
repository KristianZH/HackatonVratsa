import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainMenu extends JFrame{
	
	TestUI playGame;
	Shop shop;
	
	public MainMenu() {
		this.playGame = new TestUI();
		this.shop = new Shop();
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Play");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				playGame = new TestUI();
				setVisible(false);
				playGame.setVisible(true);
				playGame.play();
			}
		});
		btnNewButton.setBounds(279, 147, 200, 55);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				shop.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(279, 236, 200, 55);
		getContentPane().add(btnNewButton_1);
		this.setSize(900, 700);
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
		
	}

	
	
}
