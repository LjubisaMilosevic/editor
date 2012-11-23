import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.JobAttributes;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.io.*;
import java.awt.print.PrinterException;
import javax.print.attribute.standard.DocumentName;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.TransferHandler;

import java.awt.FlowLayout;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.colorchooser.ColorChooserComponentFactory;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.MenuListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import javax.swing.text.Element;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.Highlight;
import javax.swing.text.Segment;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleConstants.ParagraphConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.StyledEditorKit.FontSizeAction;
import javax.swing.text.rtf.RTFEditorKit;

import java.awt.GridLayout;
import javax.swing.border.TitledBorder;



public class Editor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFileChooser citac;
	private File trenutniFajl;
	private MenuBar menu;
	public JPanel panel;
	private JButton anderlajn;
	private JButton unAnderlajn;
	private JButton unBold;
	private JButton bold;
	private JButton italic;
	private JButton unItalic;
	private JButton velicinaFonta;
	private JButton boje;
	private JButton pozadinaBoje;
	private JButton pozadinaFonta;
	private Menu file;
	private Menu edit;
	private Menu help;
	private MenuItem New;
	private MenuItem close;
	private MenuItem autor;
	private MenuItem uputstvo;
	private MenuItem search;
	private MenuItem saveas;
	private MenuItem save;
	private MenuItem open;
	private MenuItem copy;
	private MenuItem paste;
	private MenuItem cut;
	private MenuItem selectAll;
	private MenuItem tools;
	private MenuItem print;
	private JScrollPane skrol;
	private JComboBox<String> fonts;
	private JTextPane papir;
	private JComboBox size;
	// private JComboBox boje;
	DefaultComboBoxModel model;
	private StyleContext kontekst;
	private Style stajl;
	private DefaultStyledDocument doc;
	private Font ITALIC;
	private JColorChooser bojanka;
	private JTextField pretrazivacPolje;
	public String word;
	boolean kopi_paste;
	private int vrednostTajmer;

	private JButton pretraga;
	private String Line;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private Tools alati;
	private Autor ljuba;
	private long startTime;
	private long currentTime;
	private javax.swing.Timer t;

	// public Tools alati;
	private Editor() {
		super("Dart Worder");
		napravi();
		startTime = System.currentTimeMillis() / 1000 / 60;
	}

	// alati= new Tools(this,true);

	@SuppressWarnings("deprecation")
	public void napravi() {

		setVisible(true);
		citac = new JFileChooser();
		alati = new Tools(this, true);

		panel = new JPanel();
		Dimension velicinaPanel = new Dimension(600, 400);
		panel.setPreferredSize(velicinaPanel);
		setContentPane(panel);
		setSize(610, 600);
		setResizable(false);
		MenuBar menu = new MenuBar();
		setMenuBar(menu);

		panel_1 = new JPanel();
		panel_1.setForeground(Color.BLUE);
		panel_1.setBorder(new TitledBorder(null, "italic",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2 = new JPanel();
		panel_2.setForeground(Color.BLUE);
		panel_2.setBorder(new TitledBorder(null, "bold", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_3 = new JPanel();
		panel_3.setForeground(Color.BLUE);
		panel_3.setBorder(new TitledBorder(null, "underline",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4 = new JPanel();
		panel_4.setForeground(Color.BLUE);
		panel_4.setBorder(new TitledBorder(null, "font colors",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		StyleContext sc = new StyleContext();
		doc = new DefaultStyledDocument(sc);
		papir = new JTextPane(doc);

		Dimension velicinaPapir = panel.getPreferredSize();
		papir.setBounds(50, 50, velicinaPapir.width - 50,
				velicinaPapir.height - 50);
		papir.setPreferredSize(new Dimension(velicinaPapir.width - 50,
				velicinaPapir.height - 50));
		papir.setMinimumSize(new Dimension(velicinaPapir.width - 50,
				velicinaPapir.height - 50));

		skrol = new JScrollPane(papir);
		file = new Menu("File");
		edit = new Menu("Edit");
		help = new Menu("Help");

		fonts = new JComboBox<String>(GraphicsEnvironment
				.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
		model = new DefaultComboBoxModel();
		size = new JComboBox(model);
		int brojac = 0;
		for (int i = 5; i < 70; i++) {
			// String s = Integer.toString(i);
			model.addElement(i);

		}
		for (int i = 0; i < model.getSize(); i++) {
			if (model.getIndexOf(papir.getFont().getSize()) == i)
				size.setSelectedIndex(i);

		}

		/*
		 * Color pink = new Color(255, 192, 203); Color skyblue = new Color(135,
		 * 206, 255); Color blue = new Color(0, 0, 255); Color violet = new
		 * Color(148, 0, 211); Color magenta = new Color(238, 0, 238); Color red
		 * = new Color(255, 0, 0); Color black = new Color(100, 100, 100); Color
		 * green = new Color(0, 255, 0); Color darkGreen = new Color(0, 139,
		 * 69); Color yelow = new Color(255, 255, 0); Color white = new Color(0,
		 * 0, 0); Color orange = new Color(255, 165, 0); Color grey = new
		 * Color(183, 183, 183); final Color[] colors = { blue, black, green,
		 * yelow, white, orange, grey, pink, skyblue, magenta, darkGreen, grey,
		 * violet }; final String[] COLORS = { "blue", "black", "green",
		 * "yelow", "white", "orange", "grey", "pink", "skyblue", "magenta",
		 * "darkGreen", "grey", "violet" };
		 */

		Icon italicIcon = new ImageIcon("src//format-text-italic.png");
		Icon boldIcon = new ImageIcon("src//format-text-bold.png");
		Icon underlineIcon = new ImageIcon("src//format-text-underline.png");

		Icon italicIcon2 = new ImageIcon("src//format-text-italic2.png");
		Icon boldIcon2 = new ImageIcon("src//format-text-bold2.png");
		Icon underlineIcon2 = new ImageIcon("src//format-text-underline2.png");

		Icon fontColorICon = new ImageIcon("src//gtk-color-picker.png");
		Icon backgroundColorIcon = new ImageIcon("src//colorpicker.png");
		Icon highlightIcon = new ImageIcon("src//highlighter_text.png");

		Icon searchIcon = new ImageIcon("src//Search.png");
		Icon newFileIcon = new ImageIcon("src//new file.png");
		Icon saveIcon = new ImageIcon("src//Save-01.png");
		Icon saveAsIcon = new ImageIcon("src//document-save-as.png");
		Icon closeIcon = new ImageIcon("src//gtk-no.png");

		bojanka = new JColorChooser();
		pozadinaBoje = new JButton(backgroundColorIcon);
		pozadinaFonta = new JButton(highlightIcon);
		boje = new JButton(fontColorICon);
		unBold = new JButton(boldIcon);
		bold = new JButton(boldIcon2);
		anderlajn = new JButton(underlineIcon);
		unAnderlajn = new JButton(underlineIcon2);
		velicinaFonta = new JButton("fontSize");
		pretraga = new JButton(searchIcon);
		pretrazivacPolje = new JTextField("pretraga");
		italic = new JButton(italicIcon);
		unItalic = new JButton(italicIcon2);

		bold.setToolTipText("bold");
		unBold.setToolTipText("no bold");
		italic.setToolTipText("italic");
		unItalic.setToolTipText("no italic");
		anderlajn.setToolTipText("underline");
		unAnderlajn.setToolTipText("no underline");
		pozadinaBoje.setToolTipText("background color");
		pozadinaFonta.setToolTipText("font highlight");
		pretraga.setToolTipText("search");
		boje.setToolTipText("font color");
		size.setToolTipText("velicina teksta");
		fonts.setToolTipText("fonts");

		menu.add(file);
		menu.add(edit);
		menu.add(help);

		New = new MenuItem("New");
		saveas = new MenuItem("Save as");
		save = new MenuItem("Save");
		open = new MenuItem("Open");
		close = new MenuItem("Close");
		autor = new MenuItem("autor");
		uputstvo = new MenuItem("uputstvo");
		search = new MenuItem("search");
		copy = new MenuItem("copy");
		paste = new MenuItem("paste");
		cut = new MenuItem("cut");
		selectAll = new MenuItem("select all");
		tools = new MenuItem("options");
		print=new MenuItem("print");

		file.add(New);
		file.add(open);
		file.add(saveas);
		file.add(save);
		file.add(close);
		file.add(print);
		edit.add(copy);
		edit.add(paste);
		edit.add(cut);
		edit.add(selectAll);
		edit.add(tools);
		help.add(uputstvo);
		help.add(autor);
		panel.add(pretraga);
		panel.add(pretrazivacPolje);
		panel.add(skrol);
		panel.add(size);
		panel.add(fonts);
		panel.add(pozadinaBoje);
		panel_2.add(bold);
		panel_2.add(unBold);
		panel.add(panel_1);
		panel.add(panel_2);
		panel.add(panel_3);
		panel.add(panel_4);

		panel_3.add(anderlajn);
		panel_3.add(unAnderlajn);
		panel_4.add(pozadinaFonta);
		panel_4.add(boje);

		stajl = sc.addStyle("stil", null);
		panel_1.add(italic);
		panel_1.add(unItalic);
		uputstvo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Uputstvo u= new Uputstvo();
				u.setVisible(true);
				
			}
		});
		autor.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent arg0) {
			ljuba=new Autor();
			ljuba.setVisible(true);
				
			}
		});
		print.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PrinterJob stampanje = PrinterJob.getPrinterJob();
				PageFormat format = stampanje.defaultPage();
				stampanje.setPrintable(new Print(), format);
				
					if (stampanje.printDialog())
						try {
							stampanje.print();
						} catch (PrinterException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
				
			}
		});
		tools.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				alati.setVisible(true);
				alati.setResizable(false);
			}
		});

		alati.getTajmerCheckBox().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (alati.getTajmerCheckBox().isSelected()) {
					alati.getRadioCas().setEnabled(true);
					alati.getRadioMin().setEnabled(true);
					alati.getSpinner().setEnabled(true);

				} else {
					alati.getRadioCas().setEnabled(false);
					alati.getRadioMin().setEnabled(false);
					alati.getSpinner().setEnabled(false);

				}
				System.out.println(vrednostTajmer);

			}
		});
		alati.getRadioCas().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (alati.getRadioCas().isSelected()) {
					vrednostTajmer = (Integer) alati.getSpinner().getValue() * 1000 * 60 * 60;
					alati.getRadioMin().setSelected(false);
				}

			}
		});
		alati.getRadioMin().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (alati.getRadioMin().isSelected()) {
					vrednostTajmer = (Integer) alati.getSpinner().getValue() * 1000 * 60;
					alati.getRadioCas().setSelected(false);
				}

			}
		});

		alati.getApply().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				panel.setBackground(alati.getBoja_2());
				panel_1.setBackground(alati.getBoja_2());
				panel_2.setBackground(alati.getBoja_2());
				panel_3.setBackground(alati.getBoja_2());
				panel_4.setBackground(alati.getBoja_2());
				int pom=0;
				if (alati.getTajmerCheckBox().isSelected()) {
					currentTime = (int) (System.currentTimeMillis() / 1000 / 60 - startTime);
					t = new javax.swing.Timer(vrednostTajmer,
							new ActionListener() {
								public void actionPerformed(ActionEvent e) {

									JOptionPane.showMessageDialog(null,
											"koristite racunar vec"
													+ currentTime + "minuta");
								}
							});

					t.start();
					pom=1;
				}

				else 
					t.stop();
				
				System.out.println(vrednostTajmer);
				

			}
			
			
		});

		kopi_paste = false;
		selectAll.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				papir.selectAll();

			}
		});
		cut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Copy();
				papir.replaceSelection("");
				kopi_paste = true;

			}
		});
		paste.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (kopi_paste == true)
					Paste();
				else
					JOptionPane.showMessageDialog(null, "Niste kopirali nista");

			}
		});
		copy.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Copy();
				kopi_paste = true;

			}
		});
		unItalic.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				stajl.addAttribute(StyleConstants.Italic, false);
				doc.setCharacterAttributes(papir.getSelectionStart(),
						papir.getSelectionEnd() - papir.getSelectionStart(),
						stajl, false);

			}
		});
		italic.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				stajl.addAttribute(StyleConstants.Italic, true);
				doc.setCharacterAttributes(papir.getSelectionStart(),
						papir.getSelectionEnd() - papir.getSelectionStart(),
						stajl, false);

			}
		});

		ITALIC = new Font(papir.getFont().getName(), Font.ITALIC, papir
				.getFont().getSize());
		pretraga.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int brojacReci = 0;
				String trenutniTekst2 = papir.getText();
				word = pretrazivacPolje.getText();
				String trenutniTekst = papir.getText();
				String zamena = "a";
				StringReader readtext = new StringReader(trenutniTekst);
				BufferedReader readBuffer = new BufferedReader(readtext);
				int brojac = 0;
				for (int i = 0; i < word.length() - 1; i++) {
					zamena = zamena + "+";
				}

				try {
					Line = readBuffer.readLine();
				} catch (IOException e1) {

				}
				int found = 0;
				int pokazivac = 0;
				while (pokazivac < trenutniTekst.lastIndexOf(word)) {
					// System.out.println(word.length());
					// System.out.println(zamena);
					if (!Line.contains(word)) {
						JOptionPane.showMessageDialog(null, "nema te reci");
					}
					papir.setSelectionStart(trenutniTekst.indexOf(word)
							- brojac);
					papir.setSelectionEnd(trenutniTekst.indexOf(word)
							+ word.length() - brojac);
					DefaultHighlighter.DefaultHighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(
							Color.YELLOW);
					pokazivac = pokazivac + 1;
					brojac = brojac + 1;
					try {
						papir.getHighlighter().addHighlight(
								trenutniTekst.indexOf(word),
								trenutniTekst.indexOf(word) + word.length(),
								highlightPainter);
					} catch (BadLocationException e2) {

					}
					trenutniTekst = trenutniTekst.replaceFirst(word, zamena);

				}
				String[] choices = { "replace all with:", "replace next" };
				int odgovor = JOptionPane.showOptionDialog(null, "replace?",
						"Dart Worder replace", JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, choices, "cancel");
				if (odgovor == JOptionPane.YES_OPTION) {
					String input = JOptionPane.showInputDialog("replace all?");

					String novi = papir.getText().replaceAll(word, input);

					papir.setText(" ");
					papir.setText(novi);
				} else {
					int pokazivac1 = 0;
					int odgovor1 = 0;
					String input = JOptionPane.showInputDialog("replace with?");
					while (odgovor1 == JOptionPane.YES_OPTION) {
						odgovor1 = JOptionPane.showConfirmDialog(null,
								"Sledece pojavljivanje?");
						String novi = papir.getText().replaceFirst(word, input);
						papir.setText(" ");
						papir.setText(novi);
						if (!papir.getText().contains(word)) {
							JOptionPane.showMessageDialog(null,
									"nema vise trazene reci");
							break;
						}
					}

				}
			}
		});

		pozadinaFonta.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Color nekaBoja = bojanka.showDialog(panel,
						"odaberi boju pozadine fonta", bojanka.getBackground());
				stajl.addAttribute(StyleConstants.Background, nekaBoja);
				int odgovor = JOptionPane
						.showConfirmDialog(
								null,
								"Da li zelite da promenite boju pozadine fonta na celom dokumentu?Ako hocete samo selektovan tekst da promenite kliknite NO",
								"boja teksta", JOptionPane.YES_NO_OPTION);
				if (odgovor == JOptionPane.YES_OPTION) {
					doc.setCharacterAttributes(0, papir.getHeight(), stajl,
							false);

				} else {

					doc.setCharacterAttributes(
							papir.getSelectionStart(),
							papir.getSelectionEnd() - papir.getSelectionStart(),
							stajl, false);
				}

			}
		});
		pozadinaBoje.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Color nekaBoja = bojanka.showDialog(panel,
						"odaberi boju pozadine dokumenta",
						bojanka.getBackground());
				papir.setBackground(nekaBoja);

			}
		});
		boje.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Color nekaBoja = bojanka.showDialog(panel,
						"odaberi boju fonta", bojanka.getBackground());
				int odgovor = JOptionPane
						.showConfirmDialog(
								null,
								"Da li zelite da promenite boju fonta na celom dokumentu?Ako hocete samo selektovan tekst da promenite kliknite NO",
								"boja teksta", JOptionPane.YES_NO_OPTION);
				if (odgovor == JOptionPane.YES_OPTION) {
					StyleConstants.setForeground(stajl, nekaBoja);
					doc.setCharacterAttributes(0, papir.getHeight(), stajl,
							false);
				} else {
					StyleConstants.setForeground(stajl, nekaBoja);
					doc.setCharacterAttributes(
							papir.getSelectionStart(),
							papir.getSelectionEnd() - papir.getSelectionStart(),
							stajl, false);
				}

			}
		});
		size.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int odgovor = JOptionPane
						.showConfirmDialog(
								null,
								"Da li zelite da promenite velicinu fonta na celom dokumentu?Ako hocete samo selektovan tekst da promenite kliknite NO",
								"Velicina teksta", JOptionPane.YES_NO_OPTION);
				if (odgovor == JOptionPane.YES_OPTION) {
					stajl.addAttribute(StyleConstants.FontSize,
							model.getSelectedItem());
					doc.setCharacterAttributes(0, papir.getHeight(), stajl,
							false);
				} else {

					stajl.addAttribute(StyleConstants.FontSize,
							model.getSelectedItem());
					doc.setCharacterAttributes(
							papir.getSelectionStart(),
							papir.getSelectionEnd() - papir.getSelectionStart(),
							stajl, false);

				}
			}
		});
		unBold.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				stajl.addAttribute(StyleConstants.Bold, false);
				doc.setCharacterAttributes(papir.getSelectionStart(),
						papir.getSelectionEnd() - papir.getSelectionStart(),
						stajl, false);

			}
		});
		bold.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				stajl.addAttribute(StyleConstants.Bold, true);
				doc.setCharacterAttributes(papir.getSelectionStart(),
						papir.getSelectionEnd() - papir.getSelectionStart(),
						stajl, false);

			}
		});
		fonts.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				papir.setFont(new Font((String) fonts.getSelectedItem(),
						Font.PLAIN, 12));

			}
		});
		open.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int otvaranje = citac.showOpenDialog(null);
				if (otvaranje == JFileChooser.APPROVE_OPTION)
					otvoriFajl(citac.getSelectedFile());

			}
		});

		save.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (trenutniFajl == null) {
					int cuvanjeNovog = citac.showSaveDialog(null);
					if (cuvanjeNovog == JFileChooser.APPROVE_OPTION)
						sacuvajFajl(citac.getSelectedFile(), papir.getText());
				} else {
					sacuvajFajl(trenutniFajl, papir.getText());

				}

			}
		});

		saveas.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int cuvanjeNovog = citac.showSaveDialog(null);
				if (cuvanjeNovog == JFileChooser.APPROVE_OPTION)
					sacuvajFajl(citac.getSelectedFile(), papir.getText());
				setTitle(citac.getSelectedFile().getName());
			}
		});

		anderlajn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				stajl.addAttribute(StyleConstants.Underline, true);
				doc.setCharacterAttributes(papir.getSelectionStart(),
						papir.getSelectionEnd() - papir.getSelectionStart(),
						stajl, false);

			}
		});
		unAnderlajn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				stajl.addAttribute(StyleConstants.Underline, false);
				doc.setCharacterAttributes(papir.getSelectionStart(),
						papir.getSelectionEnd() - papir.getSelectionStart(),
						stajl, false);

			}
		});
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		New.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int odgovor = JOptionPane.showConfirmDialog(null,
						"Da li zelite da sacuvate dokument?",
						"Sacuvaj dokument", JOptionPane.YES_NO_OPTION);
				if (odgovor == JOptionPane.YES_OPTION) {
					int cuvanjeNovog = citac.showSaveDialog(null);
					if (cuvanjeNovog == JFileChooser.APPROVE_OPTION)
						sacuvajFajl(citac.getSelectedFile(), papir.getText());
					papir.setText("");
					trenutniFajl = null;
					setTitle("Dart Worder New file");
				} else {

					papir.setText("");
					setTitle("Dart Worder New file");
				}
			}
		});
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int odgovor = JOptionPane
						.showConfirmDialog(
								null,
								"Da li zelite da sacuvate dokument pre zatvaranja programa?",
								"Sacuvaj dokument", JOptionPane.YES_NO_OPTION);
				if (odgovor == JOptionPane.YES_OPTION) {
					int cuvanjeNovog = citac.showSaveDialog(null);
					if (cuvanjeNovog == JFileChooser.APPROVE_OPTION)
						sacuvajFajl(citac.getSelectedFile(), papir.getText());

					dispose();
				} else {
					dispose();
				}

			}
		});
	}

	public void sacuvajFajl(File fajl, String sadrzaj) {
		BufferedWriter citacFajla = null;
		String filePath = fajl.getPath();
		if (!filePath.endsWith(".txt"))
			filePath = filePath + ".txt";
		try {
			citacFajla = new BufferedWriter(new FileWriter(filePath));
			citacFajla.write(sadrzaj);
			citacFajla.close();
			papir.setText(sadrzaj);
			trenutniFajl = fajl;
		} catch (IOException e) {

		}
	}

	public void otvoriFajl(File fajl) {
		if (fajl.canRead()) {
			String sadrzaj = "";
			String putanja = fajl.getPath();
			if (putanja.endsWith(".txt")) {
				try {
					Scanner skener = new Scanner(new FileInputStream(fajl));
					while (skener.hasNextLine()) {
						sadrzaj = sadrzaj + skener.nextLine();
					}
					skener.close();
				} catch (FileNotFoundException e) {

				}
				papir.setText(sadrzaj);
				trenutniFajl = fajl;
				setTitle(fajl.getName());

			} else {
				JOptionPane.showMessageDialog(null, "samo txt fajlove");
			}
		} else {
			JOptionPane.showMessageDialog(null, "ne moze se ucitati");
		}
	}

	public void Copy() {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		TransferHandler transferHandler = papir.getTransferHandler();
		transferHandler.exportToClipboard(papir, clipboard,
				TransferHandler.COPY);
	}

	public void Paste() {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		TransferHandler transferHandler = papir.getTransferHandler();
		transferHandler.importData(papir, clipboard.getContents(null));
	}

	public static void main(String[] args) {

		new Editor();

	}

}
