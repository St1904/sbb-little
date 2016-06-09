package core.dao.jpa;

import core.dao.api.JpaGenericDAO;
import core.dao.api.TrainDAO;
import core.dao.model.Train;

import javax.persistence.EntityManager;

public class JpaTrainDAO extends JpaGenericDAO<Train> implements TrainDAO {
    public JpaTrainDAO(EntityManager entityManager) {
        super(entityManager, Train.class);
    }
}
