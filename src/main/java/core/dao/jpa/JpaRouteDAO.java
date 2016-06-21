package core.dao.jpa;

import core.dao.api.JpaGenericDAO;
import core.dao.api.RouteDAO;
import core.dao.model.Route;
import core.dao.model.Station;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaRouteDAO extends JpaGenericDAO<Route> implements RouteDAO {
    public JpaRouteDAO(EntityManager entityManager) {
        super(entityManager, Route.class);
    }

    public List<Route> findAll() {
        return entityManager.createQuery("Select c from Route c", Route.class).getResultList();
    }

    public List<Route> findBetweenStations(Station start, Station finish) {
        TypedQuery<Route> query = entityManager.createQuery("select r from Route r join r.waypoints w1 join r.waypoints w2 where w1.station = :start and w2.station = :finish", Route.class);
        query.setParameter("start", start);
        query.setParameter("finish", finish);
        return query.getResultList();
    }
}
