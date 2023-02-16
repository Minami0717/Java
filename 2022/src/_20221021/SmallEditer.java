package _20221021;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class SmallEditer extends JFrame implements ActionListener {

	JPanel menuPanel;
	JButton edit, copy, cut, paste, exit;
	JTextPane text;
	JPopupMenu popupMenu;
	JMenuItem jmCopy, jmCut, jmPaste;
	
	SmallEditer() {
		windows();
		pop();
		
		setVisible(true);
	}
	
	void windows() {
		LineBorder border = new LineBorder(Color.red,5);
		MatteBorder border2 = new MatteBorder(5,5,5,5,Color.pink);
		menuPanel = new JPanel();
		
		menuPanel.setLayout(new GridLayout(0,5));
		
		edit = new JButton("편집(A)");
		copy = new JButton("복사(C)");
		cut = new JButton("잘라내기(X)");
		paste = new JButton("붙이기(V)");
		exit = new JButton("종료(E)");
		
		edit.setMnemonic('A');
		copy.setMnemonic('C');
		cut.setMnemonic('X');
		paste.setMnemonic('V');
		exit.setMnemonic('E');
		
		edit.setForeground(Color.red);
		edit.setFont(new Font("한컴 바겐세일 B",Font.ITALIC,20));
		copy.setForeground(Color.gray);
		copy.setFont(new Font("한컴 바겐세일 B",Font.ITALIC,20));
		cut.setForeground(Color.green);
		cut.setFont(new Font("한컴 바겐세일 B",Font.ITALIC,20));
		paste.setForeground(Color.magenta);
		paste.setFont(new Font("한컴 바겐세일 B",Font.ITALIC,20));
		exit.setForeground(Color.orange);
		exit.setFont(new Font("한컴 바겐세일 B",Font.ITALIC,20));
		
		edit.addActionListener(this);
		copy.addActionListener(this);
		cut.addActionListener(this);
		paste.addActionListener(this);
		exit.addActionListener(this);
		
		menuPanel.add(edit);
		menuPanel.add(copy);
		menuPanel.add(cut);
		menuPanel.add(paste);
		menuPanel.add(exit);
		menuPanel.setBorder(border2);
		add(menuPanel,BorderLayout.NORTH);
		
		text = new JTextPane();
		text.setToolTipText("편집버튼 클릭하세요.");
		text.setSelectionColor(Color.blue);
		text.setSelectedTextColor(Color.white);
		text.setEditable(false);
		add(text);
		
		setTitle("편집기");
		setSize(700,600);
	}
	
	void pop() {
		popupMenu = new JPopupMenu();
		jmCopy = new JMenuItem("복사(C)");
		jmCut = new JMenuItem("잘라내기(X)");
		jmPaste = new JMenuItem("붙여넣기(V)");
		
		jmCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		jmCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		jmPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		
		popupMenu.add(jmCopy);
		popupMenu.addSeparator();
		popupMenu.add(jmCut);
		popupMenu.addSeparator();
		popupMenu.add(jmPaste);
		
		text.add(popupMenu);
		
		jmCopy.addActionListener(this);
		jmCut.addActionListener(this);
		jmPaste.addActionListener(this);
		
		text.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == 3) {
					popupMenu.show(text, e.getX(), e.getY());
				}
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "편집(A)") {
			edit.setText("편집중");
			text.setEditable(true);
			edit.setBackground(Color.cyan);
		}
		else if (e.getActionCommand() == "편집중") {
			edit.setText("편집(A)");
			text.setEditable(false);
			edit.setBackground(null);
		}
		
		if (e.getSource() == copy || e.getSource() == jmCopy) {
			text.copy();
		}
		
		if (e.getSource() == cut || e.getSource() == jmCut) {
			text.cut();
		}
		
		if (e.getSource() == paste || e.getSource() == jmPaste) {
			text.paste();
		}
		
		if (e.getSource() == exit) {
			System.exit(0);
			//this.dispose();
		}
	}
	
	public static void main(String[] args) {
		new SmallEditer();
	}
}
