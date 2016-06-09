package core.dao.jpa;

import core.dao.api.JpaGenericDAO;
import core.dao.api.WaypointDAO;
import core.dao.model.Waypoint;

import javax.persistence.EntityManager;

public class JpaWaypointDAO extends JpaGenericDAO<Waypoint> implements WaypointDAO {
    public JpaWaypointDAO(EntityManager entityManager) {
        super(entityManager, Waypoint.class);
    }
}
