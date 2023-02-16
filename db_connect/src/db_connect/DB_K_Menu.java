package db_connect;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class DB_K_Menu extends JFrame implements ActionListener {
	JPanel panel, btnPanel;
	JLabel titleLabel;
	JButton add, edit, del, search, exit;
	TitledBorder border;
	DB_K_Login k_Login;
	
	DB_K_Menu(String name, DB_K_Login k_Login) {
		this.k_Login = k_Login;
		
		setTitle("사용자 : " + name);
		setLayout(null);
		
		border = new TitledBorder("메뉴선택");
		
		panel = new JPanel();
		panel.setBounds(0, 0, 700, 40);
		panel.setBackground(Color.black);
		
		btnPanel = new JPanel();
		btnPanel.setLayout(null);
		btnPanel.setBounds(30,45,600,500);
		btnPanel.setBorder(border);
		
		titleLabel = new JLabel("K_League_Player");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel.add(titleLabel);
		
		add = new JButton("선수추가");
		add.setBounds(240, 50, 150, 40);
		add.setBackground(Color.blue);
		add.setForeground(Color.orange);
		add.setFont(new Font("굴림", Font.BOLD, 20));
		add.addActionListener(this);
		
		edit = new JButton("선수수정");
		edit.setBounds(240, 130, 150, 40);
		edit.setBackground(Color.yellow);
		edit.setForeground(Color.black);
		edit.setFont(new Font("굴림", Font.BOLD, 20));
		edit.addActionListener(this);
		
		del = new JButton("선수삭제");
		del.setBounds(240, 210, 150, 40);
		del.setBackground(Color.cyan);
		del.setForeground(Color.red);
		del.setFont(new Font("굴림", Font.BOLD, 20));
		del.addActionListener(this);
		
		search = new JButton("선수검색");
		search.setBounds(240, 290, 150, 40);
		search.setBackground(Color.green);
		search.setForeground(Color.gray);
		search.setFont(new Font("굴림", Font.BOLD, 20));
		search.addActionListener(this);
		
		exit = new JButton("로그아웃");
		exit.setBounds(240, 370, 150, 40);
		exit.setBackground(Color.magenta);
		exit.setForeground(Color.yellow);
		exit.setFont(new Font("굴림", Font.BOLD, 20));
		exit.addActionListener(this);

		btnPanel.add(add);
		btnPanel.add(edit);
		btnPanel.add(del);
		btnPanel.add(search);
		btnPanel.add(exit);
		
		add(panel);
		add(btnPanel);

		setSize(700,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			dispose();
			new DB_K_Add(this);
		}
		if (e.getSource() == edit) {
			dispose();
			new DB_K_Edit(this);
		}
		if (e.getSource() == del) {
			dispose();
			new DB_K_Del(this);
		}
		if (e.getSource() == search) {
			dispose();
			new DB_K_Search(this);
		}
		if (e.getSource() == exit) {
			dispose();
			k_Login.show();
		}
	}
}
