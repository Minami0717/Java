package _20221021;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboBox extends JFrame implements ActionListener {
	JLabel label;
	JComboBox animalBox;
	
	ComboBox() {
		setTitle("콤보박스 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String[] animals = {"puppy","cat","goldfish","tiger","lion","bear"};
		animalBox = new JComboBox(animals);
		animalBox.setSelectedIndex(0);
		animalBox.addActionListener(this);
		
		label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		ImageIcon icon = new ImageIcon("C:\\Users\\kcd\\Desktop\\자바\\이미지/puppy.png");
		label.setIcon(icon);
		add(animalBox,BorderLayout.NORTH);
		add(label);
		
		pack();
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = (String)animalBox.getSelectedItem();
		ImageIcon icon = new ImageIcon("C:\\Users\\kcd\\Desktop\\자바\\이미지/"+name+".png");
		label.setIcon(icon);
	}
	
	public static void main(String[] args) {
		new ComboBox();
	}
}
