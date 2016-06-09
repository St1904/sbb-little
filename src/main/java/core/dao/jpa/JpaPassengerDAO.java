package core.dao.jpa;

import core.dao.api.JpaGenericDAO;
import core.dao.api.PassengerDAO;
import core.dao.model.Passenger;

import javax.persistence.EntityManager;

public class JpaPassengerDAO extends JpaGenericDAO<Passenger> implements PassengerDAO {
    public JpaPassengerDAO(EntityManager entityManager) {
        super(entityManager, Passenger.class);
    }
}
