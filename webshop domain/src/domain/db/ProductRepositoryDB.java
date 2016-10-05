package domain.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import domain.model.Person;
import domain.model.Product;

public class ProductRepositoryDB implements ProductRepository {
	private Properties properties;
	private String url;
	
	public ProductRepositoryDB() {
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
	public Product get(String productId) {
		Product output = null;
		
		try
		{
			Connection connection = DriverManager.getConnection(url,properties);
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("Select * from r0630439.person");
			while(resultset.next())
			{
				String productid = resultset.getString("productid");
				if(productid.equals(productId))
				{
					String description = resultset.getString("description");
					double price = Double.parseDouble(resultset.getString("price"));
					Product product = new Product(productid, description, price);
					output = product;
				}
				
			}
			
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return output;
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String ProductId) {
		// TODO Auto-generated method stub
		
	}

}
