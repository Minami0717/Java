package db_connect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete_Query {
	ResultSet rs = null;
	Statement stmt;
	Connector connect = new Connector();
	
	Delete_Query() throws SQLException {
		stmt = connect.conn.createStatement();
		String sql = "SELECT name,age,job FROM custmer01";
		String str_del = "DELETE FROM custmer01 WHERE name = '박종수'";
		try {
			int i = stmt.executeUpdate(str_del);
			if (i == 1) {
				System.out.println("레코드 삭제 성공\n");
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String s1 = rs.getString(1);
					String s2 = rs.getString(2);
					String s3 = rs.getString(3);
					System.out.println(s1 + " " + s2 + " " + s3);
				}
			} else 
				System.out.println("레코드 삭제 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) throws SQLException {
		new Delete_Query();
	}
}
