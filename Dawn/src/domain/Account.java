package domain;

import java.util.ArrayList;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Account {
	private String username;
	private String password;
	//convert to subtype
	private InternetAddress email;
	private String number;
	private String accountType;//normaal, ervaringsdeskundige, admin
	private String registrationLink;
	
	public Account(String username, String password, InternetAddress email, String number, String registrationLink)
	{
		this(username, password, email, number, "normaal", registrationLink);
	}
	
	public Account(String username, String password, InternetAddress email, String number, String registrationLink, String AccountType)
	{
		this.setUsername(username);
		this.setPassword(password);
		this.setEmail(email);
		this.setNumber(number);
		this.setAccountType(AccountType);
		this.setRegistrationLink(registrationLink);
	}
	
	public static boolean isValidPassword(String password)
	{
		if(password == null) return false;
		//paswoord moet min 6 - 16 characters lang zijn en een hoofdletter of cijfer bevatten!
		if(password.length() > 6 && password.length() < 17 && password.matches(".*[^a-z].*") && password.matches(".*[^A-Z].*"))
		{
			return true;
		}
		return false;
	}
	
	public static boolean isValidNaam(String naam)
	{
		if(naam == null) return false;
		//hoofdletter+ spatie > 6  && < 25 
		if(naam.length() > 6 && naam.length() < 25 && naam.contains(" ") && naam.matches(".*[^A-Z].*"))
		{
			return true;
		}
		return false;
	}
	
	public static boolean isValidNumber(String number)
	{
		if(number == null) return false;
		if(number.length() == 10)
		{
			for(int i = 0; i < number.length(); i++)
			{
				if(!Character.isDigit(number.charAt(i)))
				{
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	public static boolean isValidRegistrationLink(String link, ArrayList<String> linkList)
	{
		if(link == null || linkList == null) return false;
		if(link.length() == 10)
		{
			if(linkList.contains(link)) return true;
		}
		return false;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getUsername()
	{
		return this.username;
	}
	
	public void setEmail(InternetAddress email)
	{

		this.email = email;	
	}
	
	public InternetAddress getEmail()
	{
		return this.email;
	}
	
	public void setNumber(String number)
	{
		this.number = number;
	}
	
	public String getNumber()
	{
		return this.number;
	}
	
	public void setAccountType(String type)
	{
		this.accountType = type;
	}
	
	public String getAccountType()
	{
		return this.accountType;
	}
	
	public void setRegistrationLink(String link)
	{
		this.accountType = link;
	}
	
	public String getRegistrationLink()
	{
		return this.registrationLink;
	}
}
