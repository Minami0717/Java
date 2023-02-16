package _20221031;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class JTableEx0 extends JFrame {
	public JTableEx0() {
		String[] colname = {"No","Name","Java","Jsp","Python","Total"};
		String[][] rowdata = {	{"1","박효신","100","100","100","100%"},
								{"2","김진호","90","90","90","90%"},
								{"3","마마무","80","80","80","80%"}
							 };
		String[] newrow = {"4","알리","70","70","70","70%"};
		String[] newrow1 = {"5","고유진","60","60","60","60%"};
		//String[] newcol = {"남","남","여","남"};
		
		DefaultTableModel dtm = new DefaultTableModel(rowdata, colname);
		JTable table = new JTable(dtm);
		JScrollPane jsp = new JScrollPane(table);
		
		dtm.addRow(newrow);
		dtm.insertRow(2, newrow1);
		dtm.removeRow(3);
		//dtm.addColumn("성별", newcol);
		add(jsp);
		
		JPanel btnPanel = new JPanel();
		JButton button = new JButton("추가");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dtm.addRow(newrow);
			}
		});
		
		btnPanel.add(button);
		add(btnPanel,BorderLayout.SOUTH);
		
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		table.setBackground(new Color(255, 255, 204));
		table.setSelectionBackground(Color.blue);	// 마우스 클릭 선택 행 배경색
		table.setSelectionForeground(Color.white);	// 전경색

		// 테이블 행 높이 조절
		table.setRowHeight(50);	
		
		// 셀의 너비 조절하고, 셀 안에 데이터 정렬 DefaultTableCellRenderer 객체 이용
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);	// 셀 데이터 가운데 정렬		
		
		DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
		celAlignRight.setHorizontalAlignment(JLabel.RIGHT);		// 셀 데이터 오른쪽 정렬
		
		DefaultTableCellRenderer celAlignLeft = new DefaultTableCellRenderer();
		celAlignLeft.setHorizontalAlignment(JLabel.LEFT);		// 셀 데이터 왼쪽 정렬

		// 각 셀 너비와 정렬. getColumn()로 해당 컬럼 가져와서, setCellRenderer()로 설정		
		table.getColumn("No").setPreferredWidth(20);			// 너비 10픽셀
		table.getColumn("No").setCellRenderer(celAlignCenter);	// 텍스트 가운데		
		table.getColumn("Name").setPreferredWidth(100);
		table.getColumn("Name").setCellRenderer(celAlignCenter);
		table.getColumn("Java").setPreferredWidth(10);
		table.getColumn("Java").setCellRenderer(celAlignCenter);
		
		table.getColumn("Jsp").setPreferredWidth(10);		
		table.getColumn("Jsp").setCellRenderer(celAlignRight);
		table.getColumn("Python").setPreferredWidth(30);
		table.getColumn("Python").setCellRenderer(celAlignRight);
		
		table.getColumn("Total").setPreferredWidth(10);
		table.getColumn("Total").setCellRenderer(celAlignLeft);		
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setBackground(Color.GREEN);
		dtcr.setForeground(Color.BLUE);		
		table.getColumn("Total").setCellRenderer(dtcr);
	}
	
	public static void main(String[] args) {
		new JTableEx0();
	}
}
