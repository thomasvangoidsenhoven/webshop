package domain.chatbox;

import java.util.ArrayList;

public class TicketDB {
	private ArrayList<Ticket> ticketDatabase;
	
	public TicketDB()
	{
		this.ticketDatabase = new ArrayList<>();
	}

	public ArrayList<Ticket> getTicketDatabase() {
		return this.ticketDatabase;
	}
	
	public void addTicket(Ticket ticket)
	{
		this.getTicketDatabase().add(ticket);
	}
	
	
}
