package domain.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class fff {

	public static void main(String[] args) {
		Properties properties = new Properties();
		String url = "jdbc:postgresql://gegevensbanken.khleuven.be:51516/1TX36";
		properties.setProperty("user", "r0630439");
		properties.setProperty("password", "Tvg258741");
		properties.setProperty("ssl", "true");
		properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
		try{
		Connection connection = DriverManager.getConnection(url,properties);
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery( "SELECT * FROM r0630439.person" );
		while(result.next()){
			System.out.println(result.getString("firstname"));
		}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}

	}

}
