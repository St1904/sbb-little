package core.services;

import core.dao.api.RouteDAO;
import core.dao.api.WaypointDAO;
import core.dao.model.Route;
import core.dao.model.Waypoint;

import java.math.BigDecimal;
import java.util.List;

public class RouteServiceImpl implements RouteService {
    private WaypointDAO waypointDAO;
    private RouteDAO routeDAO;
    public RouteServiceImpl(WaypointDAO waypointDAO, RouteDAO routeDAO) {
        this.waypointDAO = waypointDAO;
        this.routeDAO = routeDAO;
    }

    public void addRoute(String name, BigDecimal price, List<Point> points) {
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

    }
}
