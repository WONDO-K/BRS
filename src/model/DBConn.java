package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	
	public static Connection getConnection() throws SQLException {
		try {
			String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // 주소
			String ID = "proj"; // SQL ID
			String PW = "1234"; // SQL PW
			Class.forName("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection(URL, ID, PW);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}

// 나중에 호출할때 Connection con= ConnectionProvider.getConnection(); 같은 식으로 하면 편함