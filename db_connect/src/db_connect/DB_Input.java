package db_connect;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class DB_Input extends JPanel {
	PreparedStatement pstmt;
	
	JLabel nameLabel, ageLabel, jobLabel;
	static JTextField nameField, ageField, jobField;
	static JButton inputButton, cancelButton;
	TitledBorder border;
	DB_TableOneForm form;
	
	DB_Input(DB_TableOneForm form) {
		this.form = form;
		
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
				String name = nameField.getText();
				String age = ageField.getText();
				String job = jobField.getText();
				String selectName = DB_Table.table.getValueAt(DB_Table.table.getSelectedRow(), 0).toString();

				if (name.isEmpty()) {
					JOptionPane.showMessageDialog(null, "이름입력!!");
					nameField.requestFocus();
					return;
				}
				if (age.isEmpty()) {
					JOptionPane.showMessageDialog(null, "나이입력!!");
					ageField.requestFocus();
					return;
				}
				if (job.isEmpty()) {
					JOptionPane.showMessageDialog(null, "직업입력!!");
					jobField.requestFocus();
					return;
				}
				
				if (inputButton.getText() == "입력") {
					int result = 0;
					result = insert(name, age, job);
					
					if (result != 0)
						form.getListAll();
					
					reset();
				}
				else if (inputButton.getText() == "수정") {
					int result = 0;
					result = update(age, job, selectName);
					
					if (result != 0)
						form.getListAll();
					
					DB_TableOneForm.topLabel.setText("이름:" + DB_Table.table.getValueAt(DB_Table.srow, 0) +
						", 나이:" + DB_Table.table.getValueAt(DB_Table.srow, 1) +
						", 직업:" + DB_Table.table.getValueAt(DB_Table.srow, 2));
				}
				
			}
		});
		cancelButton = new JButton("취소");
		cancelButton.setBounds(100,180,60,30);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
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
	
	public int insert(String name, String age, String job) {
		int result = 0;
		String quary = "INSERT INTO custmer01 VALUES (?,?,?)";
		
		try {
			pstmt = form.connect.conn.prepareStatement(quary);
			pstmt.setString(1, name);
			pstmt.setString(2, age);
			pstmt.setString(3, job);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
		
		return result;
	}
	
	public int update(String age, String job, String name) {
		int result = 0;
		String quary = "UPDATE custmer01 SET age = ?, job = ? WHERE name = ?";
		
		try {
			pstmt = form.connect.conn.prepareStatement(quary);
			pstmt.setString(1, age);
			pstmt.setString(2, job);
			pstmt.setString(3, name);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e2) {
			System.out.println(e2.getMessage());
		}
		
		return result;
	}
	
	public void reset() {
		nameField.setText("");
		ageField.setText("");
		jobField.setText("");
		nameField.requestFocus();
		nameField.setEnabled(true);
	}
}
