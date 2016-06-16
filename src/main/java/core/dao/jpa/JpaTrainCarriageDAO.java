package core.dao.jpa;

import core.dao.api.JpaGenericDAO;
import core.dao.api.TrainCarriageDAO;
import core.dao.model.Carriage;
import core.dao.model.Train;
import core.dao.model.TrainCarriage;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class JpaTrainCarriageDAO extends JpaGenericDAO<TrainCarriage> implements TrainCarriageDAO {
    public JpaTrainCarriageDAO(EntityManager entityManager) {
        super(entityManager, TrainCarriage.class);
    }

    public List<Carriage> findByTrain(Train train) {
        Query query = entityManager.createQuery("select c.carriage from TrainCarriage c where c.trainForCarriage = :train");
        query.setParameter("train", train);
        return (List<Carriage>) query.getResultList();
    }
}
