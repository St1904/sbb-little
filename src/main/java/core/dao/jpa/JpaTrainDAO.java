package core.dao.jpa;

import core.dao.api.JpaGenericDAO;
import core.dao.api.TrainDAO;
import core.dao.model.Train;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class JpaTrainDAO extends JpaGenericDAO<Train> implements TrainDAO {
    public JpaTrainDAO(EntityManager entityManager) {
        super(entityManager, Train.class);
    }

    public List<Train> findAll() {
        return (List<Train>) entityManager.createQuery("select c from Train c").getResultList();
    }

    public Train findByName(String name) {
        Query query = entityManager.createQuery("select c from Train c where c.name = :name");
        query.setParameter("name", name);
        return (Train) query.getSingleResult();
    }
}
