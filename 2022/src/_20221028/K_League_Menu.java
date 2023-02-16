package _20221028;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class K_League_Menu extends JFrame {
	JPanel panel, btnPanel;
	JLabel titleLabel;
	JButton add, edit, del, search, exit;
	TitledBorder border;
	
	K_League_Menu() {
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
		
		edit = new JButton("선수수정");
		edit.setBounds(240, 130, 150, 40);
		edit.setBackground(Color.yellow);
		edit.setForeground(Color.black);
		edit.setFont(new Font("굴림", Font.BOLD, 20));
		
		del = new JButton("선수삭제");
		del.setBounds(240, 210, 150, 40);
		del.setBackground(Color.cyan);
		del.setForeground(Color.red);
		del.setFont(new Font("굴림", Font.BOLD, 20));
		
		search = new JButton("선수검색");
		search.setBounds(240, 290, 150, 40);
		search.setBackground(Color.green);
		search.setForeground(Color.gray);
		search.setFont(new Font("굴림", Font.BOLD, 20));
		
		exit = new JButton("종   료");
		exit.setBounds(240, 370, 150, 40);
		exit.setBackground(Color.magenta);
		exit.setForeground(Color.yellow);
		exit.setFont(new Font("굴림", Font.BOLD, 20));

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
	
	public static void main(String[] args) {
		new K_League_Menu();
	}
}
