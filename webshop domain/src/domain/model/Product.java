package domain.model;

public class Product {
	//id, description, price
	
	private String id;
	private String description;
	private double price;
	
	public Product(String id, String description, double price)
	{
		this.setId(id);
		this.setDescription(description);
		this.setPrice(price);
	}

	private void setPrice(double price) {
		this.price = price;
		
	}

	private void setDescription(String description) {
		this.description = description;
	}

	private void setId(String id) {
		this.id = id;
	}
	
	public String getId()
	{
		return this.id;
	}
	public double getPrice()
	{
		return this.price;
	}
	
	public String description()
	{
		return this.description;
	}
}
