package core.dao.jpa;

import core.dao.api.JpaGenericDAO;
import core.dao.api.TrainDAO;
import core.dao.model.Train;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaTrainDAO extends JpaGenericDAO<Train> implements TrainDAO {
    public JpaTrainDAO(EntityManager entityManager) {
        super(entityManager, Train.class);
    }

    public List<Train> findAll() {
        return entityManager.createQuery("select c from Train c", Train.class).getResultList();
    }

    public Train findByName(String name) {
        TypedQuery<Train> query = entityManager.createQuery("select c from Train c where c.name = :name", Train.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
