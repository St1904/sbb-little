package core.dao.jpa;

import core.dao.api.JpaGenericDAO;
import core.dao.api.TicketDAO;
import core.dao.model.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class JpaTicketDAO extends JpaGenericDAO<Ticket> implements TicketDAO {
    public JpaTicketDAO(EntityManager entityManager) {
        super(entityManager, Ticket.class);
    }

    public boolean passengerNotFoundOnTrain(Passenger passenger) {
        TypedQuery<Ticket> query = entityManager.createQuery(
                "select t from Ticket t where t.passenger = :passenger"
                , Ticket.class)
                .setParameter("passenger", passenger);
        return !query.getResultList().isEmpty();
    }

    public boolean passengerNotFound(String name, String surname, Date birthdate) {
        TypedQuery<Ticket> query = entityManager.createQuery(
                "select p from Passenger p where p.name = :name and p.surname = :surname and p.birthdate = :birthdate"
                , Ticket.class)
                .setParameter("name", name)
                .setParameter("surname", surname)
                .setParameter("birthdate", birthdate);
        return query.getResultList().isEmpty();
    }

    public List<Ticket> showTicketsForTrainRoute(TrainRoute trainRoute) {
        TypedQuery<Ticket> query = entityManager.createQuery(
                "select t from Ticket t where t.trainRoute = :trainRoute"
                , Ticket.class)
                .setParameter("trainRoute", trainRoute);
        return query.getResultList();
    }

    public List<Passenger> findAllPassengers(TrainRoute trainRoute) {
        TypedQuery<Passenger> query = entityManager.createQuery(
                "select t.passenger from Ticket t where t.trainRoute = :trainRoute"
                , Passenger.class)
                .setParameter("trainRoute", trainRoute);
        return query.getResultList();
    }
}
