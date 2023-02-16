package db_connect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select_Query {
	ResultSet rs = null;
	Statement stmt;
	Connector connect = new Connector();
	
	Select_Query() throws SQLException {
		
		stmt = connect.conn.createStatement();
		String sql = "SELECT name, age, job FROM custmer01";
		
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			String s1 = rs.getString(1);
			String s2 = rs.getString(2);
			String s3 = rs.getString(3);
			System.out.println(s1 + " " + s2 + " " + s3);
		}
	}

	public static void main(String[] args) throws SQLException {
		new Select_Query();
	}
}
