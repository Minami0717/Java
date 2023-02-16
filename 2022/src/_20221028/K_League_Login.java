package _20221028;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class K_League_Login extends JFrame {
	JPanel panel, inputPanel, btnPanel;
	JLabel titleLabel, idLabel, pwLabel, nameLabel;
	JTextField idField, pwField, nameField;
	JButton btn;
	
	K_League_Login() {
		setLayout(null);
		setTitle("로그인");
		
		panel = new JPanel();
		panel.setBounds(0, 0, 700, 40);
		panel.setBackground(Color.black);
		
		inputPanel = new JPanel();
		inputPanel.setLayout(null);
		inputPanel.setBounds(0,45,700,200);
		
		btnPanel = new JPanel();
		btnPanel.setLayout(null);
		btnPanel.setBounds(0,250,700,50);
		btnPanel.setBackground(Color.blue);
		
		titleLabel = new JLabel("로그인");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel.add(titleLabel);
		
		idLabel = new JLabel("아이디");
		idLabel.setBounds(40,50,40,20);
		idField = new JTextField();
		idField.setBounds(100,50,100,25);
		
		pwLabel = new JLabel("패스워드");
		pwLabel.setBounds(230,50,50,20);
		pwField = new JTextField();
		pwField.setBounds(300,50,100,25);
		
		nameLabel = new JLabel("사용자이름");
		nameLabel.setBounds(430,50,70,20);
		nameField = new JTextField();
		nameField.setBounds(510,50,100,25);
		
		btn = new JButton("확 인");
		btn.setBounds(550, 7, 70, 35);
		btn.setBackground(Color.green);
		btn.setForeground(Color.red);

		inputPanel.add(idLabel);
		inputPanel.add(idField);
		inputPanel.add(pwLabel);
		inputPanel.add(pwField);
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);
		btnPanel.add(btn);
		
		add(panel);
		add(inputPanel);
		add(btnPanel);

		setSize(700,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new K_League_Login();
	}
}
