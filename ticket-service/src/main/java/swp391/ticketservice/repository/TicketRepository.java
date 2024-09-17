package swp391.ticketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swp391.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, String> {
}
