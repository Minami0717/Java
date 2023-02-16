package db_connect;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class DB_K_Del extends JFrame {
	ResultSet rs;
	PreparedStatement pstmt;
	DB_K_Menu k_Menu;
	JPanel panel;
	JLabel titleLabel, nameLabel;
	JTextField nameField;
	JButton del, menu, selectDel;
	DefaultTableModel dtm;
	JTable table;
	JScrollPane jsp;
	TitledBorder tableBorder;
	String[] colname = {"번호","이름","나이","몸무게","포지션","등번호","연고지"};
	String[][] rowdata = {};
	int srow = -1;
	
	DB_K_Del(DB_K_Menu k_Menu) {
		this.k_Menu = k_Menu;
		
		setTitle("K_League_Player");
		setLayout(null);
		
		tableBorder = new TitledBorder("테이블");
		
		panel = new JPanel();
		panel.setBounds(0, 0, 700, 40);
		panel.setBackground(Color.black);
		
		titleLabel = new JLabel("K_League_Player 선수 삭제");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel.add(titleLabel);
		
		nameLabel = new JLabel("이름");
		nameLabel.setBounds(30,100,30,20);
		nameField = new JTextField();
		nameField.setBounds(70,100,170,25);
		
		del = new JButton("삭 제");
		del.setBounds(550,95,100,35);
		del.setFont(new Font("굴림", Font.BOLD, 20));
		del.setBackground(Color.darkGray);
		del.setForeground(Color.pink);
		del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (nameField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "이름입력!!");
					nameField.requestFocus();
					return;
				}
				
				int j = JOptionPane.showConfirmDialog(null, nameField.getText() + "님의 정보를 삭제하시겠습니까?",
						"삭제", JOptionPane.YES_NO_OPTION);
				
				if (j == 0) {
					int result = selectDelete(nameField.getText());
					if (result != 0) {
						getListAll();
						nameField.setText("");
					}
				}
				else
					return;
			}
		});
		
		add(nameLabel);
		add(nameField);
		add(del);
		add(panel);
		
		dtm = new DefaultTableModel(rowdata, colname);
		table = new JTable(dtm);
		jsp = new JScrollPane(table);
		jsp.setBounds(20,200,650,400);
		jsp.setBorder(tableBorder);
		getListAll();
		add(jsp);
		
		menu = new JButton("메인메뉴");
		menu.setBounds(200,650,130,40);
		menu.setFont(new Font("굴림", Font.BOLD, 20));
		menu.setBackground(Color.blue);
		menu.setForeground(Color.magenta);
		menu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				k_Menu.show();
			}
		});
		add(menu);
		
		selectDel = new JButton("선수삭제");
		selectDel.setBounds(350,650,130,40);
		selectDel.setFont(new Font("굴림", Font.BOLD, 20));
		selectDel.setBackground(Color.orange);
		selectDel.setForeground(Color.red);
		selectDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int j = JOptionPane.showConfirmDialog(null, table.getValueAt(srow, 1).toString() + "님의 정보를 삭제하시겠습니까?",
						"삭제", JOptionPane.YES_NO_OPTION);
				
				if (j == 0) {
					int result = selectDelete(table.getValueAt(srow, 1).toString());
					if (result != 0) {
						getListAll();
						nameField.setText("");
					}
				}
				else
					return;
			}
		});
		add(selectDel);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				srow = table.getSelectedRow();
				//nameField.setText(table.getValueAt(srow, 1).toString());
			}
		});

		setSize(700,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void getListAll() {
		try {
			dtm.setRowCount(0);
			
			String quary = "SELECT * FROM player";
			pstmt = DB_K_Login.connector.conn.prepareStatement(quary);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String n = rs.getString(1);
				String name = rs.getString(2);
				String age = rs.getString(3);
				String weight = rs.getString(4);
				String pos = rs.getString(5);
				String bNum = rs.getString(6);
				String home = rs.getString(7);
				
				String[] rowdata = {n,name,age,weight,pos,bNum,home};
				dtm.addRow(rowdata);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int selectDelete(String name) {
		int result = 0;
		String quary = "DELETE FROM player WHERE name = ?";
		//String quary2 = "ALTER TABLE `player` AUTO_INCREMENT=1; SET @COUNT = 0;"
				//+ "UPDATE `player` SET idx = @COUNT:=@COUNT+1;";
		
		try {
			pstmt = DB_K_Login.connector.conn.prepareStatement(quary);
			pstmt.setString(1, name);
			result = pstmt.executeUpdate();
			//pstmt = DB_K_Login.connector.conn.prepareStatement(quary2);
			//pstmt.executeUpdate();
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
		
		JOptionPane.showMessageDialog(null, name+"선수가 삭제되었습니다.");
		return result;
	}
	
//	public static void main(String[] args) {
//		new DB_K_Del();
//	}
}
