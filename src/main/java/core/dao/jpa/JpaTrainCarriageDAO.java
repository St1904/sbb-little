package core.dao.jpa;

import core.dao.api.JpaGenericDAO;
import core.dao.api.TrainCarriageDAO;
import core.dao.model.TrainCarriage;

import javax.persistence.EntityManager;

public class JpaTrainCarriageDAO extends JpaGenericDAO<TrainCarriage> implements TrainCarriageDAO {
    public JpaTrainCarriageDAO(EntityManager entityManager) {
        super(entityManager, TrainCarriage.class);
    }
}
