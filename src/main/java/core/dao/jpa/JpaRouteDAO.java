package core.dao.jpa;

import core.dao.api.JpaGenericDAO;
import core.dao.api.RouteDAO;
import core.dao.model.Route;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaRouteDAO extends JpaGenericDAO<Route> implements RouteDAO {
    public JpaRouteDAO(EntityManager entityManager) {
        super(entityManager, Route.class);
    }

    public List<Route> findAll() {
        return (List<Route>) entityManager.createQuery("Select c from Route c").getResultList();
    }
}
