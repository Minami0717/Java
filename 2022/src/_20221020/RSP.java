package _20221020;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RSP extends JFrame {
	int r = 0;
	int s = 1;
	int p = 2;
	
	JTextField info;
	JTextField output;
	JPanel panel1,panel2,panel3;
	JButton rock,scissor,paper;
	
	RSP() {
		ImageIcon rockIcon = new ImageIcon("C:\\Users\\kcd\\Desktop\\자바\\이미지/bawi.jpg");
		ImageIcon scissorIcon = new ImageIcon("C:\\Users\\kcd\\Desktop\\자바\\이미지/gawi.jpg");
		ImageIcon paperIcon = new ImageIcon("C:\\Users\\kcd\\Desktop\\자바\\이미지/bo.jpg");
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		
		panel2.setLayout(new GridLayout());
		
		info = new JTextField("아래의 버튼 중에서 하나를 클릭하시오");
		info.setHorizontalAlignment(JTextField.CENTER);
		panel1.add(info);
		add(panel1, BorderLayout.NORTH);
		
		rock = new JButton(rockIcon);
		scissor = new JButton(scissorIcon);
		paper = new JButton(paperIcon);
		
		rock.addActionListener(new MyListener());
		scissor.addActionListener(new MyListener());
		paper.addActionListener(new MyListener());
		
		panel2.add(rock);
		panel2.add(paper);
		panel2.add(scissor);
		add(panel2);
		
		output = new JTextField(20);
		panel3.add(output);
		add(panel3,BorderLayout.SOUTH);
		
		setTitle("가위바위보");
		setSize(400,300);
		setVisible(true);
	}
	
	class MyListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Random random = new Random();
			int com = random.nextInt(3);
			
			if (com == r) {
				info.setText("바위");
				if (e.getSource() == paper)
					output.setText("사용자 승");
				else if (e.getSource() == rock)
					output.setText("무승부");
				else
					output.setText("컴퓨터 승");
			}
			if (com == s) {
				info.setText("가위");
				if (e.getSource() == rock)
					output.setText("사용자 승");
				else if (e.getSource() == scissor)
					output.setText("무승부");
				else
					output.setText("컴퓨터 승");
			}
			if (com == p) {
				info.setText("보");
				if (e.getSource() == scissor)
					output.setText("사용자 승");
				else if (e.getSource() == paper)
					output.setText("무승부");
				else
					output.setText("컴퓨터 승");
			}
		}
		
	}

	public static void main(String[] args) {
		new RSP();
	}

}
