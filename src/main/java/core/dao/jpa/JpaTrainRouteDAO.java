package core.dao.jpa;

import core.dao.api.JpaGenericDAO;
import core.dao.api.TrainRouteDAO;
import core.dao.model.Route;
import core.dao.model.TrainRoute;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JpaTrainRouteDAO extends JpaGenericDAO<TrainRoute> implements TrainRouteDAO {
    public JpaTrainRouteDAO(EntityManager entityManager) {
        super(entityManager, TrainRoute.class);
    }

    public List<TrainRoute> findByRoute(Route route) {
        TypedQuery<TrainRoute> query = entityManager.createQuery("select tr from TrainRoute tr where tr.routeForTrain = :route", TrainRoute.class);
        query.setParameter("route", route);
        return query.getResultList();
    }
}
