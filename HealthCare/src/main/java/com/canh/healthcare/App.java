package com.canh.healthcare;

import java.awt.Dimension;

import javax.swing.UIManager;

import com.canh.healthcare.jpa.utils.EntityManagerUtil;
import com.canh.healthcare.mdimanager.HealthCareMain;

/**
 * 
 * @author canh
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			/*
			 * for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) { if
			 * ("Nimbus".equals(info.getName())) {
			 * UIManager.setLookAndFeel(info.getClassName()); break; } }
			 */
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
		}
		HealthCareMain healthCareMain = new HealthCareMain();
		Dimension d = healthCareMain.getMaximumSize();
		healthCareMain.setSize(1024, 600);
		healthCareMain.setVisible(true);
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				EntityManagerUtil.getEntityManager().close();
				System.out.println("close");
			}
		});

	}
}
