package _20221028;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class K_League_Search extends JFrame {
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
	
	K_League_Search() {
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

		searchAll = new JButton("전체검색");
		searchAll.setBounds(520,95,130,35);
		searchAll.setFont(new Font("굴림", Font.BOLD, 20));
		searchAll.setBackground(Color.gray);
		searchAll.setForeground(Color.cyan);
		
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
		add(menu);

		setSize(700,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new K_League_Search();
	}
}
