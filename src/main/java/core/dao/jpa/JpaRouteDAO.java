package core.dao.jpa;

import core.dao.api.JpaGenericDAO;
import core.dao.api.RouteDAO;
import core.dao.model.Route;

import javax.persistence.EntityManager;

public class JpaRouteDAO extends JpaGenericDAO<Route> implements RouteDAO {
    public JpaRouteDAO(EntityManager entityManager) {
        super(entityManager, Route.class);
    }
}
