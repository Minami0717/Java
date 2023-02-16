package _20221021;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class SmallEditer2 extends JFrame implements ActionListener, ItemListener {

	JPanel menuPanel, textMenu, textSizePanel, textColorPanel;
	JButton edit, copy, cut, paste, save, load, color;
	JTextPane text;
	JPopupMenu popupMenu;
	JMenuItem jmCopy, jmCut, jmPaste;
	JRadioButton green, blue, red, yellow, pink;
	JComboBox textSize;
	TitledBorder sizeBorder, colorBorder;
	SimpleAttributeSet set;
	JFileChooser chooser;
	JColorChooser colorChooser;
	
	SmallEditer2() {
		setWindows();
		pop();
		
		setVisible(true);
	}
	
	void setWindows() {
		//LineBorder border = new LineBorder(Color.red,5);
		MatteBorder border2 = new MatteBorder(5,5,5,5,Color.pink);
		
		set = new SimpleAttributeSet();
		
		menuPanel = new JPanel();
		menuPanel.setLayout(new GridLayout(0,7));
		
		edit = new JButton("편집(A)");
		copy = new JButton("복사(C)");
		cut = new JButton("잘라내기(X)");
		paste = new JButton("붙이기(V)");
		save = new JButton("저장하기(S)");
		load = new JButton("불러오기(L)");
		color = new JButton("색상(O)");
		
		edit.setMnemonic('A');
		copy.setMnemonic('C');
		cut.setMnemonic('X');
		paste.setMnemonic('V');
		save.setMnemonic('S');
		load.setMnemonic('L');
		color.setMnemonic('O');
		
		edit.setForeground(Color.red);
		edit.setFont(new Font("한컴 바겐세일 B",Font.ITALIC,20));
		copy.setForeground(Color.gray);
		copy.setFont(new Font("한컴 바겐세일 B",Font.ITALIC,20));
		cut.setForeground(Color.green);
		cut.setFont(new Font("한컴 바겐세일 B",Font.ITALIC,20));
		paste.setForeground(Color.magenta);
		paste.setFont(new Font("한컴 바겐세일 B",Font.ITALIC,20));
		save.setForeground(Color.orange);
		save.setFont(new Font("한컴 바겐세일 B",Font.ITALIC,20));
		load.setForeground(Color.LIGHT_GRAY);
		load.setFont(new Font("한컴 바겐세일 B",Font.ITALIC,20));
		color.setForeground(Color.BLUE);
		color.setFont(new Font("한컴 바겐세일 B",Font.ITALIC,20));
		
		edit.addActionListener(this);
		copy.addActionListener(this);
		cut.addActionListener(this);
		paste.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		color.addActionListener(this);
		
		menuPanel.add(edit);
		menuPanel.add(copy);
		menuPanel.add(cut);
		menuPanel.add(paste);
		menuPanel.add(save);
		menuPanel.add(load);
		menuPanel.add(color);
		menuPanel.setBorder(border2);
		add(menuPanel,BorderLayout.NORTH);
		
		text = new JTextPane();
		text.setToolTipText("편집버튼 클릭하세요.");
		text.setSelectionColor(Color.blue);
		text.setSelectedTextColor(Color.white);
		text.setEditable(false);
		add(text);
		
		textMenu = new JPanel();
		textMenu.setLayout(new GridLayout(0,2));
		
		textSizePanel = new JPanel();
		textSizePanel.setLayout(new BorderLayout());
		
		String[] size = {"15","20","25","30","35","40"};
		textSize = new JComboBox(size);
		textSize.addItemListener(this);
		sizeBorder = new TitledBorder("글자크기");
		textSize.setBorder(sizeBorder);
		textSizePanel.add(textSize);
		textMenu.add(textSizePanel);
		
		green = new JRadioButton("green");
		red = new JRadioButton("red");
		yellow = new JRadioButton("yellow");
		blue = new JRadioButton("blue");
		pink = new JRadioButton("pink");
		
		green.addItemListener(this);
		red.addItemListener(this);
		yellow.addItemListener(this);
		blue.addItemListener(this);
		pink.addItemListener(this);

		ButtonGroup color = new ButtonGroup();
		color.add(green);
		color.add(red);
		color.add(yellow);
		color.add(blue);
		color.add(pink);
		
		textColorPanel = new JPanel();
		textColorPanel.add(green);
		textColorPanel.add(red);
		textColorPanel.add(yellow);
		textColorPanel.add(pink);
		textColorPanel.add(blue);
		colorBorder = new TitledBorder("글자색상");
		textColorPanel.setBorder(colorBorder);
		textMenu.add(textColorPanel);
		add(textMenu, BorderLayout.SOUTH);
		
		setTitle("편집기");
		setSize(900,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		if (e.getSource() == copy || e.getSource() == jmCopy)
			text.copy();
		if (e.getSource() == cut || e.getSource() == jmCut)
			text.cut();
		if (e.getSource() == paste || e.getSource() == jmPaste)
			text.paste();
		
		if (e.getSource() == save) {
			chooser = new JFileChooser("C:\\Users\\kcd\\Desktop");
			
			FileNameExtensionFilter filter = new FileNameExtensionFilter("텍스트 문서(*.txt)", "txt");
			chooser.setFileFilter(filter);
			
			int returnVal = chooser.showSaveDialog(this);
			
			if (returnVal == 1) {
				JOptionPane.showMessageDialog(this, "파일을 저장하지 못했습니다");
				return;
			}
			
			String filePath = chooser.getSelectedFile().getPath();
			
			if (!filePath.endsWith(".txt")) {
				JOptionPane.showMessageDialog(this, "확장자 텍스트 아닙니다");
				return;
			}
			
			try {
				FileWriter fw = new FileWriter(filePath);
				String s = text.getText();
				fw.write(s);
				
				this.setTitle(filePath);
				fw.close();
				JOptionPane.showMessageDialog(this, "파일을 저장했습니다.");
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, e2);
			}
		}
		
		if (e.getSource() == load) {
			chooser = new JFileChooser("C:\\Users\\kcd\\Desktop");
			
			FileNameExtensionFilter filter = new FileNameExtensionFilter("텍스트 문서(*.txt)", "txt");
			chooser.setFileFilter(filter);
			
			int returnVal = chooser.showOpenDialog(this);
			if (returnVal == 1) {
				JOptionPane.showMessageDialog(this, "파일을 갖고 오지 못했습니다");
				return;
			}
			
			String filePath = chooser.getSelectedFile().getPath();
			String s = "";
			
			try {
				FileReader fr = new FileReader(filePath);
				int k;
				
				while (true) {
					k = fr.read();
					if (k == -1)
						break;
					
					s += (char) k;
				}
				
				this.setTitle(filePath);
				fr.close();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, e2);
			}
			text.setText(s);
		}
		
		if (e.getSource() == color) {
			colorChooser = new JColorChooser();
			Color selectedColor = colorChooser.showDialog(this, "색상을 고르세요", Color.black);
			
			if (selectedColor == null) {
				JOptionPane.showMessageDialog(this, "색상을 선택하지 않았습니다", "색상", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			text.setForeground(selectedColor);
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if (red.isSelected())
			StyleConstants.setForeground(set, Color.red);
		if (yellow.isSelected())
			StyleConstants.setForeground(set, Color.yellow);
		if (blue.isSelected())
			StyleConstants.setForeground(set, Color.blue);
		if (green.isSelected())
			StyleConstants.setForeground(set, Color.green);
		if (pink.isSelected())
			StyleConstants.setForeground(set, Color.pink);
		
		String str = (String) textSize.getSelectedItem();
		int size = Integer.parseInt(str);
		StyleConstants.setFontSize(set, size);
		
		text.setCharacterAttributes(set, true);
	}
	
	public static void main(String[] args) {
		new SmallEditer2();
	}
}
