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

public class K_League_Add extends JFrame {
	
	JPanel panel, inputPanel;
	JLabel titleLabel, nameLabel, ageLabel, weightLabel, posLabel, bNumLabel, homeLabel;
	JTextField nameField, ageField, weightField, posField, bNumField, homeField;
	JButton menu, edit;
	DefaultTableModel dtm;
	JTable table;
	JScrollPane jsp;
	TitledBorder inputBorder, tableBorder;
	String[] colname = {"번호","이름","나이","몸무게","포지션","등번호","연고지"};
	String[][] rowdata = {};
	
	K_League_Add() {
		setLayout(null);
		
		inputBorder = new TitledBorder("입력");
		tableBorder = new TitledBorder("테이블");
		
		panel = new JPanel();
		panel.setBounds(0, 0, 700, 40);
		panel.setBackground(Color.black);
		
		inputPanel = new JPanel();
		inputPanel.setLayout(null);
		inputPanel.setBounds(0,50,680,330);
		inputPanel.setBorder(inputBorder);
		
		titleLabel = new JLabel("K_League_Player 선수 추가");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel.add(titleLabel);
		
		nameLabel = new JLabel("이름");
		nameLabel.setBounds(50,30,30,20);
		nameField = new JTextField();
		nameField.setBounds(150,30,170,25);
		
		ageLabel = new JLabel("나이");
		ageLabel.setBounds(50,80,30,20);
		ageField = new JTextField();
		ageField.setBounds(150,80,170,25);
		
		weightLabel = new JLabel("몸무게");
		weightLabel.setBounds(50,130,40,20);
		weightField = new JTextField();
		weightField.setBounds(150,130,170,25);
		
		posLabel = new JLabel("포지션");
		posLabel.setBounds(50,180,40,20);
		posField = new JTextField();
		posField.setBounds(150,180,170,25);
		
		bNumLabel = new JLabel("등번호");
		bNumLabel.setBounds(50,230,40,20);
		bNumField = new JTextField();
		bNumField.setBounds(150,230,170,25);
		
		homeLabel = new JLabel("연고지");
		homeLabel.setBounds(50,280,40,20);
		homeField = new JTextField();
		homeField.setBounds(150,280,170,25);
		
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);
		inputPanel.add(ageLabel);
		inputPanel.add(ageField);
		inputPanel.add(weightLabel);
		inputPanel.add(weightField);
		inputPanel.add(posLabel);
		inputPanel.add(posField);
		inputPanel.add(bNumLabel);
		inputPanel.add(bNumField);
		inputPanel.add(homeLabel);
		inputPanel.add(homeField);
		
		add(panel);
		add(inputPanel);
		
		dtm = new DefaultTableModel(rowdata, colname);
		table = new JTable(dtm);
		jsp = new JScrollPane(table);
		jsp.setBounds(5,400,675,200);
		jsp.setBorder(tableBorder);
		add(jsp);
		
		menu = new JButton("메인메뉴");
		menu.setBounds(200,650,130,40);
		menu.setFont(new Font("굴림", Font.BOLD, 20));
		menu.setBackground(Color.blue);
		menu.setForeground(Color.magenta);
		add(menu);
		
		edit = new JButton("선수추가");
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
		new K_League_Add();
	}
}
