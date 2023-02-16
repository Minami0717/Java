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

public class K_League_Del extends JFrame {
	JPanel panel;
	JLabel titleLabel, nameLabel;
	JTextField nameField;
	JButton del, menu, edit;
	DefaultTableModel dtm;
	JTable table;
	JScrollPane jsp;
	TitledBorder tableBorder;
	String[] colname = {"번호","이름","나이","몸무게","포지션","등번호","연고지"};
	String[][] rowdata = {};
	
	K_League_Del() {
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
		
		add(nameLabel);
		add(nameField);
		add(del);
		add(panel);
		
		dtm = new DefaultTableModel(rowdata, colname);
		table = new JTable(dtm);
		jsp = new JScrollPane(table);
		jsp.setBounds(20,200,650,400);
		jsp.setBorder(tableBorder);
		add(jsp);
		
		menu = new JButton("메인메뉴");
		menu.setBounds(200,650,130,40);
		menu.setFont(new Font("굴림", Font.BOLD, 20));
		menu.setBackground(Color.blue);
		menu.setForeground(Color.magenta);
		add(menu);
		
		edit = new JButton("선수삭제");
		edit.setBounds(350,650,130,40);
		edit.setFont(new Font("굴림", Font.BOLD, 20));
		edit.setBackground(Color.orange);
		edit.setForeground(Color.red);
		add(edit);

		setSize(700,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new K_League_Del();
	}
}
