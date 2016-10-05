package domain.chatbox;
import java.util.ArrayList;
import java.util.Date;

import domain.Account;
public class Ticket {

	private String question;
	private String status;
	private Account account;
	private ArrayList<Account> mentors;
	private boolean important;
	private Date startdate;
	
	/*
	 * Een ticket is een vraag naar 1 of meerdere begeleiders
	 * Een ervaringsdeskundige kan een antwoord terugsturen zonder dat dit een definitief antwoord moet zijn
	 * bv: een bevestegingsmail om hulp te vragen aan een docter of andere ervaringsdeskundige.
	 */
	
	
	public Ticket(String question, Account account, ArrayList<Account> mentors, boolean important, Date startdate) 
	{
		this.setQuestion(question);
		this.setAccount(account);
		this.setMentors(mentors);
		this.setImportant(important);
		this.setStartDate(startdate);
		
	}

	private void setStartDate(Date startdate) {
		this.startdate = startdate;
		
	}

	private void setImportant(boolean important) {
		this.important = important;
	}

	private void setMentors(ArrayList<Account> mentors) {
		this.mentors = mentors;
	}
	
	public void addMentor(Account account)
	{
		this.mentors.add(account);
	}

	private void setAccount(Account account) {
		this.account = account;
	}

	private void setQuestion(String question) {
		this.question = question;
	}

}
