package com.canh.healthcare.mdimanager.patientgui;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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

import com.canh.healthcare.domain.impl.MedicineBusinessImpl;
import com.canh.healthcare.domain.impl.PatientBusinessImpl;
import com.canh.healthcare.domain.interfaces.MedicineBusiness;
import com.canh.healthcare.domain.interfaces.PatientBusiness;
import com.canh.healthcare.model.MedicineDto;
import com.canh.healthcare.model.PatientDto;

public class PrescribingForm extends JInternalFrame implements ActionListener {

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
	private JLabel lblGender = new JLabel("Giới tính");
	private JTextField txtGender = new JTextField(10);
	private JComboBox<String> cbxGender = new JComboBox<String>();

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
	private JButton btnConfirmPatient = new JButton("Ok");
	private JButton btnUpdatePrescribing = new JButton("Cập nhật");

	JLabel lblNameMedical = new JLabel("Tên thuốc:");
	JComboBox<MedicineDto> cbxMedical = new JComboBox<MedicineDto>();
	JLabel lblQuantity = new JLabel("Số lượng");
	JTextField txtQuantity = new JTextField("1", 5);
	JButton btnAdd = new JButton("Xác nhận");

	MedicineBusiness medicineBusiness = new MedicineBusinessImpl();
	PatientBusiness patientBusiness = new PatientBusinessImpl();
	JTable tablePrescribing = new JTable();
	DefaultTableModel modelPrescribing = new DefaultTableModel();

	public PrescribingForm() {
		super();
		createPrescribingInput();
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
		prescribingPanel.setPreferredSize(new Dimension(800, 130));
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
		// txtGender.setMinimumSize(txtGender.getPreferredSize());
		// prescribingPanel.add(txtGender, constraints);
		cbxGender.setPreferredSize(new Dimension(100, 25));
		cbxGender.addItem("");
		cbxGender.addItem("Nam");
		cbxGender.addItem("Nữ");
		prescribingPanel.add(cbxGender, constraints);

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
		/*
		 * constraints.gridx = 0; constraints.gridy = 2;
		 * prescribingPanel.add(lblPriceExamination, constraints);
		 * 
		 * constraints.gridx = 1;
		 * txtPriceExamination.setMinimumSize(txtPriceExamination.getPreferredSize());
		 * prescribingPanel.add(txtPriceExamination, constraints);
		 * 
		 * constraints.gridx = 2; prescribingPanel.add(lblHourExamination, constraints);
		 * 
		 * constraints.gridx = 3;
		 * txtHourExamination.setMinimumSize(txtHourExamination.getPreferredSize());
		 * prescribingPanel.add(txtHourExamination, constraints);
		 * 
		 * constraints.gridx = 4; prescribingPanel.add(lblTotalCost, constraints);
		 * 
		 * constraints.gridx = 5;
		 * txtTotalCost.setMinimumSize(txtTotalCost.getPreferredSize());
		 * prescribingPanel.add(txtTotalCost, constraints);
		 */

		constraints.gridx = 2;
		constraints.gridy = 2;
		constraints.gridwidth = 6;
		// constraints.insets = new Insets(20,20,20,20);
		// constraints.anchor = GridBagConstraints.CENTER;
		btnConfirmPatient.setActionCommand("ConfirmPatient");
		btnConfirmPatient.addActionListener(this);
		prescribingPanel.add(btnConfirmPatient, constraints);
		/*
		 * constraints.gridx = 3;
		 * btnUpdatePrescribing.setActionCommand("UpdatePrescribing");
		 * prescribingPanel.add(btnUpdatePrescribing, constraints);
		 */
		prescribingPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Tổng hợp"));

		add(prescribingPanel, BorderLayout.NORTH);

	}

