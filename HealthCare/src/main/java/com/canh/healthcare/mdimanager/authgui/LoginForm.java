package com.canh.healthcare.mdimanager.authgui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.canh.healthcare.mdimanager.utils.GUIUtils;

public class LoginForm extends JInternalFrame {

	private JLabel labelUsername = new JLabel("Enter username: ");
	private JLabel labelPassword = new JLabel("Enter password: ");
	private JTextField textUsername = new JTextField(20);
	private JPasswordField fieldPassword = new JPasswordField(20);
	private JButton buttonLogin = new JButton("Login");

	public LoginForm() {
		super("Login Form");
		textUsername.setMinimumSize(textUsername.getPreferredSize());
		fieldPassword.setMinimumSize(fieldPassword.getPreferredSize());
		setTitle("Đăng nhập hệ thống");
	    //setMaximizable(true);
	    setIconifiable(true);
	    setClosable(true);
	    //setResizable(true);

		// create a new panel with GridBagLayout manager
		JPanel newPanel = new JPanel(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		//constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);

		// add components to the panel
		constraints.gridx = 0;
		constraints.gridy = 0;
		newPanel.add(labelUsername, constraints);

		constraints.gridx = 1;
		newPanel.add(textUsername, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		newPanel.add(labelPassword, constraints);

		constraints.gridx = 1;
		newPanel.add(fieldPassword, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		newPanel.add(buttonLogin, constraints);

		// set border for the panel
		newPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Login Panel"));

		// add the panel to this frame
		add(newPanel);

		setSize(400, 200);
		setVisible(true);
		pack();
		
		//this.setVisible(true);
		//setPreferredSize(new Dimension(200, 300));
		//setMaximumSize(new Dimension(200, 300));
		//setMinimumSize(new Dimension(200, 300));
		//setLocationRelativeTo(null);
	}

}
