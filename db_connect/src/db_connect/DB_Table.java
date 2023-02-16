package db_connect;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class DB_Table extends JPanel {
	DB_TableOneForm form;
	static DefaultTableModel dtm;
	static JTable table;
	JScrollPane jsp;
	TitledBorder border;
	static int srow = -1;
	
	DB_Table(DB_TableOneForm form) throws SQLException {
		this.form = form;
		
		border = new TitledBorder("테이블");
		setBorder(border);
		
		String[] colname = {"이름","나이","직업"};
		dtm = new DefaultTableModel(colname,0);
		
//		String[] data = new String[colname.length];
//		
//		stmt = DB_TableOneForm.connect.conn.createStatement();
//		String sql = "SELECT * FROM custmer01";
//		
//		rs = stmt.executeQuery(sql);
//		
		//int i = 0;
		
		
		
//		while (rs.next()) {
//			
//			i++;
//			for (int j = 0; j < colname.length; j++) {
//				data[j] = rs.getString(j+1);
//			}
//			dtm.insertRow(i-1, data);
//		}
		
		table = new JTable(dtm);
		jsp = new JScrollPane(table);
		
		add(jsp);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				srow = table.getSelectedRow();
				
				DB_TableOneForm.topLabel.setText("이름:" + table.getValueAt(srow, 0) +
						", 나이:" + table.getValueAt(srow, 1) +
						", 직업:" + table.getValueAt(srow, 2));
				
				DB_Input.nameField.setText(table.getValueAt(srow, 0).toString());
				DB_Input.ageField.setText(table.getValueAt(srow, 1).toString());
				DB_Input.jobField.setText(table.getValueAt(srow, 2).toString());

				DB_Input.nameField.setEnabled(false);
				DB_Input.inputButton.setText("수정");
			}
		});
		
		setSize(600,600);
		//setVisible(true);
	}
}
