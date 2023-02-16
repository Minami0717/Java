package _20220921;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import javax.management.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import _20220907.MyFrame;

class MyPanel extends JPanel implements ActionListener {
	
	private final int WIDTH = 500;
	private final int HEIGHT = 300;
	private final int START_X = 0;
	private final int START_Y = 250;
	private BufferedImage image;
	private javax.swing.Timer timer;
	private int x,y;
	
	public MyPanel() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setDoubleBuffered(true);
		
		File input = new File("ship.jpg");
		try {
			image = ImageIO.read(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		x = START_X;
		y = START_Y;
		timer = new javax.swing.Timer(20, this);
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x, y, this);
	}
	
	public void actionPerformed(ActionEvent e) {
		x += 1;
		y -= 1;
		if (x > WIDTH) {
			x = START_X;
			y = START_Y;
		}
		repaint();
	}
}
public class AnimeTest extends JFrame {

	public AnimeTest() {
		add(new MyPanel());
		setTitle("애니메이션 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame();
	}

}
