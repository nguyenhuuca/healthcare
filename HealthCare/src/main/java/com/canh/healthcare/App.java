package com.canh.healthcare;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * 
 * @author canh
 *
 */
public class App {
	public static void main(String[] args) {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		HealthCareMain healthCareMain = new HealthCareMain();
		healthCareMain.setSize(800, 600);
		healthCareMain.setVisible(true);
	}
}
