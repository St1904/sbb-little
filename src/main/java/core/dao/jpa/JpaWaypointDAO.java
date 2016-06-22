package core.dao.jpa;

import core.dao.api.JpaGenericDAO;
import core.dao.api.WaypointDAO;
import core.dao.model.Station;
import core.dao.model.TrainRoute;
import core.dao.model.Waypoint;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class JpaWaypointDAO extends JpaGenericDAO<Waypoint> implements WaypointDAO {
    public JpaWaypointDAO(EntityManager entityManager) {
        super(entityManager, Waypoint.class);
    }

    public Waypoint findByAll(TrainRoute trainRoute, Station station) {
        TypedQuery<Waypoint> query = entityManager.createQuery(
                "select w from Waypoint w inner join w.routeForWaypoint r where r.trainRoutes = :trainRoute and w.station = :station"
                , Waypoint.class)
                .setParameter("trainRoute", trainRoute)
                .setParameter("station", station);
        return query.getResultList().get(0);
    }
}
