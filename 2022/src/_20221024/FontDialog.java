package _20221024;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class FontDialog extends JDialog implements ActionListener {
	
	NotePad np;
	Container con;
	JTextPane jPane;
	JComboBox sizeBox, attriBox, fontBox;
	JButton setButton, cancelButton, colorButton;
	JLabel sizeLabel, attriLabel, fontLabel;
	JColorChooser colorChooser;
	
	String s = null;
	String font = "굴림";
	String attri = "보통";
	int size = 8;
	
	SimpleAttributeSet saset = new SimpleAttributeSet();
	
	FontDialog(NotePad np) {
		super(np, "글자모양", true);
		this.np = np;
		con = getContentPane();
		con.setLayout(null);
		
		jPane = new JTextPane();
		s = np.textArea.getSelectedText();
		jPane.setText(s);
		jPane.setBounds(15,100,200,50);
		
		sizeLabel = new JLabel("글자크기");
		sizeLabel.setBounds(15,10,50,20);
		attriLabel = new JLabel("글자속성");
		attriLabel.setBounds(15,40,50,20);
		fontLabel = new JLabel("글꼴");
		fontLabel.setBounds(15,70,50,20);
		
		sizeBox = new JComboBox();
		sizeBox.setBounds(75,10,70,20);
		sizeBox.addItem("8");
		sizeBox.addItem("12");
		sizeBox.addItem("15");
		sizeBox.addItem("20");
		sizeBox.addItem("30");
		sizeBox.addActionListener(this);
		
		attriBox = new JComboBox();
		attriBox.setBounds(75,40,70,20);
		attriBox.addItem("보통");
		attriBox.addItem("굵게");
		attriBox.addItem("기울이기");
		attriBox.addActionListener(this);
		
		fontBox = new JComboBox();
		fontBox.setBounds(75,70,70,20);
		fontBox.addItem("굴림");
		fontBox.addItem("궁서체");
		fontBox.addItem("돋움체");
		fontBox.addActionListener(this);
		
		setButton = new JButton("설정");
		setButton.setBounds(155, 10, 60, 20);
		setButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StyleConstants.setFontSize(saset, size);
				StyleConstants.setFontFamily(saset, font);
				StyleConstants.setForeground(saset, jPane.getForeground());
				np.textArea.setCharacterAttributes(saset, true);
				dispose();
			}
		});
		
		cancelButton = new JButton("취소");
		cancelButton.setBounds(155, 40, 60, 20);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		colorButton = new JButton("색상");
		colorButton.setBounds(155, 70, 60, 20);
		colorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorChooser = new JColorChooser();
				Color selectedColor = colorChooser.showDialog(null, "색상을 고르세요", Color.black);
				
				if (selectedColor != null) {
					jPane.setForeground(selectedColor);
				}
			}
		});
		
		con.add(sizeLabel);
		con.add(attriLabel);
		con.add(fontLabel);
		con.add(sizeBox);
		con.add(attriBox);
		con.add(fontBox);
		con.add(setButton);
		con.add(cancelButton);
		con.add(colorButton);
		con.add(jPane);

		setSize(250,220);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String select = (String) sizeBox.getSelectedItem();
		size = Integer.parseInt(select);
		attri = (String) attriBox.getSelectedItem();
		font = (String) fontBox.getSelectedItem();
		
		if (attri == "보통") {
			jPane.setFont(new Font(font, Font.PLAIN, size));
			StyleConstants.setBold(saset, false);
			StyleConstants.setItalic(saset, false);
		}
		else if (attri == "굵게") {
			jPane.setFont(new Font(font, Font.BOLD, size));
			StyleConstants.setBold(saset, true);
		}
		else if (attri == "기울이기") {
			jPane.setFont(new Font(font, Font.ITALIC, size));
			StyleConstants.setItalic(saset, true);
		}
	}
}
