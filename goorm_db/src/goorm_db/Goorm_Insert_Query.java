package goorm_db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Goorm_Insert_Query {
	ResultSet rs = null;
	Statement stmt;
	Goorm_Connector connect = new Goorm_Connector();
	
	Goorm_Insert_Query() throws SQLException {
		stmt = connect.conn.createStatement();
		String sql = "SELECT * FROM goodsinfo";
		String str_in = "INSERT INTO goodsinfo VALUES ('1005','자바','김연주',150)";
		try {
			int i = stmt.executeUpdate(str_in);
			if (i == 1) {
				System.out.println("레코드 추가 성공");
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String s1 = rs.getString(1);
					String s2 = rs.getString(2);
					String s3 = rs.getString(3);
					String s4 = rs.getString(4);
					System.out.println(s1 + " " + s2 + " " + s3 + " " + s4);
				}
			} else 
				System.out.println("레코드 추가 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) throws SQLException {
		new Goorm_Insert_Query();
	}

}
