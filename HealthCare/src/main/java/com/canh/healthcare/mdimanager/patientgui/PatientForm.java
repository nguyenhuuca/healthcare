package com.canh.healthcare.mdimanager.patientgui;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.canh.healthcare.domain.impl.PatientBusinessImpl;
import com.canh.healthcare.domain.interfaces.PatientBusiness;
import com.canh.healthcare.mdimanager.utils.DateLabelFormatter;
import com.canh.healthcare.model.PatientDto;

public class PatientForm extends JInternalFrame implements ActionListener {

	// private static final int BORDER = 12; // Window border in pixels.
	// private static final int GAP = 5; // Default gap btwn components.

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblId = new JLabel("Id bệnh nhân:");
	private JLabel lblName = new JLabel("Tên bệnh nhân:");
	private JTextField txtId = new JTextField("auto", 10);
	private JTextField txtName = new JTextField("test", 20);
	private JLabel lblBirthDay = new JLabel("Năm sinh:");
	private JTextField txtBirthDate = new JTextField(10);
	private JLabel lblGender = new JLabel("Giới tính:");
	private JTextField txtGender = new JTextField(10);
	private JComboBox<String> cbxGender = new JComboBox<String>();
	private JLabel lblFirstDateJoin = new JLabel("Ngày khám ĐT:");
	private JTextField txtFirstDateJoin = new JTextField(10);
	private JLabel lblAddress = new JLabel("Địa chỉ:");
	private JTextField txtAddress = new JTextField(30);
	private JLabel lblMobile = new JLabel("SĐT:");
	private JTextField txtMobile = new JTextField(10);
	private JLabel lblFamilyContact = new JLabel("Người thân:");
	private JTextField txtFamilyContact = new JTextField(20);
	private JLabel lblUrgentContact = new JLabel("LHKC:");
	private JTextField txtUrgent = new JTextField(20);
	private JButton btnNewPatient = new JButton("Tạo mới");
	JDatePanelImpl datePanelFirstDateJoin;
	JDatePickerImpl datePickerFirstDateJoin;

	// create control for list area
	private JLabel lblIdSearch = new JLabel("Nhập tên:");
	private JTextField txtSearch = new JTextField(10);
	private JButton btnSearch = new JButton("Tìm");

	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	PatientBusiness patientBusiness = new PatientBusinessImpl();

	public PatientForm() {
		super();
		createInputForm();
		createListPatient();
		setSize(1000, 400);
		// setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		// setResizable(true);
		this.setTitle("Thông tin bệnh nhân");
		this.setVisible(true);
		// setLocationRelativeTo(null);
		pack();
	}

	public void createInputForm() {
		JPanel newPanel = new JPanel(new GridBagLayout());
		newPanel.setPreferredSize(new Dimension(950, 150));
		// newPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		/*
		 * GBHelper pos = new GBHelper(); newPanel.add(lblId, pos);
		 * newPanel.add(new Gap(GAP), pos.nextCol()); newPanel.add(txtId,
		 * pos.nextCol());
		 */
		// constraints.insets = new Insets(5, 10, 5, 10);
		constraints.weightx = 0;
		constraints.weighty = 0;
		constraints.fill = GridBagConstraints.VERTICAL;
		// add components to the panel

		constraints.gridx = 0;
		constraints.gridy = 0;
		// constraints.weightx = 0.5;
		newPanel.add(lblId, constraints);
		constraints.gridx = 1;
		txtId.setMinimumSize(txtId.getPreferredSize());
		txtId.setEditable(false);
		newPanel.add(txtId, constraints);
		constraints.gridx = 2;
		// constraints.gridy = 1;
		newPanel.add(lblName, constraints);
		constraints.gridx = 3;
		txtName.setMinimumSize(txtName.getPreferredSize());
		newPanel.add(txtName, constraints);
		constraints.gridx = 4;
		lblBirthDay.setMinimumSize(lblBirthDay.getPreferredSize());
		newPanel.add(lblBirthDay, constraints);
		constraints.gridx = 5;
		txtBirthDate.setMinimumSize(txtBirthDate.getPreferredSize());
		newPanel.add(txtBirthDate, constraints);
		//
		constraints.gridx = 0;
		constraints.gridy = 1;
		newPanel.add(lblGender, constraints);
		constraints.gridx = 1;
		// txtGender.setMinimumSize(txtGender.getPreferredSize());
		// newPanel.add(txtGender, constraints);
		cbxGender.setPreferredSize(new Dimension(100, 25));
		cbxGender.addItem("Nam");
		cbxGender.addItem("Nữ");
		newPanel.add(cbxGender, constraints);
		constraints.gridx = 2;
		newPanel.add(lblFirstDateJoin, constraints);
		constraints.gridx = 3;
		// txtFirstDateJoin.setMinimumSize(txtFirstDateJoin.getPreferredSize());
		// newPanel.add(txtFirstDateJoin, constraints);
		UtilDateModel modelDate = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanelFirstDateJoin = new JDatePanelImpl(modelDate, p);
		datePickerFirstDateJoin = new JDatePickerImpl(datePanelFirstDateJoin, new DateLabelFormatter());
		newPanel.add(datePickerFirstDateJoin, constraints);
		constraints.gridx = 4;
		// constraints.gridy = 1;
		newPanel.add(lblAddress, constraints);
		constraints.gridx = 5;
		txtAddress.setMinimumSize(txtAddress.getPreferredSize());
		newPanel.add(txtAddress, constraints);
		//

		//
		constraints.gridx = 0;
		constraints.gridy = 2;
		newPanel.add(lblMobile, constraints);
		constraints.gridx = 1;
		txtMobile.setMinimumSize(txtMobile.getPreferredSize());
		newPanel.add(txtMobile, constraints);
		constraints.gridx = 2;
		newPanel.add(lblFamilyContact, constraints);
		constraints.gridx = 3;
		txtFamilyContact.setMinimumSize(txtFamilyContact.getPreferredSize());
		newPanel.add(txtFamilyContact, constraints);
		constraints.gridx = 4;
		// constraints.gridy = 1;
		newPanel.add(lblUrgentContact, constraints);
		constraints.gridx = 5;
		txtUrgent.setMinimumSize(txtUrgent.getPreferredSize());
		newPanel.add(txtUrgent, constraints);
		//

		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 6;
		constraints.anchor = GridBagConstraints.CENTER;
		btnNewPatient.setActionCommand("NewPatient");
		btnNewPatient.addActionListener(this);
		newPanel.add(btnNewPatient, constraints);

		// set border for the panel
		newPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Thông tin bệnh nhân"));

		// add the panel to this frame

		// newPanel.setSize(950,200);
		add(newPanel);
		// pack();

	}

