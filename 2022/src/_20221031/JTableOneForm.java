package _20221031;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class JTableOneForm extends JFrame {
	JPanel topPanel, bottomPanel;
	static JLabel topLabel;
	JButton deletebtn, exitbtn;
	DataInput dataInput;
	DataTable dataTable;
	JSplitPane splitPane;
	
	JTableOneForm() {
		topPanel = new JPanel();
		topLabel = new JLabel("안녕 테이블");
		
		topLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		topPanel.add(topLabel);
		add(topPanel, BorderLayout.NORTH);
		
		bottomPanel = new JPanel();
		deletebtn = new JButton("삭제");
		deletebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (dataTable.table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "삭제할 이름을 선택하세요");
					DataInput.nameField.requestFocus();
					return;
				}
				
				int i = JOptionPane.showConfirmDialog(null, DataTable.table.getValueAt(DataTable.table.getSelectedRow(), 0) + "님의 정보를 삭제하시겠습니까?",
						"삭제", JOptionPane.YES_NO_OPTION);
				
				if (i == 0) {
					dataTable.dtm.removeRow(dataTable.table.getSelectedRow());
					DataInput.nameField.setText("");
					DataInput.ageField.setText("");
					DataInput.jobField.setText("");
					DataInput.nameField.requestFocus();
					DataInput.inputButton.setText("입력");
					topLabel.setText("안녕 테이블");
				}
				else
					return;
			}
		});
		
		exitbtn = new JButton("종료");
		exitbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		bottomPanel.add(deletebtn);
		bottomPanel.add(exitbtn);
		add(bottomPanel, BorderLayout.SOUTH);
		
		dataInput = new DataInput();
		dataTable = new DataTable();
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, dataInput, dataTable);
		splitPane.setResizeWeight(0.9);
		splitPane.setContinuousLayout(true);
		splitPane.setOneTouchExpandable(true);
		add(splitPane);
		
		setSize(700,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JTableOneForm();
	}
}
