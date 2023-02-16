package _20221024;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import java.util.zip.Inflater;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FindDialog extends JDialog {
	FindDialog fd;
	NotePad np;
	Container con;
	JButton findButton, cancelButton;
	JCheckBox checkBox;
	JTextField findField, changeField;
	JLabel findLabel, changeLabel;
	String allText;
	
	FindDialog(NotePad np) {
		super(np, "찾기", false);
		this.np = np;
		
		con = getContentPane();
		con.setLayout(null);
		
		findLabel = new JLabel("찾을 문자열을 입력");
		findLabel.setBounds(15,10,110,20);
		
		changeLabel = new JLabel("바꿀 문자열을 입력");
		changeLabel.setBounds(15,40,110,20);
		changeLabel.setVisible(false);
		
		findField = new JTextField();
		findField.setBounds(130,10,200,20);
		
		changeField = new JTextField();
		changeField.setBounds(130,40,200,20);
		changeField.setVisible(false);

		checkBox = new JCheckBox("찾아 바꾸기");
		checkBox.setBounds(350,25,100,20);
		
		checkBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkBox.isSelected()) {
					changeLabel.setVisible(true);
					changeField.setVisible(true);
					findButton.setText("찾아 바꾸기");
				}
				else {
					changeLabel.setVisible(false);
					changeField.setVisible(false);
					findButton.setText("다음 찾기");
				}
			}
		});
		
		findButton = new JButton("다음 찾기");
		findButton.setBounds(140,70,100,30);
		findButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				allText = setFind();
				
				String findText = findField.getText();
				int leng = findText.length();
				
				int start = np.textArea.getSelectionEnd();
				int first = allText.indexOf(findText, start);
				int last = (first == -1 ? -1 : first + leng);
				np.textArea.select(first, last);
				
				if (e.getActionCommand() == "찾아 바꾸기") {
					if (first != -1) {
						np.textArea.replaceSelection(changeField.getText());
					}
				}
				
				if (first == -1) {
					int i = JOptionPane.showConfirmDialog(fd, "찾는 문자열이 없습니다 처음부터 찾으시겠습니까?", "찾기",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					
					if (i == JOptionPane.YES_OPTION)
						return;
					else if (i == JOptionPane.NO_OPTION)
						dispose();
				}
			}
		});
		
		cancelButton = new JButton("취소");
		cancelButton.setBounds(250,70,70,30);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		con.add(findLabel);
		con.add(changeLabel);
		con.add(findField);
		con.add(changeField);
		con.add(checkBox);
		con.add(findButton);
		con.add(cancelButton);

		setSize(470,150);
		setVisible(true);
	}
	
	public String setFind() {
		String s = np.textArea.getText();
		StringTokenizer st = new StringTokenizer(s, "\n");
		s = "";
		
		while (st.hasMoreTokens()) {
			s += st.nextToken();
		}
		return s;
	}
}
