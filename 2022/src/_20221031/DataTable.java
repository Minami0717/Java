package _20221031;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class DataTable extends JPanel {
	static DefaultTableModel dtm;
	static JTable table;
	JScrollPane jsp;
	TitledBorder border;
	static int srow = -1;
	
	DataTable() {
		
		border = new TitledBorder("테이블");
		setBorder(border);
		
		String[] colname = {"이름","나이","직업"};
		String[][] rowdata = {	{"홍길동","13","학생"},
								{"김유신","15","화랑"},
								{"김덕만","19","공주"}
							 };
		dtm = new DefaultTableModel(rowdata, colname);
		table = new JTable(dtm);
		jsp = new JScrollPane(table);
		
		add(jsp);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				srow = table.getSelectedRow();
				
				JTableOneForm.topLabel.setText("이름:" + table.getValueAt(srow, 0) +
						", 나이:" + table.getValueAt(srow, 1) +
						", 직업:" + table.getValueAt(srow, 2));
				
				DataInput.nameField.setText(table.getValueAt(srow, 0).toString());
				DataInput.ageField.setText(table.getValueAt(srow, 1).toString());
				DataInput.jobField.setText(table.getValueAt(srow, 2).toString());
				
				DataInput.inputButton.setText("수정");
			}
		});
		
		setSize(600,600);
		//setVisible(true);
	}
}
