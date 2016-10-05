package ui.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.db.PersonRepository;
import domain.db.PersonRepositoryDB;
import domain.db.PersonRepositoryInMemory;
import domain.db.ProductRepository;
import domain.db.ProductRepositoryDB;
import domain.model.Person;
import domain.model.Product;

/**
 * Servlet implementation class ShopServlet
 */
@WebServlet("/Controller")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonRepository personRepository = new PersonRepositoryDB();
    ProductRepository productRepository = new ProductRepositoryDB();
    public ShopServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = "index.jsp";
		String action = request.getParameter("action");
		if(action != null)
		{
			if(action.isEmpty())
			{
				destination = goToIndex(request,response);
						
			}
			if(action.equals("overview"))
			{
				
				destination = goToPersonOverview(request,response);
			}
			if(action.equals("signUp"))
			{
				destination = goToSignUp(request,response);
			}
			if(action.equals("createPerson"))
			{
				destination = createPerson(request,response);
			}
			if(action.equals("addProduct"))
			{
				destination = goToAddProduct(request, response);
			}
			if(action.equals("createProduct"))
			{
				destination = createProduct(request, response);
			}
			
		}
		
		RequestDispatcher view = request.getRequestDispatcher(destination);
		view.forward(request,response);
	}

	private String createProduct(HttpServletRequest request, HttpServletResponse response) {
		String productid = request.getParameter("productid");
		String description = request.getParameter("description");
		double price = Double.parseDouble(request.getParameter("price"));
		ArrayList<String> foutboodschappen = new ArrayList<>();
		if(productid.isEmpty()) foutboodschappen.add("id is leeg");
		if(description.isEmpty()) foutboodschappen.add("description is leeg");
		if(request.getParameter("price").isEmpty()) foutboodschappen.add("prijs is leeg");
		if(foutboodschappen.isEmpty())
		{
			Product product = new Product(productid, description, price);
			productRepository.add(product);
			return "index.jsp";
		}
		
		
		request.setAttribute("productid", productid);

		request.setAttribute("foutboodschappen", foutboodschappen);
		return this.goToAddProduct(request, response);
	}


	private String goToAddProduct(HttpServletRequest request, HttpServletResponse response) {
		return "addProduct.jsp";
	}


	private String createPerson(HttpServletRequest request, HttpServletResponse response) {
		String userID = request.getParameter("userid");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		ArrayList<String> foutboodschappen = new ArrayList<>();
		if(userID.isEmpty()) foutboodschappen.add("id is leeg");
		if(email.isEmpty()) foutboodschappen.add("email is leeg");
		if(password.isEmpty()) foutboodschappen.add("password is leeg");
		if(firstName.isEmpty()) foutboodschappen.add("firstName is leeg");
		if(lastName.isEmpty()) foutboodschappen.add("lastName is leeg");
		if(foutboodschappen.isEmpty())
		{
			Person person = new Person(userID, email, password, firstName, lastName);
			personRepository.add(person);
			return "index.jsp";
		}
		
		
		request.setAttribute("userid", userID);
		request.setAttribute("email", email);
		request.setAttribute("firstname", firstName);
		request.setAttribute("foutboodschappen", foutboodschappen);
		return goToSignUp(request, response);
		
	}


	private String goToSignUp(HttpServletRequest request, HttpServletResponse response) {
		
		return "signUp.jsp";
	}


	private String goToPersonOverview(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("personList", this.personRepository.getAll());
		return "personoverview.jsp";
	}


	private String goToIndex(HttpServletRequest request, HttpServletResponse response) {
		return "index.jsp";
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
