package banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connect {
	public static Connection con() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String pass="Ak6385561116";
		conn=DriverManager.getConnection(url, user, pass);
		return conn;
	}

}
