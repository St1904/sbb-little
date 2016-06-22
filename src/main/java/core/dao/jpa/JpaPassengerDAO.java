package core.dao.jpa;

import core.dao.api.JpaGenericDAO;
import core.dao.api.PassengerDAO;
import core.dao.model.Passenger;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;

public class JpaPassengerDAO extends JpaGenericDAO<Passenger> implements PassengerDAO {
    public JpaPassengerDAO(EntityManager entityManager) {
        super(entityManager, Passenger.class);
    }

    public Passenger findByAll(String name, String surname, Date birthdate) {
        TypedQuery<Passenger> query = entityManager.createQuery(
                "select p from Passenger p where p.name = :name and p.surname = :surname and p.birthdate = :birthdate"
                , Passenger.class)
                .setParameter("name", name)
                .setParameter("surname", surname)
                .setParameter("birthdate", birthdate);
        return query.getResultList().get(0);
    }
}
