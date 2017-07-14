package com.canh.healthcare.mdimanager.patientgui;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PrescribingForm extends JInternalFrame {
	
	private JLabel lblId = new JLabel("Id bệnh nhân");
	private JLabel lblName = new JLabel("Tên bệnh nhân");
	private JTextField txtId = new JTextField("test", 10);
	private JTextField txtName = new JTextField("test", 20);
	private JLabel lblBirthDay = new JLabel("Năm sinh");
	private JTextField txtBirthDate = new JTextField(10);
	private JLabel lblGender = new JLabel("Giới tính");
	private JTextField txtGender = new JTextField(10);
	
	private JLabel lblExamination= new JLabel("Ngày khám");
	private JTextField txtExamination = new JTextField(10);
	private JLabel lblReExamination= new JLabel("Ngày khám");
	private JTextField txtReExamination = new JTextField(10);
	private JLabel lblPriceExamination= new JLabel("Tiền khám");
	private JTextField txtPriveExamination = new JTextField(10);
	private JLabel lblhourExamination= new JLabel("Số giờ khám");
	private JTextField txtHourExamination = new JTextField(5);
	private JLabel lblTotalCost = new JLabel("Số giờ khám");
	private JTextField txtTotalCost = new JTextField(10); 
	
	public PrescribingForm() {
		super();
		createPrescribingInput();
		setSize(1000, 400);
		setIconifiable(true);
		setClosable(true);
		this.setTitle("Bảng kê thuốc và chi phí bệnh nhân");
		this.setVisible(true);
		pack();
	}
	
	public void createPrescribingInput(){
		JPanel prescribingPanel = new JPanel(new GridBagLayout());
		prescribingPanel.setPreferredSize(new Dimension(950, 150));
		GridBagConstraints constraints = new GridBagConstraints();
		prescribingPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		constraints.anchor = GridBagConstraints.WEST;
		//constraints.gridwidth = 0;
		//constraints.weightx = 0;
		//constraints.weighty = 0;
		constraints.gridx = 0;
		constraints.gridy = 0;
		prescribingPanel.add(lblName,constraints);
		//constraints.anchor = GridBagConstraints.NORTH;
		//constraints.gridwidth = 5;
		//constraints.weightx = 1;
		//constraints.weighty = 1;
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		txtName.setMinimumSize(txtName.getPreferredSize());
		prescribingPanel.add(txtName,constraints);
		
		prescribingPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Kê Toa"));
		
		add(prescribingPanel);
		
		
	}
	
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
	public void createPrescribingInput1(){
		JPanel pane = new JPanel(new GridBagLayout());
		pane.setPreferredSize(new Dimension(950, 150));
		JButton button;
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		if (shouldFill) {
		                //natural height, maximum width
		                c.fill = GridBagConstraints.HORIZONTAL;
		}

		button = new JButton("Button 1");
		if (shouldWeightX) {
		                   c.weightx = 0.5;
		}
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		pane.add(button, c);

		button = new JButton("Button 2");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		pane.add(button, c);

		button = new JButton("Button 3");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		pane.add(button, c);

		button = new JButton("Long-Named Button 4");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40;      //make this component tall
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
		pane.add(button, c);

		button = new JButton("5");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;       //reset to default
		c.weighty = 1.0;   //request any extra vertical space
		c.anchor = GridBagConstraints.PAGE_END; //bottom of space
		c.insets = new Insets(10,0,0,0);  //top padding
		c.gridx = 1;       //aligned with button 2
		c.gridwidth = 2;   //2 columns wide
		c.gridy = 2;       //third row
		pane.add(button, c);
		
		add(pane);
	}

}
