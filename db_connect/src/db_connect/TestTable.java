package db_connect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TestTable extends JFrame {

	ResultSet rs = null;
	Statement stmt;
	Connector connect = new Connector();
	
	TestTable() throws SQLException {
		
		String[] colname = {"이름","나이","직업"};
		String[][] rowdata = new String[5][colname.length];
		
		stmt = connect.conn.createStatement();
		String sql = "SELECT name, age, job FROM custmer01";
		
		rs = stmt.executeQuery(sql);
		
		int i = 0;
		while (rs.next()) {
			
			for (int j = 0; j < colname.length; j++) {
				rowdata[i][j] = rs.getString(j+1);
			}
			i++;
			String s1 = rs.getString(1);
			String s2 = rs.getString(2);
			String s3 = rs.getString(3);
			System.out.println(s1 + " " + s2 + " " + s3);
		}
		
		DefaultTableModel dtm = new DefaultTableModel(rowdata, colname);
		JTable table = new JTable(dtm);
		JScrollPane jsp = new JScrollPane(table);
		add(jsp);
		
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) throws SQLException {
		new TestTable();
	}
}
