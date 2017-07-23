package com.canh.healthcare.mdimanager.patientgui;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.canh.healthcare.domain.impl.PatientBillBusinessImpl;
import com.canh.healthcare.domain.interfaces.PatientBillBusiness;
import com.canh.healthcare.jpa.entity.PatientBill;

public class MedicneBillCheckDialog extends JInternalFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PatientBillBusiness patientBillBusiness = new PatientBillBusinessImpl();
	JTable table = new JTable();
	int billId;
	DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			// all cells false
			return false;
		}
	};
	
	public MedicneBillCheckDialog(int billId) {
		super();
		this.billId = billId;
		createResultArea();
		setIconifiable(true);
		setClosable(true);
		setLayout(null);
		this.setVisible(true);
		setPreferredSize(new Dimension(800, 400));
		this.setTitle("Kiểm toa");
		pack();
	}
	
	public void createResultArea() {
		JPanel resultArea = new JPanel();
		resultArea.setLayout(null);
		resultArea.setPreferredSize(new Dimension(780, 230));
		Insets insets = this.getInsets();
		Dimension size = resultArea.getPreferredSize();
		int marginLeft = insets.left;
		int margintTop = insets.top + 130;
		int width = size.width;
		int height = size.height;
		resultArea.setBounds(marginLeft, margintTop, width, height);
		resultArea.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Kết quả tìm kiếm"));

		Object columnNames[] = { "Id","Ngày khám", "Tên thuốc", "Số lượng", "Liều dùng" };
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
		
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setWidth(0);
		PatientBill patientBill = patientBillBusiness.searchPatientBillById(this.billId);
		// populateJtable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(750, 200));
		size = scrollPane.getPreferredSize();
		marginLeft = 5 + insets.left;
		margintTop = 25 + insets.top;
		width = size.width;
		height = size.height;
		scrollPane.setBounds(marginLeft, margintTop, width, height);
		resultArea.add(scrollPane);

		add(resultArea);

	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
