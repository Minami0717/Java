package _20221110;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Omok extends JFrame {
	BackPanel backPanel;
	
	Omok() {
		backPanel = new BackPanel();
		backPanel.setBackground(new Color(206,167,61));
		backPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				backPanel.drawStone(null);;
			}
		});
		add(backPanel);
		
		setSize(540,560);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	class BackPanel extends JPanel {
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawLine(20, 20, 20, 500);
			g.drawLine(20, 20, 500, 20);
			g.drawLine(500, 20, 500, 500);
			g.drawLine(500, 500, 20, 500);
			
			int x = 50;
			int y = 50;
			
			for (int i = 0; i < 15; i++) {
				g.drawLine(x, 20, x, 500);
				g.drawLine(20, y, 500, y);
				x += 30;
				y += 30;
			}
		}
		
		public void drawStone(Graphics g) {
			g.drawOval(250, 250, 5, 5);
		}
	}

	public static void main(String[] args) {
		new Omok();
	}
}
