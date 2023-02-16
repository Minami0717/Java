package _20221021;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class RadioTest1 extends JFrame implements ActionListener {
	JRadioButton small, medium, large;
	JLabel label1, label2;
	JPanel topPanel, sizePanel, resultPanel;
	TitledBorder border;
	
	RadioTest1() {
		setTitle("라디오 버튼 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350,200);
		
		topPanel = new JPanel();
		label1 = new JLabel("어떤 크기의 커피를 주문하시겠습니까?");
		topPanel.add(label1);
		add(topPanel, BorderLayout.NORTH);
		
		sizePanel = new JPanel();
		small = new JRadioButton("Small Size");
		medium = new JRadioButton("Medium Size");
		large = new JRadioButton("Large Size");
		
		small.addActionListener(this);
		medium.addActionListener(this);
		large.addActionListener(this);
		
		ButtonGroup size = new ButtonGroup();
		size.add(small);
		size.add(medium);
		size.add(large);
		
		sizePanel.add(small);
		sizePanel.add(medium);
		sizePanel.add(large);
		
		border = new TitledBorder("크기");
		sizePanel.setBorder(border);
		add(sizePanel);
		
		resultPanel = new JPanel();
		label2 = new JLabel("크기가 선택되지 않았습니다.");
		label2.setForeground(Color.red);
		resultPanel.add(label2);
		add(resultPanel, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == small) {
			label2.setText("Small 선택");
			label2.setForeground(Color.cyan);
		}
		if (e.getSource() == medium) {
			label2.setText("Medium 선택");
			label2.setForeground(Color.LIGHT_GRAY);
		}
		if (e.getSource() == large) {
			label2.setText("Large 선택");
			label2.setForeground(Color.pink);
		}
	}
	
	public static void main(String[] args) {
		new RadioTest1();
	}
}
