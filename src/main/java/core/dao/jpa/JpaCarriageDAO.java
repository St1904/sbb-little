package core.dao.jpa;

import core.dao.api.CarriageDAO;
import core.dao.api.JpaGenericDAO;
import core.dao.model.Carriage;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaCarriageDAO extends JpaGenericDAO<Carriage> implements CarriageDAO {
    public JpaCarriageDAO(EntityManager entityManager) {
        super(entityManager, Carriage.class);
    }

    public List<Carriage> findAll() {
        return (List<Carriage>) entityManager.createQuery("select c from Carriage c").getResultList();
    }
}
