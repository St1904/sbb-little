package core.services;

import core.dao.api.DaoException;
import core.dao.api.RouteDAO;
import core.dao.api.WaypointDAO;
import core.dao.model.Route;
import core.dao.model.Waypoint;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class RouteServiceImpl implements RouteService {
    private EntityManager entityManager;
    private WaypointDAO waypointDAO;
    private RouteDAO routeDAO;
    public RouteServiceImpl(EntityManager entityManager, WaypointDAO waypointDAO, RouteDAO routeDAO) {
        this.entityManager = entityManager;
        this.waypointDAO = waypointDAO;
        this.routeDAO = routeDAO;
    }

    public void addRoute(String name, BigDecimal price, List<Point> points) {
        try {
            entityManager.getTransaction().begin();
            Route route = new Route();
            route.setName(name);
            route.setPricePerMinute(price);
            routeDAO.create(route);

            Waypoint waypoint;
            for (Point point : points) {
                waypoint = new Waypoint();
                waypoint.setStation(point.station);
                waypoint.setArrival(point.arrival);
                waypoint.setStayCount(point.stay);
                waypoint.setRouteForWaypoint(route);
                waypointDAO.create(waypoint);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DaoException(e);
        }
    }

    public List<Route> showRoutes() {
        return routeDAO.findAll();
    }
}
