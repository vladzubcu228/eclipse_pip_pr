package ProiectBDecorator;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;

import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JRadioButton;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.EventListener;

import javax.swing.ButtonGroup;

public class Proiect {

	private JFrame frame;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	
	
	String Nr_Antrenor=new String();
	int Nr_Ore=0;
	int okPregatireFinaluri=0;
	int okPregatireDeschideri=0;
	Pregatire pregatire_finaluri = new PregatireFinaluri(new PregatireSimpla());
	Pregatire pregatire_deschideri = new PregatireDeschideri(new PregatireSimpla());
	Pregatire pregatire_simpla=new PregatireSimpla();
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proiect window = new Proiect();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Proiect() {
		start();
	}

	private void start() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setLayout(null);
		
		
		JLabel background=new JLabel(new ImageIcon("sah4.jpeg"));
		background.setBounds(0,0,1000,1000);
		frame.getContentPane().add(background, BorderLayout.NORTH);
		//frame.getContentPane().setBackground(Color.BLUE);
		
		textField = new JTextField();
		textField.setBounds(200, 20, 600, 60);
		textField.setEditable(false);
		background.add(textField);
		textField.setColumns(10);
		textField.setForeground(Color.BLACK);
		textField.setBackground(Color.ORANGE);
		textField.setFont(null);
		
		
		
		
		
		JButton btnPret = new JButton("Pret");
		btnPret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(okPregatireDeschideri==1)
					textField.setText(pregatire_deschideri.print()+"Antrenor:"+Nr_Antrenor+"  Pret:"+pregatire_deschideri.getPret(Nr_Ore)+" RON   "+" Numar Ore:"+pregatire_deschideri.getOre(Nr_Ore));
				else
					if(okPregatireFinaluri==1)
						textField.setText(pregatire_finaluri.print()+"Antrenor:"+Nr_Antrenor+"   Pret:"+pregatire_finaluri.getPret(Nr_Ore)+" RON   "+" Numar Ore:"+pregatire_finaluri.getOre(Nr_Ore));
					else
						textField.setText("Nu s-a selectat optiunea valida!!!!!!!");
				
			}
		});
		btnPret.setBounds(600, 115, 65, 33);
		
		
		JButton btnPregatireFinaluri = new JButton("Pregatire Finaluri");
		btnPregatireFinaluri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pregatire pregatire = new PregatireFinaluri(new PregatireSimpla());
				textField.setText(pregatire_finaluri.print());
				pregatire_finaluri=pregatire;
				okPregatireDeschideri=0;
				okPregatireFinaluri=1;
			}
		});
		btnPregatireFinaluri.setBounds(275, 114, 200, 23);
		
		
		JButton btnPregatireDeschideri = new JButton("Pregatire Deschideri");
		btnPregatireDeschideri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pregatire pregatire = new PregatireDeschideri(new PregatireSimpla());
				textField.setText(pregatire_deschideri.print());
				pregatire_deschideri=pregatire;
				okPregatireFinaluri=1;
				okPregatireDeschideri=0;
			}
		});
		btnPregatireDeschideri.setBounds(275, 148, 200, 23);

		
		JRadioButton radioButton_3 = new JRadioButton("Antrenor 3");
		radioButton_3.setBounds(275, 230, 100, 25);

		
		JRadioButton radioButton_2 = new JRadioButton("Antrenor 2");
		radioButton_2.setBounds(275, 210, 100, 25);

		
		JRadioButton radioButton_1 = new JRadioButton("Antrenor 1");
		radioButton_1.setBounds(275, 190, 100, 25);
		
		
		buttonGroup.add(radioButton_1);
		buttonGroup.add(radioButton_2);
		buttonGroup.add(radioButton_3);
		
		
		JButton btnAntrenori = new JButton("Antrenor");
		btnAntrenori.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				if(radioButton_1.isSelected()==true)
				Nr_Antrenor=radioButton_1.getText();
				
				else 
					{	if(radioButton_2.isSelected()==true)
						Nr_Antrenor=radioButton_2.getText();
						else
							{	if(radioButton_3.isSelected()==true)
								Nr_Antrenor=radioButton_3.getText();
							}
					}
						textField.setText("Antrenor:"+Nr_Antrenor);
			}
		});
		btnAntrenori.setBounds(390, 206, 89, 23);
		
		
		JRadioButton rdbtnOral = new JRadioButton("1 ora");
		rdbtnOral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnOral.isSelected()==true)
					Nr_Ore=1;

			}
		});
		rdbtnOral.setBounds(600, 180, 109, 23);
		
		
		JRadioButton rdbtnOra2 = new JRadioButton("2 ore");
		rdbtnOra2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnOra2.isSelected()==true)
					Nr_Ore=2;
			}
		});
		rdbtnOra2.setBounds(600, 206, 109, 23);
		
		
		JRadioButton rdbtnOra3 = new JRadioButton("3 ore");
		rdbtnOra3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnOra3.isSelected()==true)
					Nr_Ore=3;
			}
		});
		rdbtnOra3.setBounds(600, 232, 109, 23);
		
		buttonGroup_1.add(rdbtnOral);
		buttonGroup_1.add(rdbtnOra2);
		buttonGroup_1.add(rdbtnOra3);
		
		background.add(btnPregatireFinaluri);
		background.add(btnPregatireDeschideri);
		background.add(radioButton_1);
		background.add(radioButton_2);
		background.add(radioButton_3);
		background.add(btnAntrenori);
		background.add(rdbtnOral);
		background.add(rdbtnOra2);
		background.add(rdbtnOra3);
		background.add(btnPret);
		
		

		
	}
}
