package com.assignment3.projekt;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Controller3 extends JFrame{
	private static final long serialVersionUID = -3070018135689263033L;

	Model model;
	JPanel contentpane;
	JPanel southpanel;
	JPanel northpanel;
	JButton ok;
	JTextField textfield;
	JButton ajoute;
	JButton supprime;
	JButton rotschwarz;
	JButton patricia;
	JButton roBDDs;
	JButton visualize;
	
	@SuppressWarnings("unused")
	public Controller3( String title) {
		
		super(title);
		//udraw aus uni Bremen
		model = new Model();
	
		contentpane=new JPanel(new BorderLayout());
		
		southpanel= new JPanel(new GridLayout(2, 3));
		
		northpanel=new JPanel(new FlowLayout());
		
		visualize = new JButton("VISUALIZE");
		
		ok= new JButton("OK");
		textfield=new JTextField();
		ajoute = new JButton("Einfügen");
		supprime = new JButton("löschen");
		southpanel.add(ajoute);
		southpanel.add(textfield);
		southpanel.add(supprime);
		southpanel.add(ok);
		southpanel.add(visualize);
		
		
		rotschwarz=new JButton("Rot Schwarz Baum");
		patricia=new JButton("Patricia Trees");
		roBDDs=new JButton("RoBDDs");
		
		
		northpanel.add(rotschwarz);
		northpanel.add(patricia);
		northpanel.add(roBDDs);
		
		rotschwarz.addActionListener(e->{
			model.setSelectedTree(Model.BLACK_RED_ID);
		});
		
		
		ajoute.addActionListener(e->{
			model.add(textfield.getText());
			textfield.setText("");
		});
		supprime.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		visualize.addActionListener(e->{
			try {
				this.visualisieren(model.generateUdrawString());
			} catch (Exception e1) {
				textfield.setText("no tree selected");
			}
		});
		
		setContentPane(contentpane);
		contentpane.add(BorderLayout.NORTH,northpanel);
		contentpane.add(BorderLayout.SOUTH,southpanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
		
	}
	@Override
	public Dimension getPreferredSize() {
		
		return new Dimension(400,400);
	}
	
	public void visualisieren(String s) {
		try {
			FileWriter fw = new FileWriter("test.udg");
			fw.write(s);
			fw.close();
			new ProcessBuilder("C:\\Program Files (x86)\\uDraw(Graph)\\bin\\uDrawGraph.exe","test.udg").start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
