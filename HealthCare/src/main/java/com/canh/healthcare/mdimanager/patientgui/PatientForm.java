package com.canh.healthcare.mdimanager.patientgui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PatientForm extends JInternalFrame {

	private JLabel labelId = new JLabel("Id bệnh nhân");
	private JLabel labelName = new JLabel("Tên bệnh nhân");
	private JTextField textId = new JTextField("test", 20);
	private JTextField textName = new JTextField("test", 20);
	private JButton buttonLogin = new JButton("Login");

	public PatientForm() {
		super();
		JPanel newPanel = new JPanel(new GridBagLayout());
		JPanel newPanel2 = new JPanel(new GridBagLayout());


		GridBagConstraints constraints = new GridBagConstraints();
		// constraints.anchor = GridBagConstraints.WEST;
		// constraints.insets = new Insets(5, 10, 5, 10);
		// constraints.weightx=1.;
		// constraints.fill=GridBagConstraints.HORIZONTAL;

		// add components to the panel

		constraints.gridx = 0;
		constraints.gridy = 0;

		newPanel.add(labelId, constraints);

		constraints.gridx = 1;
		textId.setMinimumSize(textId.getPreferredSize());
		newPanel.add(textId, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		newPanel.add(labelName, constraints);

		constraints.gridx = 1;
		textName.setMinimumSize(textName.getPreferredSize());
		newPanel.add(textName, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		newPanel.add(buttonLogin, constraints);

		// set border for the panel
		newPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Thông tin bệnh nhân"));
		newPanel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Danh sách"));

		// add the panel to this frame
		add(newPanel);
		add(newPanel2,BorderLayout.AFTER_LAST_LINE);
		pack();
		setSize(600, 200);
		this.setVisible(true);
		// setLocationRelativeTo(null);
	}

}
