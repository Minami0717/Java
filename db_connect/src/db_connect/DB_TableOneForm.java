package db_connect;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class DB_TableOneForm extends JFrame {
	
	ResultSet rs = null;
	Statement stmt;
	PreparedStatement pstmt;
	static Connector connect;

	JPanel topPanel, bottomPanel;
	static JLabel topLabel;
	JButton deletebtn, exitbtn;
	DB_Input DB_Input;
	DB_Table dataTable;
	JSplitPane splitPane;
	
	DB_TableOneForm() throws SQLException {
		
		DBConnect();
		
		topPanel = new JPanel();
		topLabel = new JLabel("안녕 테이블");
		
		topLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		topPanel.add(topLabel);
		add(topPanel, BorderLayout.NORTH);
		
		bottomPanel = new JPanel();
		deletebtn = new JButton("삭제");
		deletebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (dataTable.table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "삭제할 행을 선택하세요");
					DB_Input.nameField.requestFocus();
					return;
				}
				String name = DB_Table.table.getValueAt(DB_Table.table.getSelectedRow(), 0).toString();
				int j = JOptionPane.showConfirmDialog(null, name + "님의 정보를 삭제하시겠습니까?",
						"삭제", JOptionPane.YES_NO_OPTION);
				
				if (j == 0) {
					int result = delete(name);
					if (result != 0)
						getListAll();
					
					reset();
				}
				else
					return;
			}
		});
		
		exitbtn = new JButton("종료");
		exitbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		bottomPanel.add(deletebtn);
		bottomPanel.add(exitbtn);
		add(bottomPanel, BorderLayout.SOUTH);
		
		DB_Input = new DB_Input(this);
		dataTable = new DB_Table(this);
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, DB_Input, dataTable);
		splitPane.setResizeWeight(0.9);
		splitPane.setContinuousLayout(true);
		splitPane.setOneTouchExpandable(true);
		add(splitPane);
		
		getListAll();
		
		setSize(700,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void DBConnect() {
		connect = new Connector();
	}
	
	public void getListAll() {
		try {
			dataTable.dtm.setRowCount(0);
			
			String quary = "SELECT * FROM custmer01";
			pstmt = connect.conn.prepareStatement(quary);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String name = rs.getString(1);
				String age = rs.getString(2);
				String job = rs.getString(3);
				
				String[] rowdata = {name,age,job};
				dataTable.dtm.addRow(rowdata);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int delete(String name) {
		int result = 0;
		String quary = "DELETE FROM custmer01 WHERE name = ?";
		
		try {
			pstmt = connect.conn.prepareStatement(quary);
			pstmt.setString(1, name);
			result = pstmt.executeUpdate();
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
		return result;
	}
	
	public void reset() {
		DB_Input.nameField.setText("");
		DB_Input.ageField.setText("");
		DB_Input.jobField.setText("");
		DB_Input.nameField.requestFocus();
		DB_Input.inputButton.setText("입력");
		topLabel.setText("안녕 테이블");
		DB_Input.nameField.setEnabled(true);
	}
	
	public static void main(String[] args) throws SQLException {
		new DB_TableOneForm();
	}
}
