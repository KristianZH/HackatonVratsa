import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameOverFrame extends JFrame {

	// public static JFrame frame;

	/**
	 * Create the application.
	 */
	public GameOverFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 900, 700);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(0, 0, 900, 700);
		lblNewLabel.setIcon(new ImageIcon("pictures\\tito.png"));
		getContentPane().add(lblNewLabel);

	}

}
