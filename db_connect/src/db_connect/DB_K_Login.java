package db_connect;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class DB_K_Login extends JFrame implements ActionListener {
	ResultSet rs;
	static Connector connector;
	PreparedStatement pstmt;
	JPanel panel, inputPanel, btnPanel;
	JLabel titleLabel, idLabel, pwLabel, nameLabel;
	JTextField idField, pwField, nameField;
	JButton btn, exitbtn;
	String userid, userpw, username;
	DB_K_Login k_Login;
	
	DB_K_Login() {
		connector = new Connector();
		
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
		nameField.setEditable(false);
		
		exitbtn = new JButton("종 료");
		exitbtn.setBounds(550, 7, 70, 35);
		exitbtn.setBackground(Color.green);
		exitbtn.setForeground(Color.red);
		exitbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btn = new JButton("로그인");
		btn.setBounds(450, 7, 75, 35);
		btn.setBackground(Color.green);
		btn.setForeground(Color.red);
		btn.addActionListener(this);

		inputPanel.add(idLabel);
		inputPanel.add(idField);
		inputPanel.add(pwLabel);
		inputPanel.add(pwField);
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);
		btnPanel.add(btn);
		btnPanel.add(exitbtn);
		
		add(panel);
		add(inputPanel);
		add(btnPanel);

		setSize(700,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn) {
			if (idField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "아이디를 입력하세요.");
				idField.requestFocus();
				return;
			}
			else if (pwField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "패스워드를 입력하세요.");
				pwField.requestFocus();
				return;
			}
			
			String quary = "select * from admin where id=? and password=?";
			
			try {
				pstmt = connector.conn.prepareStatement(quary);
				pstmt.setString(1, idField.getText());
				pstmt.setString(2, pwField.getText());
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					userid = rs.getString(1);
					userpw = rs.getString(2);
					username = rs.getString(3);
				}
				
				if (userid == null) {
					JOptionPane.showMessageDialog(this, "아이디나 패스워드가 틀렸습니다.");
					nameField.requestFocus();
					return;
				}
				
				nameField.setText(username);
				JOptionPane.showMessageDialog(this, nameField.getText()+"님 반갑습니다.");
				idField.setText("");
				pwField.setText("");
				nameField.setText("");
				userid = null;
				
				dispose();
				new DB_K_Menu(username,this);
				
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new DB_K_Login();
	}
}
