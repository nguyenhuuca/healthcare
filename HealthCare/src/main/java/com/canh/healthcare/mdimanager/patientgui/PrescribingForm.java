package com.canh.healthcare.mdimanager.patientgui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.canh.healthcare.domain.impl.MedicineBusinessImpl;
import com.canh.healthcare.domain.impl.PatientBillBusinessImpl;
import com.canh.healthcare.domain.impl.PatientBusinessImpl;
import com.canh.healthcare.domain.interfaces.MedicineBusiness;
import com.canh.healthcare.domain.interfaces.PatientBillBusiness;
import com.canh.healthcare.domain.interfaces.PatientBusiness;
import com.canh.healthcare.mdimanager.utils.DateLabelFormatter;
import com.canh.healthcare.model.MedicineDto;
import com.canh.healthcare.model.PatientBillDetailsDto;
import com.canh.healthcare.model.PatientBillDto;
import com.canh.healthcare.model.PatientDto;
import com.canh.healthcare.model.PatientRecordDto;

public class PrescribingForm extends JInternalFrame implements ActionListener, PropertyChangeListener {

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
	private JLabel lblMobile = new JLabel("Số điện thoại");
	private JTextField txtMobile = new JTextField(10);

	private JLabel lblExamination = new JLabel("Ngày khám");
	private JTextField txtExamination = new JTextField(10);
	private JLabel lblReExamination = new JLabel("Ngày tái khám");
	private JTextField txtReExamination = new JTextField(10);
	private JLabel lblPriceExamination = new JLabel("Tiền khám");
	private JTextField txtPriceExamination = new JTextField("0", 10);
	private JLabel lblHourExamination = new JLabel("Số giờ khám");
	private JTextField txtHourExamination = new JTextField("0", 5);
	private JLabel lblTotalExaminationCost = new JLabel("Tổng tiền khám");
	private JFormattedTextField fmtTotalExaminationCost;
	private JTextField txtTotalExaminationCost = new JTextField("0", 10);
	private JLabel lblTotalMedicineCost = new JLabel("Tiền thuốc");
	private JTextField txtTotalMedicineCost = new JTextField("0", 10);
	private JLabel lblTotalCost = new JLabel("Thành tiền");
	private JTextField txtTotalCost = new JTextField("0", 10);
	private JButton btnConfirmPatient = new JButton("Ok");
	private JButton btnUpdatePrescribing = new JButton("Cập nhật");
	private JButton btnSavePrescribing = new JButton("Lưu toa");

	JLabel lblNameMedical = new JLabel("Tên thuốc:");
	JComboBox<MedicineDto> cbxMedical = new JComboBox<MedicineDto>();
	JLabel lblQuantity = new JLabel("Số lượng");
	JTextField txtQuantity = new JTextField("1", 5);
	JButton btnAdd = new JButton("Xác nhận");

	JDatePanelImpl datePanelExaminationDate;
	JDatePickerImpl datePickerExaminationDate;
	JDatePanelImpl datePanelReExaminationDate;
	JDatePickerImpl datePickerReExaminationDate;

	MedicineBusiness medicineBusiness = new MedicineBusinessImpl();
	PatientBusiness patientBusiness = new PatientBusinessImpl();
	PatientBillBusiness patientBillBusiness = new PatientBillBusinessImpl();
	JTable tablePrescribing = new JTable();
	DefaultTableModel modelPrescribing = new DefaultTableModel();

	// Formats to format and parse numbers
	private NumberFormat amountFormat;
	private NumberFormat percentFormat;
	private NumberFormat paymentFormat;

	// Values for the fields
	private long amount = 100000;

	// hold date
	PatientDto patientDto = new PatientDto();
	// PatientRecordDto patientRecordDto = new PatientRecordDto();
	// PatientBillDto patientBillDto = new PatientBillDto();
	List<MedicineDto> medicineDtoLst = new ArrayList<MedicineDto>();
	List<PatientBillDto> patientBillDtoLst = new ArrayList<PatientBillDto>();
	List<PatientRecordDto> patientRecordDtoList = new ArrayList<PatientRecordDto>();
	List<PatientBillDetailsDto> patientBillDetailsDtoLst = new ArrayList<PatientBillDetailsDto>();