	public void createListPatient() {
		JPanel pnlListPatient = new JPanel(new GridBagLayout());
		pnlListPatient.setPreferredSize(new Dimension(950, 200));
		pnlListPatient.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Danh sách"));
		pnlListPatient.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		GridBagConstraints setup = new GridBagConstraints();
		Object columnNames[] = { "Id", "Tên bệnh nhân", "Năm sinh", "Giới tính", "Ngày khám ĐT", "Địa chỉ", "SĐT",
				"Người thân", "LHKC" };
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
		// populateJtable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		setup.anchor = GridBagConstraints.WEST;
		setup.gridwidth = 1;
		setup.weightx = 0;
		setup.weighty = 0;

		setup.gridx = 0;
		setup.gridy = 0;
		pnlListPatient.add(lblIdSearch, setup);
		setup.gridx = 1;
		setup.gridwidth = 1;
		txtSearch.setMinimumSize(txtSearch.getPreferredSize());
		pnlListPatient.add(txtSearch, setup);
		setup.gridx = 2;
		setup.gridwidth = 4;
		setup.fill = GridBagConstraints.WEST;

		btnSearch.setActionCommand("SeachPatient");
		btnSearch.addActionListener(this);
		pnlListPatient.add(btnSearch, setup);

		setup.fill = GridBagConstraints.BOTH;
		setup.weightx = 1;
		setup.weighty = 1;
		// setup.fill = GridBagConstraints.VERTICAL;
		setup.gridx = 0;
		setup.gridy = 1;
		setup.gridwidth = 6;
		pnlListPatient.add(scrollPane, setup);
		pnlListPatient.setSize(300, 150);
		pnlListPatient.setVisible(true);
		add(pnlListPatient, BorderLayout.AFTER_LAST_LINE);
		// pnlListPatient.setVisible(true);
	}

	public void createNewPatient() {
		PatientDto patient = new PatientDto();
		patient.setAddress(txtAddress.getText());
		patient.setBirthDay(txtBirthDate.getText());
		patient.setFamilyContact(txtFamilyContact.getText());
		patient.setFirstDateJoin((Date) datePickerFirstDateJoin.getModel().getValue());
		boolean male = cbxGender.getSelectedItem().toString().equals("Nam") ? true : false;
		patient.setMale(male);
		patient.setMobile(txtMobile.getText());
		patient.setName(txtName.getText());
		patient.setUrgentContact(txtUrgent.getText());
		validatePatient(patient);
		patientBusiness.create(patient);
	}

	public void populateJtable(DefaultTableModel model, List<PatientDto> patientDtoLst) {
		// patientDtoLst.add(patientDto);
		List<Object[]> ar = new ArrayList<Object[]>();
		for (int i = 0; i < patientDtoLst.size(); i++) {
			int id = patientDtoLst.get(i).getId();
			String name = patientDtoLst.get(i).getName();
			String birthDay = patientDtoLst.get(i).getBirthDay();
			boolean male = patientDtoLst.get(i).isMale();
			Date firstDate = patientDtoLst.get(i).getFirstDateJoin();
			String address = patientDtoLst.get(i).getAddress();
			String mobile = patientDtoLst.get(i).getMobile();
			String familyContact = patientDtoLst.get(i).getFamilyContact();
			String urgentContact = patientDtoLst.get(i).getUrgentContact();

			Object[] row = { id, name, birthDay, male, firstDate, address, mobile, familyContact, urgentContact };
			ar.add(row);
		}

		for (int i = 0; i < ar.size(); i++) {
			model.addRow(ar.get(i));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "NewPatient":
			try {
				createNewPatient();
				JOptionPane.showMessageDialog(null, "Tạo thành công");
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}

			break;
		case "SeachPatient":
			((DefaultTableModel) table.getModel()).setRowCount(0);
			List<PatientDto> patientDtoLst = patientBusiness.searchByName(txtSearch.getText());
			populateJtable(model, patientDtoLst);
			break;

		}

		/*
		 * if (e.getSource() == btnNewPatient) {
		 * 
		 * }
		 */

	}

	public void validatePatient(PatientDto patientDto) {
		if (patientDto.getMobile().toString().isEmpty()) {
			throw new IllegalArgumentException("Vui lòng nhập số điện thoại");
		}
		if (patientDto.getName().trim().toString().isEmpty()) {
			throw new IllegalArgumentException("Vui lòng nhập họ tên");
		}
		if (patientDto.getFirstDateJoin().toString().isEmpty()) {
			throw new IllegalArgumentException("Vui lòng nhập ngày vào");

		}
	}
}
