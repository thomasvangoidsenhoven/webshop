package pageobjects;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Index {
	private WebDriver driver;
	private static final String URL = "http://java.cyclone2.khleuven.be:38034/bmi/faces/login.xhtml";
	
	public Index(WebDriver driver)
	{
		System.setProperty("webdriver.gecko.driver","/home/spooked/UCLL/Java/web/geckodriver");
		this.driver = driver;
		driver.get(URL);
	}
	
	public void setUsername(String username)
	{
		driver.findElement(By.id("loginForm:personId")).clear();
	    driver.findElement(By.id("loginForm:personId")).sendKeys(username);
	    
	}
	
	public void setPassword(String password)
	{
		driver.findElement(By.id("loginForm:password")).click();
		driver.findElement(By.id("loginForm:password")).clear();
		driver.findElement(By.id("loginForm:password")).sendKeys(password);
	}
	
	public void click()
	{
		driver.findElement(By.id("loginForm:login")).click();
	}
	
	public boolean loginSuccesful ()
	{
		try {
			if(driver.findElement(By.cssSelector("h2")).getText().equals("Persons")) return true;
		    } catch (org.openqa.selenium.NoSuchElementException e) {
		     	return false;
		    }
		
		return false;
	}
	
	public boolean loginUnsuccesful()
	{
		try{
			if(driver.findElement(By.cssSelector("li")).getText().equals("Invalid userid/password combination"))return true;;
		}
		catch (org.openqa.selenium.NoSuchElementException e)
		{
			return false;
		}
		return false;
	}
}
