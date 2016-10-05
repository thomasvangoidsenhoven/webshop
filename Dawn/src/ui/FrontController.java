package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Account;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Account> db = new ArrayList<>();
	private Account admin ;
	private ArrayList<String> openLinks = new ArrayList<>(Arrays.asList("0000000001","0000000002","0000000003","0000000004","0000000005","0000000006"));
	
    public FrontController() {
    	InternetAddress email = null;
		try {
			email = new InternetAddress("purecakegaming@gmail.com");
			admin = new Account("admin", "securepassword", email  , "", "admin");
	    	db.add(admin);
		} catch (AddressException e) {
			//shouldnt break
			e.printStackTrace();
		}
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = "login.jsp";
		String action = request.getParameter("action");
		if(action != null)
		{
			if(action.equals("registreer"))
			{
				destination = "register.jsp";
			}
			if(action.equals("doeregistreer"))
			{
				destination = doregister(request,response);
			}
			if(action.equals("doelogin"))
			{
				destination = dologin(request,response);
			}
		}
		
		RequestDispatcher view = request.getRequestDispatcher(destination);
		view.forward(request,response);
		
	}

	private String dologin(HttpServletRequest request, HttpServletResponse response) 
	{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		for(Account account : db)
		{
			if(account.getEmail().getAddress().equals(email) && account.getPassword().equals(password)) {
				request.setAttribute("session", account);
				return "dashboard.jsp";
			}
		}
		System.out.println(email + password + "failed login attempt");
		request.setAttribute("errormessage", "Email en/of paswoord incorrect.");
		return "login.jsp";
	}

	private String doregister(HttpServletRequest request, HttpServletResponse response) 
	{
		//haal input uit request
		ArrayList<String> errormessage = new ArrayList<>();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String confirm = request.getParameter("confirm");
		String link = request.getParameter("code");
		String number = request.getParameter("number");
		
		InternetAddress addres = null;
		//validatie
		if(!Account.isValidNaam(name))  errormessage.add("ongeldige naam");
		try {
			addres = new InternetAddress(email);
			addres.validate();
		} catch (AddressException e) {
			errormessage.add("ongeldig email adres");
		}
		if(password.equals("") || !password.equals(confirm) ) errormessage.add("paswoorden komen niet overeen.");
		if(!Account.isValidNumber(number)) errormessage.add("Ongeldig nummer");
		if(!Account.isValidRegistrationLink(link, openLinks)) errormessage.add("ongeldige registratiecode");
		
		
		//redirect op juise input	
		if(errormessage.size() == 0) 
		{
			db.add(new Account(name, password, addres, number , link));
			return "login.jsp";
		}
		
		//redirect op foute input + geef foutmeldingen door
		request.setAttribute("errormessage", errormessage);
		return "register.jsp";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	


}
