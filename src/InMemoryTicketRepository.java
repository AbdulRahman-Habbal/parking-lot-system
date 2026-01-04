
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class InMemoryTicketRepository implements TicketRepository {
	
	private Map<Integer, Ticket> tickets = new HashMap<>();
	
    @Override
    public void save(Ticket ticket) {
        tickets.put(ticket.getTicketId(), ticket);
    }
    
    @Override
    public Ticket findById(int ticketId) {
    	return tickets.get(ticketId);
    }
    
    @Override
    public void deleteById(int ticketId) {
    	tickets.remove(ticketId);
    }
    
    @Override
    public int count() {
    	return tickets.size();
    }
    
    @Override
    public List<Ticket> findAll() {
        return new ArrayList<>(tickets.values());
    }

}
