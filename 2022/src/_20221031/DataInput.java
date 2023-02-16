package _20221031;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class DataInput extends JPanel {
	JLabel nameLabel, ageLabel, jobLabel;
	static JTextField nameField, ageField, jobField;
	static JButton inputButton, cancelButton;
	TitledBorder border;
	DataTable dataTable;
	
	DataInput() {
		setLayout(null);
		
		border = new TitledBorder("입력");
		setBorder(border);
		
		nameLabel = new JLabel("이름");
		nameLabel.setBounds(30,30,30,20);
		ageLabel = new JLabel("나이");
		ageLabel.setBounds(30,80,30,20);
		jobLabel = new JLabel("직업");
		jobLabel.setBounds(30,130,30,20);
		
		nameField = new JTextField();
		nameField.setBounds(70,29,90,30);
		ageField = new JTextField();
		ageField.setBounds(70,79,90,30);
		jobField = new JTextField();
		jobField.setBounds(70,129,90,30);
		
		inputButton = new JButton("입력");
		inputButton.setBounds(30,180,60,30);
		inputButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (nameField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "이름입력!!");
					nameField.requestFocus();
					return;
				}
				if (ageField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "나이입력!!");
					ageField.requestFocus();
					return;
				}
				if (jobField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "직업입력!!");
					jobField.requestFocus();
					return;
				}
				
				if (inputButton.getText() == "입력") {
					String[] data = {nameField.getText(), ageField.getText(), jobField.getText()};
					DataTable.dtm.addRow(data);
					nameField.setText("");
					ageField.setText("");
					jobField.setText("");
					nameField.requestFocus();
				}
				else if (inputButton.getText() == "수정") {
					DataTable.dtm.setValueAt(nameField.getText(), DataTable.srow, 0);
					DataTable.dtm.setValueAt(ageField.getText(), DataTable.srow, 1);
					DataTable.dtm.setValueAt(jobField.getText(), DataTable.srow, 2);
					JTableOneForm.topLabel.setText("이름:" + DataTable.table.getValueAt(DataTable.srow, 0) +
						", 나이:" + DataTable.table.getValueAt(DataTable.srow, 1) +
						", 직업:" + DataTable.table.getValueAt(DataTable.srow, 2));
				}
				
			}
		});
		cancelButton = new JButton("취소");
		cancelButton.setBounds(100,180,60,30);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nameField.setText("");
				ageField.setText("");
				jobField.setText("");
				nameField.requestFocus();
			}
		});
		
		add(nameLabel);
		add(ageLabel);
		add(jobLabel);
		add(nameField);
		add(ageField);
		add(jobField);
		add(inputButton);
		add(cancelButton);
		
		setSize(200,600);
		//setVisible(true);
	}
}
