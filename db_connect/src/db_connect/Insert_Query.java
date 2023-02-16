package db_connect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert_Query {
	ResultSet rs = null;
	Statement stmt;
	Connector connect = new Connector();
	
	Insert_Query() throws SQLException {
		stmt = connect.conn.createStatement();
		String sql = "SELECT name, age, job FROM custmer01";
		String str_in = "INSERT INTO custmer01 VALUES ('박만수','43', '회사원')";
		try {
			int i = stmt.executeUpdate(str_in);
			if (i == 1) {
				System.out.println("레코드 추가 성공\n");
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String s1 = rs.getString(1);
					String s2 = rs.getString(2);
					String s3 = rs.getString(3);
					System.out.println(s1 + " " + s2 + " " + s3);
				}
			} else 
				System.out.println("레코드 추가 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) throws SQLException {
		new Insert_Query();
	}
}
