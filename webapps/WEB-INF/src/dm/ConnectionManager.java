package dm;

import java.sql.*;

public class ConnectionManager {
	public static Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/javaboard" +
					"?useUnicode=true&characterEncoding=Windows-31J",
					"jboarduser", "texia762c");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage()
					+ ":ドライバクラスの名前が違うか、"
					+ "JDBCドライバがクラスパスに設定されていません。");
		}
		return con;
	}
}
