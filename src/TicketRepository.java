
import java.util.List;

public interface TicketRepository {

	void save(Ticket ticket);
	
	Ticket findById(int ticketId);
	
	void deleteById(int ticketId);
	
	int count();
	
	List<Ticket> findAll();
}
