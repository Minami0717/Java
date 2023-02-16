package db_connect;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

public class DB_K_Search extends JFrame {
	ResultSet rs;
	PreparedStatement pstmt;
	DB_K_Menu k_Menu;
	JPanel panel;
	JLabel titleLabel, nameLabel;
	JTextField nameField;
	JButton search, searchAll, menu;
	DefaultTableModel dtm;
	JTable table;
	JScrollPane jsp;
	TitledBorder tableBorder;
	String[] colname = {"번호","이름","나이","몸무게","포지션","등번호","연고지"};
	String[][] rowdata = {};
	String n;
	
	DB_K_Search(DB_K_Menu k_Menu) {
		this.k_Menu = k_Menu;
		
		setTitle("K_League_Player");
		setLayout(null);
		
		tableBorder = new TitledBorder("테이블");
		
		panel = new JPanel();
		panel.setBounds(0, 0, 700, 40);
		panel.setBackground(Color.black);
		
		titleLabel = new JLabel("K_League_Player 선수 검색");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel.add(titleLabel);
		
		nameLabel = new JLabel("이름");
		nameLabel.setBounds(30,100,30,20);
		nameField = new JTextField();
		nameField.setBounds(70,100,170,25);
		
		search = new JButton("검색");
		search.setBounds(400,95,100,35);
		search.setFont(new Font("굴림", Font.BOLD, 20));
		search.setBackground(Color.gray);
		search.setForeground(Color.cyan);
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				search(nameField.getText());
			}
		});

		searchAll = new JButton("전체검색");
		searchAll.setBounds(520,95,130,35);
		searchAll.setFont(new Font("굴림", Font.BOLD, 20));
		searchAll.setBackground(Color.gray);
		searchAll.setForeground(Color.cyan);
		searchAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getListAll();
			}
		});
		
		add(nameLabel);
		add(nameField);
		add(search);
		add(searchAll);
		add(panel);
		
		dtm = new DefaultTableModel(rowdata, colname);
		table = new JTable(dtm);
		jsp = new JScrollPane(table);
		jsp.setBounds(20,200,650,430);
		jsp.setBorder(tableBorder);
		add(jsp);
		
		menu = new JButton("메인메뉴");
		menu.setBounds(20,700,130,40);
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
		
		JOptionPane.showMessageDialog(null, "전체선수가 검색되었습니다.");
		nameField.setText("");
	}
	
	public void search(String searchName) {
		try {
			dtm.setRowCount(0);
			
			String quary = "SELECT * FROM player where name = ?";
			pstmt = DB_K_Login.connector.conn.prepareStatement(quary);
			pstmt.setString(1, searchName);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				n = rs.getString(1);
				String name = rs.getString(2);
				String age = rs.getString(3);
				String weight = rs.getString(4);
				String pos = rs.getString(5);
				String bNum = rs.getString(6);
				String home = rs.getString(7);
				
				String[] rowdata = {n,name,age,weight,pos,bNum,home};
				dtm.addRow(rowdata);
			}
			
			if (n == null) {
				JOptionPane.showMessageDialog(null, searchName+"선수가 존재하지 않습니다.");
				nameField.setText("");
				return;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, searchName+"선수가 검색되었습니다.");
	}
	
//	public static void main(String[] args) {
//		new DB_K_Search();
//	}
}
