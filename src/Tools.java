

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Window.Type;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;

public class Tools extends JDialog  {
	


	public JSpinner spinner;
	public JCheckBox tajmerCheckBox;
	public JRadioButton radioMin ;
	public JRadioButton radioCas ;
	public JButton apply;
	public JColorChooser bojaFrejma;
	public Color boja_2;
	JButton btnNewButton;
	JPanel panel;
	public Color getBoja_2() {
		return boja_2;
	}


	public void setBoja_2(Color boja_2) {
		this.boja_2 = boja_2;
	}


	public JColorChooser getBojaFrejma() {
		return bojaFrejma;
	}


	public void setBojaFrejma(JColorChooser bojaFrejma) {
		this.bojaFrejma = bojaFrejma;
	}


	public JSpinner getSpinner() {
		return spinner;
	}


	public void setSpinner(JSpinner spinner) {
		this.spinner = spinner;
	}


	public JCheckBox getTajmerCheckBox() {
		return tajmerCheckBox;
	}


	public void setTajmerCheckBox(JCheckBox tajmerCheckBox) {
		this.tajmerCheckBox = tajmerCheckBox;
	}


	public JRadioButton getRadioMin() {
		return radioMin;
	}


	public void setRadioMin(JRadioButton radioMin) {
		this.radioMin = radioMin;
	}


	public JRadioButton getRadioCas() {
		return radioCas;
	}


	public void setRadioCas(JRadioButton radioCas) {
		this.radioCas = radioCas;
	}


	public JButton getApply() {
		return apply;
	}


	public void setApply(JButton apply) {
		this.apply = apply;
	}

	//private JFrame frmTools;

	
	
	public Tools(JFrame vlasnik, boolean modal) {
		super(vlasnik,modal);
		initialize();
	}

	
	private void initialize() {
		
		this.setTitle("Tools");
		this.setBounds(100, 100, 450, 300);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setDefaultCloseOperation(JFrame.);
		this.getContentPane().setLayout(null);
		setModal(true);
		
		 panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Merac vremena rada", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(6, 13, 312, 75);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		 tajmerCheckBox = new JCheckBox("Tajmer korisnicki rad");
		tajmerCheckBox.setBounds(6, 18, 157, 23);
		panel.add(tajmerCheckBox);
		
		
		JLabel lblVremeTajmera = new JLabel("Vreme tajmera");
		lblVremeTajmera.setBounds(16, 48, 86, 14);
		panel.add(lblVremeTajmera);
		
	    spinner = new JSpinner();
		spinner.setBounds(105, 48, 29, 20);
		panel.add(spinner);
		spinner.setModel(new SpinnerNumberModel(1, 1, 3600, 1));
		
		
		JLabel lblU = new JLabel("u ");
		lblU.setBounds(144, 48, 19, 14);
		panel.add(lblU);
		
		 radioMin = new JRadioButton("min");
		radioMin.setBounds(154, 43, 54, 25);
		panel.add(radioMin);
		
		
		radioCas = new JRadioButton("casovima");
		radioCas.setBounds(220, 43, 86, 25);
		panel.add(radioCas);
		
		
		apply = new JButton("Apply");
		apply.setBounds(327, 224, 95, 25);
		
			radioMin.setSelected(false);
			radioCas.setSelected(false);
			//spinner.setValue(0);
			tajmerCheckBox.setSelected(false);
			radioMin.setEnabled(false);
			radioCas.setEnabled(false);
		this.getContentPane().add(apply);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pozadina", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(6, 99, 274, 46);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblBojaPozadineFramea = new JLabel("Boja pozadine frame-a");
		lblBojaPozadineFramea.setBounds(6, 18, 147, 14);
		panel_1.add(lblBojaPozadineFramea);
		
		 btnNewButton = new JButton("color");
		btnNewButton.setBounds(179, 16, 89, 23);
		panel_1.add(btnNewButton);
		btnNewButton.setToolTipText("boja pozadine frejma");
		
		
		bojaFrejma =new JColorChooser();
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boja_2=bojaFrejma.showDialog(panel,
						"odaberi boju pozadine fonta", bojaFrejma.getBackground());
				
			}
		});
	/*apply.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				boolean MIN=false;
				boolean H=false;
				boolean chkb=false;
				int spin=(int) spinner.getValue();
				
						if(radioMin.isSelected()) MIN=true;
						else MIN=false;
				radioMin.setSelected(MIN);
				if(radioCas.isSelected()) H=true;
				else H=false;
				radioCas.setSelected(H);
				if(tajmerCheckBox.isSelected()) chkb=true;
				else chkb=false;
				tajmerCheckBox.setSelected(chkb);
				spinner.setValue(spin);
				
				
				
			}
		});*/
		
	}


	public JButton getBtnNewButton() {
		return btnNewButton;
	}


	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}
}
