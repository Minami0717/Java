package goorm_db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Goorm_Delete_Query {
	ResultSet rs = null;
	Statement stmt;
	Goorm_Connector connect = new Goorm_Connector();
	
	Goorm_Delete_Query() throws SQLException {
		stmt = connect.conn.createStatement();
		String sql = "SELECT * FROM goodsinfo";
		String str_del = "DELETE FROM goodsinfo WHERE code = '1005'";
		try {
			int i = stmt.executeUpdate(str_del);
			if (i == 1) {
				System.out.println("레코드 삭제 성공");
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String s1 = rs.getString(1);
					String s2 = rs.getString(2);
					String s3 = rs.getString(3);
					String s4 = rs.getString(4);
					System.out.println(s1 + " " + s2 + " " + s3 + " " + s4);
				}
			} else 
				System.out.println("레코드 삭제 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) throws SQLException {
		new Goorm_Delete_Query();
	}

}