	public PrescribingForm() {
		super();
		setUpFormats();
		createPrescribingInput();
		createPrescribingArea();
		createPrescribingList();
		setSize(1000, 700);
		// setPreferredSize(new Dimension(1000, 400));
		setIconifiable(true);
		setClosable(true);
		this.setTitle("Bảng kê thuốc và chi phí bệnh nhân");
		this.setVisible(true);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				txtPriceExamination.requestFocus();
			}
		});
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
		prescribingPanel.add(lblMobile, constraints);

		constraints.gridx = 1;
		txtMobile.setMinimumSize(txtMobile.getPreferredSize());
		txtMobile.setForeground(Color.GRAY);
		txtMobile.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (txtMobile.getText().isEmpty()) {
					txtMobile.setText("Nhập để tìm");
					txtMobile.setForeground(Color.GRAY);
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				if (txtMobile.getText().equals("Nhập để tìm")) {
					txtMobile.setForeground(Color.BLACK);
					txtMobile.setText("");
				}
			}
		});
		prescribingPanel.add(txtMobile, constraints);

		constraints.gridx = 2;
		prescribingPanel.add(lblName, constraints);
		constraints.gridx = 3;
		txtName.setMinimumSize(txtName.getPreferredSize());
		prescribingPanel.add(txtName, constraints);

		constraints.gridx = 4;
		prescribingPanel.add(lblBirthDay, constraints);

		constraints.gridx = 5;
		txtBirthDate.setMinimumSize(txtBirthDate.getPreferredSize());
		prescribingPanel.add(txtBirthDate, constraints);

		// row 2
		constraints.gridx = 0;
		constraints.gridy = 1;
		prescribingPanel.add(lblId, constraints);

		constraints.gridx = 1;
		txtId.setMinimumSize(txtId.getPreferredSize());
		prescribingPanel.add(txtId, constraints);

		constraints.gridx = 2;
		prescribingPanel.add(lblGender, constraints);

		constraints.gridx = 3;
		cbxGender.setPreferredSize(new Dimension(100, 25));
		cbxGender.addItem("");
		cbxGender.addItem("Nam");
		cbxGender.addItem("Nữ");
		prescribingPanel.add(cbxGender, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 6;
		// constraints.insets = new Insets(20,20,20,20);
		constraints.anchor = GridBagConstraints.CENTER;
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
		prescribingArea.setPreferredSize(new Dimension(800, 130));
		prescribingArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		// row 1
		Insets insets = prescribingArea.getInsets();
		Dimension size = lblExamination.getPreferredSize();
		int marginLeft = 25 + insets.left;
		int margintTop = 25 + insets.top;
		int width = size.width;
		int height = size.height;
		lblExamination.setBounds(marginLeft, margintTop, width, height);
		prescribingArea.add(lblExamination);

		UtilDateModel examinationDate = new UtilDateModel();
		UtilDateModel reExaminationDate = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanelExaminationDate = new JDatePanelImpl(examinationDate, p);
		datePickerExaminationDate = new JDatePickerImpl(datePanelExaminationDate, new DateLabelFormatter());
		datePanelReExaminationDate = new JDatePanelImpl(reExaminationDate, p);
		datePickerReExaminationDate = new JDatePickerImpl(datePanelReExaminationDate, new DateLabelFormatter());

		size = datePickerExaminationDate.getPreferredSize();
		marginLeft += width;
		width = size.width;
		height = size.height;
		datePickerExaminationDate.setBounds(marginLeft, insets.top + 20, width, height);
		prescribingArea.add(datePickerExaminationDate);

		size = lblReExamination.getPreferredSize();
		marginLeft += width;
		width = size.width;
		height = size.height;
		lblReExamination.setBounds(marginLeft, margintTop, width, height);
		prescribingArea.add(lblReExamination);

		size = datePickerReExaminationDate.getPreferredSize();
		marginLeft += width;
		width = size.width;
		height = size.height;
		datePickerReExaminationDate.setBounds(marginLeft, insets.top + 20, width, height);
		prescribingArea.add(datePickerReExaminationDate);

		size = btnSavePrescribing.getPreferredSize();
		marginLeft += width + 50;
		width = size.width;
		height = size.height;
		btnSavePrescribing.setActionCommand("SavePrescribing");
		btnSavePrescribing.addActionListener(this);
		btnSavePrescribing.setBounds(marginLeft, insets.top + 20, width, height);
		prescribingArea.add(btnSavePrescribing);

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

		size = lblTotalExaminationCost.getPreferredSize();
		marginLeft += width;
		width = size.width;
		height = size.height;
		lblTotalExaminationCost.setBounds(marginLeft, margintTop, width, height);
		prescribingArea.add(lblTotalExaminationCost);

		fmtTotalExaminationCost = new JFormattedTextField(amountFormat);
		fmtTotalExaminationCost.setColumns(10);
		fmtTotalExaminationCost.setValue(new Double(amount));
		fmtTotalExaminationCost.addPropertyChangeListener("value", this);
		size = fmtTotalExaminationCost.getPreferredSize();
		marginLeft += width;
		width = size.width;
		height = size.height;
		fmtTotalExaminationCost.setBounds(marginLeft, insets.top + 50, width, height);
		prescribingArea.add(fmtTotalExaminationCost);

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
		txtTotalCost.setEditable(false);
		prescribingArea.add(txtTotalCost);

		// row 3
		cbxMedical.setPreferredSize(new Dimension(250, 25));
		insets = prescribingArea.getInsets();
		size = lblNameMedical.getPreferredSize();
		marginLeft = 25 + insets.left;
		margintTop = 85 + insets.top;
		width = size.width;
		height = size.height;
		lblNameMedical.setBounds(marginLeft, margintTop, width, height);
		size = cbxMedical.getPreferredSize();
		marginLeft += width;
		width = size.width;
		height = size.height;
		cbxMedical.setBounds(marginLeft, 80 + insets.top, width, height);
		size = lblQuantity.getPreferredSize();
		marginLeft += width;
		width = size.width;
		height = size.height;
		lblQuantity.setBounds(marginLeft, margintTop, width, height);

		size = txtQuantity.getPreferredSize();
		marginLeft += width;
		width = size.width;
		height = size.height;
		txtQuantity.setBounds(marginLeft, 80 + insets.top, width, height);

		size = btnAdd.getPreferredSize();
		marginLeft += width;
		width = size.width;
		height = size.height;
		btnAdd.setBounds(marginLeft, 80 + insets.top, width, height);
		btnAdd.setActionCommand("addMedicine");
		btnAdd.addActionListener(this);

		List<MedicineDto> medicineDtoList = medicineBusiness.findAll();
		for (MedicineDto medicieDto : medicineDtoList) {
			cbxMedical.addItem(medicieDto);
		}

		size = lblTotalMedicineCost.getPreferredSize();
		marginLeft += width + 20;
		width = size.width;
		height = size.height;
		lblTotalMedicineCost.setBounds(marginLeft, margintTop, width, height);

		size = txtTotalMedicineCost.getPreferredSize();
		marginLeft += width;
		width = size.width;
		height = size.height;
		txtTotalMedicineCost.setBounds(marginLeft, insets.top + 80, width, height);
		txtTotalMedicineCost.setEditable(false);

		prescribingArea.add(lblNameMedical);
		prescribingArea.add(cbxMedical);
		prescribingArea.add(lblQuantity);
		prescribingArea.add(txtQuantity);
		prescribingArea.add(btnAdd);
		prescribingArea.add(lblTotalMedicineCost);
		prescribingArea.add(txtTotalMedicineCost);

		prescribingArea.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Kê toa"));
		add(prescribingArea, BorderLayout.WEST);
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
		// Object columnNames[] = { "Id", "Tên thuốc", "Số lượng", "Thành tiền"
		// };
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
		cbxGender.setSelectedItem(patientDto.isMale() == true ? "Nam" : "Nữ");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "addMedicine":
			MedicineDto medicineDto = (MedicineDto) cbxMedical.getSelectedItem();
			medicineDto.setQuantity(Integer.parseInt(txtQuantity.getText()));
			medicineDtoLst.add(medicineDto);
			PatientBillDetailsDto patientBillDetailsDto = new PatientBillDetailsDto();
			patientBillDetailsDto.setMedicine(medicineDto);
			patientBillDetailsDto.setQuantity(Integer.parseInt(txtQuantity.getText()));
			patientBillDetailsDtoLst.add(patientBillDetailsDto);
			long totalMedicineCost = Long.parseLong(txtTotalMedicineCost.getText());
			totalMedicineCost += medicineDto.getTotaCost();
			txtTotalMedicineCost.setText(String.valueOf(totalMedicineCost));
			long totalExaminationCost = amount;
			long totalCost = totalMedicineCost + totalExaminationCost;
			txtTotalCost.setText(String.valueOf(totalCost));
			populateJtable(modelPrescribing, medicineDto);
			// JOptionPane.showMessageDialog(null, "Tạo thành công");
			break;
		case "ConfirmPatient":
			int idPatient = Integer.parseInt(txtId.getText().toString());
			patientDto = patientBusiness.searchPatientByMobile(txtMobile.getText());
			populateDateForPatientGroup(patientDto);
			break;
		case "SavePrescribing":
			// save patient record
			try {
				validateItem();
				PatientRecordDto patientRecordDto = new PatientRecordDto();
				patientRecordDto.setDateCome((Date) datePickerExaminationDate.getModel().getValue());
				patientRecordDto.setExaminationDay((Date) datePickerExaminationDate.getModel().getValue());
				patientRecordDto.setReExamminatioDate((Date) datePickerReExaminationDate.getModel().getValue());
				patientRecordDto.setTotalCost(Long.parseLong(txtTotalCost.getText()));
				patientRecordDto.setTotalHour(Integer.parseInt(txtHourExamination.getText()));
				patientRecordDto.setExaminationCost(amount);
				patientRecordDtoList.add(patientRecordDto);
				// save Pateint Bill
				PatientBillDto patientBillDto = new PatientBillDto();
				patientBillDto.setCreateDate(((Date) datePickerExaminationDate.getModel().getValue()));
				patientBillDto.setPatientBillDetails(patientBillDetailsDtoLst);
				patientBillDto.setPatient(patientDto);
				patientBillDtoLst.add(patientBillDto);
				patientDto.setPatientBill(patientBillDtoLst);
				patientDto.setPattientRecords(patientRecordDtoList);
				// patientBusiness.update(patientDto);
				patientBillBusiness.create(patientBillDto, patientDto);

			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}

			break;

		}

	}

	public boolean validateItem() {
		boolean vaild = true;
		if (txtHourExamination.getText().isEmpty()) {
			vaild = false;
			throw new IllegalArgumentException("Vui lòng nhập số giờ khám");

		}
		if (datePickerExaminationDate.getModel().getValue() == null
				|| datePickerExaminationDate.getModel().getValue().toString().isEmpty()) {
			vaild = false;
			throw new IllegalArgumentException("Vui lòng nhâm ngày khám");
		}
		if (datePickerReExaminationDate.getModel().getValue() == null
				|| datePickerReExaminationDate.getModel().getValue().toString().isEmpty()) {
			vaild = false;
			throw new IllegalArgumentException("Vui lòng nhâm ngày tái khám");

		}
		if (txtTotalExaminationCost.getText().isEmpty()) {
			throw new IllegalArgumentException("Vui lòng nhập tiền khám");
		}

		if (txtTotalMedicineCost.getText().isEmpty()) {
			throw new IllegalArgumentException("Vui lòng nhập tiền thuốc");
		}

		if (txtTotalCost.getText().isEmpty()) {
			throw new IllegalArgumentException("Vui lòng nhập thành tiền");
		}

		if (medicineDtoLst.size() == 0) {
			throw new IllegalArgumentException("Vui lòng kê thuốc");
		}
		return vaild;
	}

	/*
	 * public void initForm() { // Listen for changes in the text
	 * txtTotalExaminationCost.getDocument().addDocumentListener(new
	 * DocumentListener() { public void changedUpdate(DocumentEvent e) { warn(); }
	 * public void removeUpdate(DocumentEvent e) { warn(); } public void
	 * insertUpdate(DocumentEvent e) { warn(); }
	 * 
	 * public void warn() { if
	 * (Integer.parseInt(txtTotalExaminationCost.getText())<=0){
	 * JOptionPane.showMessageDialog(null,
	 * "Error: Please enter number bigger than 0", "Error Massage",
	 * JOptionPane.ERROR_MESSAGE); } } }); }
	 */
	// Create and set up number formats. These objects also
	// parse numbers input by user.
	private void setUpFormats() {
		amountFormat = NumberFormat.getNumberInstance();

		percentFormat = NumberFormat.getNumberInstance();
		percentFormat.setMinimumFractionDigits(3);

		paymentFormat = NumberFormat.getCurrencyInstance();
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		Object source = e.getSource();
		if (source == fmtTotalExaminationCost) {
			amount = ((Number) fmtTotalExaminationCost.getValue()).longValue();
		}

	}

}
