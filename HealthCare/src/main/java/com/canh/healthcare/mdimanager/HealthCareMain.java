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

import com.canh.healthcare.mdimanager.authgui.LoginForm;
import com.canh.healthcare.mdimanager.patientgui.PatientForm;
import com.canh.healthcare.mdimanager.patientgui.PatientHistoryForm;
import com.canh.healthcare.mdimanager.patientgui.PrescribingForm;
import com.canh.healthcare.mdimanager.utils.GUIUtils;

// Referenced from http://www.javaworld.com/javaworld/jw-05-2001/jw-0525-mdi.html

public class HealthCareMain extends JFrame  {
	private MDIDesktopPane desktop = new MDIDesktopPane();

	private JMenuBar menuBar = new JMenuBar();

	private JMenu patientMenu = new JMenu("Bệnh Nhân");

	private JMenu medicalMenu = new JMenu("Quản Lý Thuốc");
	private JMenu authMenu = new JMenu("Autheticate");
	private JMenuItem loginMnuItem = new JMenuItem("Đăng Nhập");

	private JMenuItem newMenu = new JMenuItem("Tạo mới          ");
	private JMenuItem prescribingMnuItem = new JMenuItem("Kê Toa");
	private JMenuItem patientHistoryMnuItem = new JMenuItem("Tra bệnh án");
	

	private JScrollPane scrollPane = new JScrollPane();

	public HealthCareMain() {
		//setLocationRelativeTo(null);
		menuBar.add(patientMenu);
		menuBar.add(medicalMenu);
		menuBar.add(new WindowMenu(desktop));
		menuBar.add(authMenu);
		patientMenu.add(newMenu);
		patientMenu.add(prescribingMnuItem);
		patientMenu.add(patientHistoryMnuItem);
		authMenu.add(loginMnuItem);
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
				PatientForm patientForm = new PatientForm();
				desktop.add(patientForm);
				GUIUtils.centerWithinDesktop(patientForm);
			}
		});
		loginMnuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoginForm f = new LoginForm();
				desktop.add(f);;
				GUIUtils.centerWithinDesktop(f);
				//Dimension parentSize = desktop.getSize();
				//Dimension childSize = f.getSize()
				// set center screen
				//f.setLocation((parentSize.width - childSize.width) / 2, (parentSize.height - childSize.height) / 2);
				//f.setVisible(true);

			}
		});
		prescribingMnuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PrescribingForm prescribingForm = new PrescribingForm();
				desktop.add(prescribingForm);
				GUIUtils.centerWithinDesktop(prescribingForm);
			}
		});
		
		patientHistoryMnuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PatientHistoryForm patientHistoryForm = new PatientHistoryForm();
				desktop.add(patientHistoryForm);
				GUIUtils.centerWithinDesktop(patientHistoryForm);
				
			}
		});
	}
}
