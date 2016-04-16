import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Shop extends JFrame{
	public Shop() {
		
		this.setSize(900, 700);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
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
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(339, 92, 129, 36);
		getContentPane().add(btnNewButton);
		
		JButton button = new JButton("New button");
		button.setBounds(339, 224, 129, 36);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(339, 356, 129, 36);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(339, 488, 129, 36);
		getContentPane().add(button_2);
		
		JLabel lblLife_2 = new JLabel("+10 life");
		lblLife_2.setBounds(201, 105, 46, 14);
		getContentPane().add(lblLife_2);
		
		JLabel lblLife_1 = new JLabel("+20 life");
		lblLife_1.setBounds(201, 237, 46, 14);
		getContentPane().add(lblLife_1);
		
		JLabel lblLife = new JLabel("+30 life");
		lblLife.setBounds(201, 369, 46, 14);
		getContentPane().add(lblLife);
		
		JLabel lblLife_3 = new JLabel("+50 life");
		lblLife_3.setBounds(201, 501, 46, 14);
		getContentPane().add(lblLife_3);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Test.main(null);
			}
		});
		btnBack.setBounds(231, 585, 142, 42);
		getContentPane().add(btnBack);
		this.setVisible(false);
		
	}

	
	
}
