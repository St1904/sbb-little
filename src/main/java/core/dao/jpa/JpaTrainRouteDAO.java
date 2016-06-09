package core.dao.jpa;

import core.dao.api.JpaGenericDAO;
import core.dao.api.TrainRouteDAO;
import core.dao.model.TrainRoute;

import javax.persistence.EntityManager;

public class JpaTrainRouteDAO extends JpaGenericDAO<TrainRoute> implements TrainRouteDAO {
    public JpaTrainRouteDAO(EntityManager entityManager) {
        super(entityManager, TrainRoute.class);
    }
}
