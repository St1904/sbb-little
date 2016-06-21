package core.services;

import core.dao.api.DaoException;
import core.dao.api.RouteDAO;
import core.dao.api.TrainRouteDAO;
import core.dao.api.WaypointDAO;
import core.dao.model.Route;
import core.dao.model.Train;
import core.dao.model.TrainRoute;
import core.dao.model.Waypoint;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class RouteServiceImpl implements RouteService {
    private EntityManager entityManager;
    private WaypointDAO waypointDAO;
    private RouteDAO routeDAO;
    private TrainRouteDAO trainRouteDAO;

    public RouteServiceImpl(EntityManager entityManager,
                            WaypointDAO waypointDAO,
                            RouteDAO routeDAO,
                            TrainRouteDAO trainRouteDAO) {
        this.entityManager = entityManager;
        this.waypointDAO = waypointDAO;
        this.routeDAO = routeDAO;
        this.trainRouteDAO = trainRouteDAO;
    }

    public void addRoute(String name, BigDecimal price, List<Point> points) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
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
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new DaoException(e);
        }
    }

    public List<Route> showRoutes() {
        return routeDAO.findAll();
    }

    public void setTrainOnRoute(Train train, Route route, Date date, Date time, BigDecimal price) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            TrainRoute trainRoute = new TrainRoute();
            trainRoute.setTrainForRoute(train);
            trainRoute.setRouteForTrain(route);
            trainRoute.setDate(date);
            trainRoute.setTime(time);
            trainRoute.setPriceCoef(price);
            trainRouteDAO.create(trainRoute);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new DaoException(e);
        }
    }

    public Route findRouteById(long id) {
        return routeDAO.find(id);
    }
}
