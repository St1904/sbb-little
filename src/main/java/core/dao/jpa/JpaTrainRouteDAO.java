package core.dao.jpa;

import core.dao.api.JpaGenericDAO;
import core.dao.api.TrainRouteDAO;
import core.dao.model.Route;
import core.dao.model.Station;
import core.dao.model.TrainRoute;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaTrainRouteDAO extends JpaGenericDAO<TrainRoute> implements TrainRouteDAO {
    public JpaTrainRouteDAO(EntityManager entityManager) {
        super(entityManager, TrainRoute.class);
    }

    public List<TrainRoute> findByRoute(Route route) {
        TypedQuery<TrainRoute> query = entityManager.createQuery(
                "select tr from TrainRoute tr where tr.routeForTrain = :route"
                , TrainRoute.class)
                .setParameter("route", route);
        return query.getResultList();
    }

    public List<TrainRoute> findByStation(Station station) {
        TypedQuery<TrainRoute> query = entityManager.createQuery(
                "select tr from TrainRoute tr inner join tr.routeForTrain r inner join r.waypoints ww where ww.station = :station and ww.stayCount <> 0"
                , TrainRoute.class)
                .setParameter("station", station);
        return query.getResultList();
    }
}
