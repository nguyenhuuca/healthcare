package com.canh.healthcare.mdimanager.patientgui;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.canh.healthcare.domain.impl.PatientBillBusinessImpl;
import com.canh.healthcare.domain.interfaces.PatientBillBusiness;
import com.canh.healthcare.jpa.entity.PatientBill;
import com.canh.healthcare.jpa.entity.PatientBillDetails;
import com.canh.healthcare.model.PatientDto;
import com.canh.healthcare.model.PatientRecordDto;

public class MedicneBillCheckForm extends JInternalFrame implements ActionListener {
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

	PatientBillBusiness patientBillBusiness = new PatientBillBusinessImpl();
	JTable table = new JTable();
	int billId;
	PatientDto patientDto = new PatientDto();
	DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			// all cells false
			return false;
		}
	};

	public MedicneBillCheckForm(int billId, PatientDto patientDto) {
		super();
		this.billId = billId;
		this.patientDto = patientDto;
		createSearchArea();
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

		Object columnNames[] = { "Id", "Ngày khám", "Tên thuốc", "Số lượng", "Liều dùng" };
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
		populateDateForMedicineInFo(model);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setWidth(0);
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

		// row 1
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
		txtMobile.setEditable(false);
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
		txtName.setEditable(false);
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
		txtBirthDate.setEditable(false);
		txtBirthDate.setBounds(marginLeft, insets.top + 20, width, height);
		searchArea.add(txtBirthDate);

		// row 2:
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
		txtAddress.setEditable(false);
		searchArea.add(txtAddress);

		populateDataForPatientInfo();
		add(searchArea);
	}

	public void populateDataForPatientInfo() {
		txtAddress.setText(patientDto.getAddress());
		txtBirthDate.setText(patientDto.getBirthDay());
		txtMobile.setText(patientDto.getMobile());
		txtName.setText(patientDto.getName());
	}

	public void populateDateForMedicineInFo(DefaultTableModel model) {
		PatientBill patientBill = patientBillBusiness.searchPatientBillById(this.billId);
		List<Object[]> ar = new ArrayList<Object[]>();
		// Object columnNames[] = { "Id","Ngày khám", "Tên thuốc", "Số lượng", "Liều
		// dùng" };

		for (PatientBillDetails patientBillDetail : patientBill.getPatientBillDetails()) {

			int id = patientBillDetail.getMedicine().getId();
			Date examinationDate = patientBill.getCreateDate();
			String medicineName = patientBillDetail.getMedicine().getName();
			int quantity = patientBillDetail.getQuantity();
			String description = "1-1-1";
			Object[] row = { id, examinationDate, medicineName, quantity, description };
			ar.add(row);
		}

		for (int i = 0; i < ar.size(); i++) {
			model.addRow(ar.get(i));
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
