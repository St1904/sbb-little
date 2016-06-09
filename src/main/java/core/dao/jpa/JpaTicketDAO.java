package core.dao.jpa;

import core.dao.api.JpaGenericDAO;
import core.dao.api.TicketDAO;
import core.dao.model.Ticket;

import javax.persistence.EntityManager;

public class JpaTicketDAO extends JpaGenericDAO<Ticket> implements TicketDAO {
    public JpaTicketDAO(EntityManager entityManager) {
        super(entityManager, Ticket.class);
    }
}
