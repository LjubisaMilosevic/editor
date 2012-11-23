import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;


public class Autor extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Autor dialog = new Autor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Autor() {
		setResizable(false);
		setTitle("Dart Jeger");
		setBounds(100, 100, 533, 454);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{    ImageIcon ljuba=new ImageIcon("src//5809_127286441513_8060132_n.jpg");
			JLabel lblNewLabel_1 = new JLabel();
			lblNewLabel_1.setIcon(ljuba);
			
			contentPanel.add(lblNewLabel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JLabel lblNewLabel = new JLabel("Milosevic Ljubisa dummerljuba@yahoo.com");
				lblNewLabel.setFont(new Font("Lucida Calligraphy", Font.BOLD, 16));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				buttonPane.add(lblNewLabel);
			}
		}
	}

}
