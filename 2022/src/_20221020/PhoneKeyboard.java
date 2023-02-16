package _20221020;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PhoneKeyboard extends JFrame implements ActionListener {
	Random random = new Random();
	JButton[] button;
	JTextField numField;
	JPanel keyPanel, numPanel, iconPanel, callPanel, displayPanel;
	JButton callButton, exitButton;
	JLabel callLabel, pNumLabel;
	
	PhoneKeyboard(String str) {
		super(str);
		
		keyPanel = new JPanel();
		numPanel = new JPanel();
		iconPanel = new JPanel();
		callPanel = new JPanel();
		displayPanel = new JPanel();
		
		callPanel.setLayout(null);
		
		callLabel = new JLabel("전화를 거는 중...");
		callLabel.setBounds(100,20,100,30);
		callPanel.add(callLabel);
		
		numField = new JTextField();
		numPanel.add(numField);
		
		pNumLabel = new JLabel();
		pNumLabel.setBounds(100,70,150,30);
		callPanel.add(pNumLabel);
		
		ImageIcon icon = new ImageIcon("C:\\Users\\kcd\\Desktop\\자바\\이미지/전화기.png");
		Image img = icon.getImage();
		Image changeimg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeimg);
		
		callButton = new JButton(changeIcon);
		callButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				displayPanel.setVisible(false);
				add(callPanel);
				callPanel.setVisible(true);
				pNumLabel.setText(numField.getText());
			}
		});
		
		iconPanel.add(callButton);
		
		ImageIcon icon2 = new ImageIcon("C:\\Users\\kcd\\Desktop\\자바\\이미지/전화종료.png");
		Image img2 = icon2.getImage();
		Image changeimg2 = img2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon changeIcon2 = new ImageIcon(changeimg2);
		
		exitButton = new JButton(changeIcon2);
		exitButton.setBounds(120,350,50,50);
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				callPanel.setVisible(false);
				numField.setText(null);
				displayPanel.setVisible(true);
			}
		});
		callPanel.add(exitButton);
		
		button = new JButton[12];
		
		String[] s = {"*","0","#"};
		
		keyPanel.setLayout(new GridLayout(4,3,5,5));
		
		for (int i = 0; i < 12; i++) {
			if (i < 9) {
				button[i] = new JButton(i+1+"");
				button[i].setBackground(Color.black);
				button[i].setForeground(Color.white);
				button[i].setFont(new Font("한컴 바겐세일 B",Font.ITALIC,20));
				button[i].addActionListener(this);
				keyPanel.add(button[i]);
			}
			else {
				button[i] = new JButton(s[i-9]);
				button[i].setBackground(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
				button[i].setForeground(Color.white);
				button[i].setFont(new Font("한컴 바겐세일 B",Font.BOLD,20));
				button[i].addActionListener(this);
				keyPanel.add(button[i]);
			}
		}
		

		
		displayPanel.setLayout(new BorderLayout());
		displayPanel.add(numField, BorderLayout.NORTH);
		displayPanel.add(keyPanel);
		displayPanel.add(iconPanel, BorderLayout.SOUTH);
		
		//callPanel.setVisible(false);
		//add(callPanel);
		add(displayPanel);
		//add(callPanel);
		
		setSize(300,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String num = numField.getText();
		int index = 0;
		for (int i = 0; i < button.length; i++) {
			if (e.getSource() == button[i]) {
				index = i;
			}
		}
		num += button[index].getText();
		numField.setText(num);
	}
	
	public static void main(String[] args) {
		new PhoneKeyboard("전화기 자판");
	}
}