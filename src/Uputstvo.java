import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;


public class Uputstvo extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Uputstvo dialog = new Uputstvo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Uputstvo() {
		setResizable(false);
		setBounds(100, 100, 523, 375);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		JLabel label = new JLabel("<html>Uputstvo<br><b>Format text</b><br>Bold,italic,underline dugmici imaju svoje opozite,i oni oslobadjaju text istih osobina.<br>" +
				"Pozadina aplikacije menja boju kad udjete u menubar,options,background color.Obavezno apply nakon toga.<br>Tajmer u istom odeljku options sluzi za" +
				"ogranicavanje rada korisnika,odnosno to je podsetnik koji se aktivira na interval koji korisnik odabere.Isto apply obavezno.Nikako nemojte aktivirate tajmer na vremenski interval 0 :D.<br>Mane<br>" +
				"Generalno sam razocaran RTFom jave,sa kojim sam se sad prvi put upoznao.Podesavanje fonta se odnosi na ceo dokument,dok su ostala podesavanja moguca na selektovan textu.Posto je tekst moguce formatirati kao richtext,a save opcija<br>" +
				"nudi samo cuvanje txt dokumenata, ovo formatiranje nema neku poentu,jer txt nije RT.<br>Moguce je bilo koriscenje biblioteka koje nam dozvoljavaju vezu sa microsoft officom.Ali imao sam jako malo vremena za ovo.<br>" +
				"Ako pravite text editor ili baratate sa rtf-om,moja preporuka je c# .Ali mozda gresim.nadam se:D:D:D</html>",SwingConstants.LEFT);
		label.setVerticalAlignment(SwingConstants.TOP);
		
		label.setBounds(0, 0, 497, 337);
		contentPanel.add(label);
		
		
		
	}
}
