package com.canh.healthcare.mdimanager.patientgui;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PatientHistoryForm extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblId = new JLabel("Id bệnh nhân");
	private JLabel lblName = new JLabel("Tên bệnh nhân");
	private JTextField txtId = new JTextField("1", 10);
	private JTextField txtName = new JTextField("test", 20);
	private JLabel lblBirthDay = new JLabel("Năm sinh");
	private JTextField txtBirthDate = new JTextField(10);
	private JLabel lblMobile = new JLabel("Số điện thoại:");
	private JTextField txtMobile = new JTextField(10);
	private JLabel lblAddress = new JLabel("Địa chỉ:");
	private JTextField txtAddress = new JTextField(30);
	private JButton btnSearch= new JButton("Tìm kiếm");

	public PatientHistoryForm() {
		super();
		createSearchArea();
		createResultArea();
		// setSize(1000, 700);
		// setPreferredSize(new Dimension(1000, 400));
		setIconifiable(true);
		setClosable(true);
		setLayout(null);
		setPreferredSize(new Dimension(800, 400));
		this.setTitle("Lịch sử bệnh án bệnh nhân");
		pack();
	}

	public void createSearchArea() {
		JPanel searchArea = new JPanel();
		searchArea.setLayout(null);
		searchArea.setPreferredSize(new Dimension(780, 130));
		Insets insets = this.getInsets();
		Dimension size = searchArea.getPreferredSize();
		int marginLeft = insets.left;
		int margintTop = insets.top;
		int width = size.width;
		int height = size.height;
		searchArea.setBounds(marginLeft, margintTop, width, height);
		searchArea
				.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Thông tin bệnh nhân"));

		//row 1
		size = lblMobile.getPreferredSize();
		marginLeft = 20 + insets.left;
		margintTop = 25 + insets.top;
		width = size.width;
		height = size.height;
		lblMobile.setBounds(marginLeft, margintTop, width, height);
		searchArea.add(lblMobile);

		size = txtMobile.getPreferredSize();
		marginLeft += width;
		width = size.width;
		height = size.height;
		txtMobile.setBounds(marginLeft, insets.top + 20, width, height);
		searchArea.add(txtMobile);

		size = lblName.getPreferredSize();
		marginLeft += width;
		width = size.width;
		height = size.height;
		lblName.setBounds(marginLeft, margintTop, width, height);
		searchArea.add(lblName);

		size = txtName.getPreferredSize();
		marginLeft += width;
		width = size.width;
		height = size.height;
		txtName.setBounds(marginLeft, insets.top + 20, width, height);
		searchArea.add(txtName);
		
		size = lblBirthDay.getPreferredSize();
		marginLeft += width;
		width = size.width;
		height = size.height;
		lblBirthDay.setBounds(marginLeft, margintTop, width, height);
		searchArea.add(lblBirthDay);

		size = txtBirthDate.getPreferredSize();
		marginLeft += width;
		width = size.width;
		height = size.height;
		txtBirthDate.setBounds(marginLeft, insets.top + 20, width, height);
		searchArea.add(txtBirthDate);
		
		//row 2:
		size = lblAddress.getPreferredSize();
		marginLeft = 20 + insets.left;
		margintTop = 55 + insets.top;
		width = lblMobile.getWidth();
		height = size.height;
		lblAddress.setBounds(marginLeft, margintTop, width, height);
		searchArea.add(lblAddress);
		
		size = txtAddress.getPreferredSize();
		marginLeft += width;
		width = size.width;
		height = size.height;
		txtAddress.setBounds(marginLeft, insets.top + 50, width, height);
		searchArea.add(txtAddress);
		
		//row 3
		size = btnSearch.getPreferredSize();
		marginLeft = 20 + insets.left;
		margintTop = 85 + insets.top;
		width = size.width;
		height = size.height;
		btnSearch.setBounds(marginLeft, margintTop, width, height);
		searchArea.add(btnSearch);
		

		add(searchArea);
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
		
		JTable table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		Object columnNames[] = { "Ngày khám", "Ngày tái khám", "Chẩn đoán bệnh","Tổn chi phí" };
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
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
	public void actionPerformed(ActionEvent e) {

	}

}
