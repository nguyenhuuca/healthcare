package com.canh.healthcare.mdimanager;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import com.canh.healthcare.mdimanager.patientgui.PatientForm;

// Referenced from http://www.javaworld.com/javaworld/jw-05-2001/jw-0525-mdi.html

public class HealthCareMain extends JFrame {
	private MDIDesktopPane desktop = new MDIDesktopPane();

	private JMenuBar menuBar = new JMenuBar();

	private JMenu fileMenu = new JMenu("Bệnh Nhân");
	
	private JMenu medicalMenu = new JMenu("Quản Lý Thuốc");

	private JMenuItem newMenu = new JMenuItem("New");

	private JScrollPane scrollPane = new JScrollPane();

	public HealthCareMain() {
		setLocationRelativeTo(null);
		menuBar.add(fileMenu);
		menuBar.add(medicalMenu);
		menuBar.add(new WindowMenu(desktop));
		fileMenu.add(newMenu);
		setJMenuBar(menuBar);
		setTitle("HealthCare Anh Thy");
		scrollPane.getViewport().add(desktop);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		newMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				desktop.add(new PatientForm());
			}
		});

	}

}