	public void createPrescribingArea() {
		JPanel prescribingArea = new JPanel();
		prescribingArea.setLayout(null);
		prescribingArea.setPreferredSize(new Dimension(800, 100));
		prescribingArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		cbxMedical.setPreferredSize(new Dimension(250, 25));
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
		btnAdd.setActionCommand("addMedicine");
		btnAdd.addActionListener(this);

		List<MedicineDto> medicineDtoList = medicineBusiness.findAll();
		for (MedicineDto medicieDto : medicineDtoList) {
			cbxMedical.addItem(medicieDto);
		}
		prescribingArea.add(lblNameMedical);
		prescribingArea.add(cbxMedical);
		prescribingArea.add(lblQuantity);
		prescribingArea.add(txtQuantity);
		prescribingArea.add(btnAdd);

		// row 2;
		insets = prescribingArea.getInsets();
		size = lblPriceExamination.getPreferredSize();
		marginLeft = 25 + insets.left;
		margintTop = 55 + insets.top;
		width = size.width;
		height = size.height;
		lblPriceExamination.setBounds(marginLeft, margintTop, width, height);
		prescribingArea.add(lblPriceExamination);

		size = txtPriceExamination.getPreferredSize();
		marginLeft += width;
		width = size.width;
		height = size.height;
		txtPriceExamination.setBounds(marginLeft, insets.top + 50, width, height);
		prescribingArea.add(txtPriceExamination);

		size = lblHourExamination.getPreferredSize();
		marginLeft += width;
		width = size.width;
		height = size.height;
		lblHourExamination.setBounds(marginLeft, margintTop, width, height);
		prescribingArea.add(lblHourExamination);

		size = txtHourExamination.getPreferredSize();
		marginLeft += width;
		width = size.width;
		height = size.height;
		txtHourExamination.setBounds(marginLeft, insets.top + 50, width, height);
		prescribingArea.add(txtHourExamination);

		size = lblTotalCost.getPreferredSize();
		marginLeft += width;
		width = size.width;
		height = size.height;
		lblTotalCost.setBounds(marginLeft, margintTop, width, height);
		prescribingArea.add(lblTotalCost);

		size = txtTotalCost.getPreferredSize();
		marginLeft += width;
		width = size.width;
		height = size.height;
		txtTotalCost.setBounds(marginLeft, insets.top + 50, width, height);
		prescribingArea.add(txtTotalCost);

		prescribingArea.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Kê toa"));
		add(prescribingArea, BorderLayout.CENTER);
	}

	public void createPrescribingList() {
		JPanel prescribingConsume = new JPanel();
		prescribingConsume.setLayout(null);
		prescribingConsume.setPreferredSize(new Dimension(800, 180));
		prescribingConsume.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		Object columnNames[] = { "Id", "Tên thuốc", "Số lượng", "Thành tiền" };
		modelPrescribing.setColumnIdentifiers(columnNames);
		tablePrescribing.setModel(modelPrescribing);
		// populateJtable(model);
		JScrollPane scrollPane = new JScrollPane(tablePrescribing);
		scrollPane.setPreferredSize(new Dimension(700, 150));
		Insets insets = prescribingConsume.getInsets();
		Dimension size = scrollPane.getPreferredSize();
		int marginLeft = 25 + insets.left;
		int margintTop = 25 + insets.top;
		int width = size.width;
		int height = size.height;
		scrollPane.setBounds(marginLeft, margintTop, width, height);

		prescribingConsume.add(scrollPane);
		prescribingConsume.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Chi tiết"));
		add(prescribingConsume, BorderLayout.SOUTH);
	}

	public void populateJtable(DefaultTableModel model, MedicineDto medicineDto) {
		// List<PatientDto> patientDtoLst = patientBusiness.findAll();
		// patientDtoLst.add(patientDto);
		// Object columnNames[] = { "Id", "Tên thuốc", "Số lượng", "Thành tiền" };
		List<Object[]> ar = new ArrayList<Object[]>();
		// for (int i = 0; i < patientDtoLst.size(); i++) {
		int id = medicineDto.getId();
		String name = medicineDto.getName();
		int quantity = medicineDto.getQuantity();
		Long totalCost = medicineDto.getTotaCost();
		Object[] row = { id, name, quantity, totalCost };
		ar.add(row);
		// }

		for (int i = 0; i < ar.size(); i++) {
			model.addRow(ar.get(i));
		}
	}

	public void populateDateForPatientGroup(PatientDto patientDto) {
		txtName.setText(patientDto.getName());
		txtBirthDate.setText(patientDto.getBirthDay());
		cbxGender.setSelectedItem(patientDto.isMale()==true?"Nam":"Nữ");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "addMedicine":
			MedicineDto medicineDto = (MedicineDto) cbxMedical.getSelectedItem();
			medicineDto.setQuantity(Integer.parseInt(txtQuantity.getText()));
			populateJtable(modelPrescribing, medicineDto);
			// JOptionPane.showMessageDialog(null, "Tạo thành công");
			break;
		case "ConfirmPatient":
			int idPatient = Integer.parseInt(txtId.getText().toString());
			PatientDto patientDto = patientBusiness.searchPatientById(idPatient);
			populateDateForPatientGroup(patientDto);
			break;

		}

	}
}
