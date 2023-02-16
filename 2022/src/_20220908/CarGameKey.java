package _20220908;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel {
	BufferedImage img = null;
	int img_x = 100, img_y = 100;
	public MyPanel() {
		try {
			img = ImageIO.read(new File("car.gif"));
		} catch (IOException e) {
			System.out.println("no image");
			System.exit(1);
		}
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				int keycode = e.getKeyCode();
				switch (keycode) {
				case KeyEvent.VK_UP:	img_y -= 50;	break;
				case KeyEvent.VK_DOWN:	img_y += 50;	break;
				case KeyEvent.VK_LEFT:	img_x -= 50;	break;
				case KeyEvent.VK_RIGHT:	img_x += 50;	break;
				}
				repaint();
			}
			
		});
		this.requestFocus();
		setFocusable(true);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, img_x, img_y, null);
	}
}
public class CarGameKey extends JFrame {
	public CarGameKey() {
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MyPanel());
		setVisible(true);
	}

	public static void main(String[] args) {
		CarGameKey s = new CarGameKey();
	}

}
