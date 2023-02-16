package _20220914;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Rectangle {
	int x,y,w,h;
}

class MyPanel3 extends JPanel implements MouseListener {
	BufferedImage img = null;
	int img_x = 0, img_y = 0;
	Rectangle[] array = new Rectangle[100];
	int index = 0;
	public MyPanel3() {
		this.addMouseListener(this);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Rectangle r:array)
			if (r != null)
				g.drawRect(r.x, r.y, r.w, r.h);
	}
	public void mousePressed(MouseEvent e) {
		if (index > 100)
			return;
		array[index] = new Rectangle();
		array[index].x = e.getX();
		array[index].y = e.getY();
		array[index].w = 50;
		array[index].h = 50;
		index++;
		repaint();
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
}
public class MouseRectangle extends JFrame{
	public MouseRectangle() {
		setSize(300,300);
		setTitle("마우스로 사각형 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MyPanel3());
		setVisible(true);
	}
	public static void main(String[] args) {
		MouseRectangle s = new MouseRectangle();
	}

}
