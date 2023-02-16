package goorm_db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Goorm_Select_Query {
	ResultSet rs = null;
	Statement stmt;
	Goorm_Connector connect = new Goorm_Connector();
	
	Goorm_Select_Query() throws SQLException {
		
		stmt = connect.conn.createStatement();
		String sql = "SELECT * FROM goodsinfo";
		
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			String s1 = rs.getString(1);
			String s2 = rs.getString(2);
			String s3 = rs.getString(3);
			String s4 = rs.getString(4);
			System.out.println(s1 + " " + s2 + " " + s3 + " " + s4);
		}
	}
	public static void main(String[] args) throws SQLException {
		new Goorm_Select_Query();
	}
}
