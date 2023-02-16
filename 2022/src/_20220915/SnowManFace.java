package _20220915;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SnowManFace extends JFrame {
	public SnowManFace() {
		setSize(280,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("눈사람 얼굴");
		setVisible(true);
		add(new MyPanel());
	}
	public static void main(String[] args) {
		SnowManFace snowManFace = new SnowManFace();
	}

}
class MyPanel extends JPanel {
	
	public MyPanel() {
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.fillOval(20, 30, 200, 200);
		g.setColor(Color.BLACK);
		g.drawArc(60, 80, 50, 50, 180, -180);
		g.drawArc(140, 80, 50, 50, 180, -180);
		g.drawArc(70, 130, 100, 70, 180, 180);
	}
}