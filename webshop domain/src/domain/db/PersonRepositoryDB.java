package domain.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import domain.model.Person;

public class PersonRepositoryDB implements PersonRepository{
	private Properties properties;
	private String url;
	
	public PersonRepositoryDB()
	{
		properties = new Properties();
		url = "jdbc:postgresql://gegevensbanken.khleuven.be:51516/1TX36";
		properties.setProperty("user", "r0630439");
		properties.setProperty("password", "Tvg258741");
		
		
		
		
		
		
		
		
		
		
		properties.setProperty("ssl", "true");
		properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Person get(String personId) {
		Person output = null;
		
		try
		{
			Connection connection = DriverManager.getConnection(url,properties);
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("Select * from r0630439.person");
			while(resultset.next())
			{
				String userid = resultset.getString("userid");
				if(personId.equals(userid))
				{
					String password = resultset.getString("password");
					String firstname = resultset.getString("firstname");
					String lastname = resultset.getString("lastname");
					String email = resultset.getString("email");
					Person person = new Person(userid, email, password, firstname, lastname);
					output = person;
				}
				
			}
			
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return output;
	}

	@Override
	public List<Person> getAll() {
		ArrayList<Person> output = new ArrayList<Person>();
		
		try {
			Connection connection;
			connection = DriverManager.getConnection(url, properties);
			Statement statement ;
			statement = connection.createStatement();
			ResultSet result;
			result = statement.executeQuery("Select * from r0630439.person");
			while(result.next())
			{
				String userid = result.getString("userid");
				String password = result.getString("password");
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String email = result.getString("email");
				Person person = new Person(userid, email, password, firstname, lastname);
				output.add(person);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return output;
	}

	@Override
	public void add(Person person) {
		try {
			Connection connection;
			connection = DriverManager.getConnection(url, properties);
			Statement statement ;
			statement = connection.createStatement();
			
			statement.execute("INSERT INTO person (userid, password, firstname, lastname, email)"
							+ "Values( '" + person.getUserid() + "' '" + person.getPassword() + "' '" + person.getFirstName() + "' '" + person.getLastName() +"' '" + person.getEmail() + "')");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Person person) {
		try {
			Connection connection;
			connection = DriverManager.getConnection(url, properties);
			Statement statement ;
			statement = connection.createStatement();
			
			statement.execute(	"UPDATE person"
					+ 			"SET userid = " + "'" + person.getUserid() + "', "  + "firstname = " + "'" + person.getFirstName()+ "', " + "lastname = " + "'" + person.getLastName()+ "', "  + "email = " + "'" + person.getEmail()+ "', " + "password = " + "'" + person.getPassword()+ "', "  
					+ 			"WHERE userid = " + person.getUserid());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(String personId) {
		try {
			Connection connection;
			connection = DriverManager.getConnection(url, properties);
			Statement statement ;
			statement = connection.createStatement();
			
			statement.execute("DELETE FROM table "
							+ "where" + "'" + personId + "'" );
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


}
