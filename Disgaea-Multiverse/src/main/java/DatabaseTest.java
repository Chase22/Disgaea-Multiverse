import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.h2.Driver;

public class DatabaseTest {

	public static void main(String[] args) throws SQLException {
		String link = "jdbc:h2:~/test";
		DriverManager.registerDriver(new Driver());
		Connection conn = DriverManager.getConnection(link);
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM INFORMATION_SCHEMA.COLUMNS");
		ResultSet rs = statement.executeQuery();

		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();

		while (rs.next()) {
			for (int i = 1; i <= columnsNumber; i++) {
				if (i > 1)
					System.out.print(",  ");
				String columnValue = rs.getString(i);
				System.out.print(columnValue + " " + rsmd.getColumnName(i));
			}
			System.out.println("");
		}
	}

}
