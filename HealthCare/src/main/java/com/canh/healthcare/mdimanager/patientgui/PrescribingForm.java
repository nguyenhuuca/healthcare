package com.canh.healthcare.mdimanager.patientgui;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PrescribingForm extends JInternalFrame {

	private JLabel lblId = new JLabel("Id bệnh nhân");
	private JLabel lblName = new JLabel("Tên bệnh nhân");
	private JTextField txtId = new JTextField("test", 10);
	private JTextField txtName = new JTextField("test", 20);
	private JLabel lblBirthDay = new JLabel("Năm sinh");
	private JTextField txtBirthDate = new JTextField(10);
	private JLabel lblGender = new JLabel("Giới tính");
	private JTextField txtGender = new JTextField(10);

	private JLabel lblExamination = new JLabel("Ngày khám");
	private JTextField txtExamination = new JTextField(10);
	private JLabel lblReExamination = new JLabel("Ngày khám");
	private JTextField txtReExamination = new JTextField(10);
	private JLabel lblPriceExamination = new JLabel("Tiền khám");
	private JTextField txtPriceExamination = new JTextField(10);
	private JLabel lblHourExamination = new JLabel("Số giờ khám");
	private JTextField txtHourExamination = new JTextField(5);
	private JLabel lblTotalCost = new JLabel("Tổng tiền khám");
	private JTextField txtTotalCost = new JTextField(10);
	private JButton btnNewPrescribing = new JButton("Tạo mới");
	private JButton btnUpdatePrescribing = new JButton("Cập nhật");

	public PrescribingForm() {
		super();
		createPrescribingInput();
		createPrescribingArea();
		createPrescribingArea();
		createPrescribingList();
		setSize(1000, 700);
		// setPreferredSize(new Dimension(1000, 400));
		setIconifiable(true);
		setClosable(true);
		this.setTitle("Bảng kê thuốc và chi phí bệnh nhân");
		this.setVisible(true);
		pack();
	}

	public void createPrescribingInput() {
		// DefaultFormBuilder builder = new DefaultFormBuilder(new
		// FormLayout(""));
		JPanel prescribingPanel = new JPanel(new GridBagLayout());
		prescribingPanel.setPreferredSize(new Dimension(800, 150));
		GridBagConstraints constraints = new GridBagConstraints();
		prescribingPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.VERTICAL;
		constraints.weightx = 0;
		constraints.weighty = 0;

		// row 1
		constraints.gridx = 0;
		constraints.gridy = 0;
		prescribingPanel.add(lblName, constraints);

		constraints.gridx = 1;
		txtName.setMinimumSize(txtName.getPreferredSize());
		prescribingPanel.add(txtName, constraints);

		constraints.gridx = 2;
		prescribingPanel.add(lblBirthDay, constraints);

		constraints.gridx = 3;
		txtBirthDate.setMinimumSize(txtBirthDate.getPreferredSize());
		prescribingPanel.add(txtBirthDate, constraints);

		constraints.gridx = 4;
		prescribingPanel.add(lblGender, constraints);

		constraints.gridx = 5;
		txtGender.setMinimumSize(txtGender.getPreferredSize());
		prescribingPanel.add(txtGender, constraints);

		// row 2
		constraints.gridx = 0;
		constraints.gridy = 1;
		prescribingPanel.add(lblId, constraints);

		constraints.gridx = 1;
		txtId.setMinimumSize(txtId.getPreferredSize());
		prescribingPanel.add(txtId, constraints);

		constraints.gridx = 2;
		prescribingPanel.add(lblExamination, constraints);

		constraints.gridx = 3;
		txtExamination.setMinimumSize(txtExamination.getPreferredSize());
		prescribingPanel.add(txtExamination, constraints);

		constraints.gridx = 4;
		prescribingPanel.add(lblReExamination, constraints);

		constraints.gridx = 5;
		txtReExamination.setMinimumSize(txtReExamination.getPreferredSize());
		prescribingPanel.add(txtReExamination, constraints);

		// row 3
		constraints.gridx = 0;
		constraints.gridy = 2;
		prescribingPanel.add(lblPriceExamination, constraints);

		constraints.gridx = 1;
		txtPriceExamination.setMinimumSize(txtPriceExamination.getPreferredSize());
		prescribingPanel.add(txtPriceExamination, constraints);

		constraints.gridx = 2;
		prescribingPanel.add(lblHourExamination, constraints);

		constraints.gridx = 3;
		txtHourExamination.setMinimumSize(txtHourExamination.getPreferredSize());
		prescribingPanel.add(txtHourExamination, constraints);

		constraints.gridx = 4;
		prescribingPanel.add(lblTotalCost, constraints);

		constraints.gridx = 5;
		txtTotalCost.setMinimumSize(txtTotalCost.getPreferredSize());
		prescribingPanel.add(txtTotalCost, constraints);

		constraints.gridx = 2;
		constraints.gridy = 3;
		constraints.gridwidth = 6;
		// constraints.insets = new Insets(20,20,20,20);
		// constraints.anchor = GridBagConstraints.CENTER;
		btnNewPrescribing.setActionCommand("NewPrescribing");
		prescribingPanel.add(btnNewPrescribing, constraints);
		constraints.gridx = 3;
		btnUpdatePrescribing.setActionCommand("UpdatePrescribing");
		prescribingPanel.add(btnUpdatePrescribing, constraints);
		prescribingPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Tổng hợp"));

		add(prescribingPanel, BorderLayout.NORTH);

	}

	public void createPrescribingArea() {
		JPanel prescribingArea = new JPanel();
		prescribingArea.setLayout(null);
		prescribingArea.setPreferredSize(new Dimension(800, 70));
		// GridBagConstraints constraints = new GridBagConstraints();
		prescribingArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		// constraints.anchor = GridBagConstraints.WEST;
		// constraints.fill = GridBagConstraints.VERTICAL;
		JLabel lblNameMedical = new JLabel("Tên thuốc:");
		JComboBox cbxMedical = new JComboBox();
		JLabel lblQuantity = new JLabel("Số lượng");
		JTextField txtQuantity = new JTextField(5);
		JButton btnAdd = new JButton("Xác nhận");
		cbxMedical.setPreferredSize(new Dimension(150, 25));
		Insets insets = prescribingArea.getInsets();
		Dimension size = lblNameMedical.getPreferredSize();
		int marginLeft = 25 + insets.left;
		int margintTop = 25 + insets.top;
		int width = size.width;
		int height = size.height;
		lblNameMedical.setBounds(marginLeft, margintTop, width, height);
		size = cbxMedical.getPreferredSize();
		marginLeft += width;
		width = size.width;
		height = size.height;
		cbxMedical.setBounds(marginLeft, 20 + insets.top, width, height);
		
		size = lblQuantity.getPreferredSize();
		marginLeft += width;
		width = size.width;
		height = size.height;
		lblQuantity.setBounds(marginLeft, margintTop, width, height);
		
		size = txtQuantity.getPreferredSize();
		marginLeft += width;
		width = size.width;
		height = size.height;
		txtQuantity.setBounds(marginLeft, 20 + insets.top, width, height);
		
		size = btnAdd.getPreferredSize();
		marginLeft += width;
		width = size.width;
		height = size.height;
		btnAdd.setBounds(marginLeft, 20 + insets.top, width, height);
		
		prescribingArea.add(lblNameMedical);
		prescribingArea.add(cbxMedical);
		prescribingArea.add(lblQuantity);
		prescribingArea.add(txtQuantity);
		prescribingArea.add(btnAdd);

		prescribingArea.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Kê toa"));
		add(prescribingArea, BorderLayout.CENTER);
	}

	public void createPrescribingList() {
		JPanel prescribingConsume = new JPanel();
		prescribingConsume.setLayout(null);
		prescribingConsume.setPreferredSize(new Dimension(800, 180));
		// GridBagConstraints constraints = new GridBagConstraints();
		prescribingConsume.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		// constraints.anchor = GridBagConstraints.WEST;
		// constraints.fill = GridBagConstraints.VERTICAL;
		JTable table = new JTable();
		
		DefaultTableModel model = new DefaultTableModel();
		Object columnNames[] = { "Id", "Tên thuốc", "Số lượng", "Thành tiền" };
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
		//populateJtable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(500, 150));
		Insets insets = prescribingConsume.getInsets();
		Dimension size = scrollPane.getPreferredSize();
		int marginLeft = 25 + insets.left;
		int margintTop = 25 + insets.top;
		int width = size.width;
		int height = size.height;
		scrollPane.setBounds(marginLeft,margintTop,width,height);
		
		prescribingConsume.add(scrollPane);
		prescribingConsume.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Chi tiết"));
		add(prescribingConsume, BorderLayout.SOUTH);
	}
}
