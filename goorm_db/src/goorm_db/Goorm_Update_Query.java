package goorm_db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Goorm_Update_Query {
	ResultSet rs = null;
	Statement stmt;
	Goorm_Connector connect = new Goorm_Connector();
	
	Goorm_Update_Query() throws SQLException {
		stmt = connect.conn.createStatement();
		String sql = "SELECT * FROM goodsinfo";
		String str_modi = "UPDATE goodsinfo SET title = 'DB' WHERE code = '1001'";
		try {
			int i = stmt.executeUpdate(str_modi);
			if (i == 1) {
				System.out.println("레코드 수정 성공");
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String s1 = rs.getString(1);
					String s2 = rs.getString(2);
					String s3 = rs.getString(3);
					String s4 = rs.getString(4);
					System.out.println(s1 + " " + s2 + " " + s3 + " " + s4);
				}
			} else 
				System.out.println("레코드 수정 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) throws SQLException {
		new Goorm_Update_Query();
	}

}
