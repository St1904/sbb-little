package core.services;

import core.dao.api.DaoException;
import core.dao.api.RouteDAO;
import core.dao.api.TrainRouteDAO;
import core.dao.api.WaypointDAO;
import core.dao.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;
import java.util.ArrayList;
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

    public TrainRoute findTrainRouteById(long id) {
        return trainRouteDAO.find(id);
    }

    public List<Route> routesBetweenStations(Station start, Station finish) {
        List<Route> list = routeDAO.findBetweenStations(start, finish);
        List<Route> routes = new ArrayList<Route>();
        for (Route route : list) {
            Waypoint w1 = new Waypoint(), w2 = new Waypoint();
            for (Waypoint waypoint : route.getWaypoints()) {
                if (waypoint.getStation().getId() == start.getId()) {
                    w1 = waypoint;
                } else if (waypoint.getStation().getId() == finish.getId()) {
                    w2 = waypoint;
                }
            }
            if (w1.getArrival() < w2.getArrival()) {
                routes.add(route);
            }
        }
        return routes;
    }

    public List<TrainRoute> findByRoute(Route route) {
        return trainRouteDAO.findByRoute(route);
    }

    public List<TrainRoute> trainRoutesBetweenDates(List<TrainRoute> trainRouteList, Date start, Date finish) {
        List<TrainRoute> result = new ArrayList<TrainRoute>();
        for (TrainRoute trainRoute : trainRouteList) {
            Date date = trainRoute.getDate();
            Date time = trainRoute.getTime();
            Date full = new Date(date.getTime());
            full.setHours(time.getHours());
            full.setMinutes(time.getMinutes());
            full.setSeconds(time.getSeconds());
            if (full.getTime() >= start.getTime() && full.getTime() <= finish.getTime()) {
                result.add(trainRoute);
            }
        }
        return result;
    }

    public List<TrainRoute> findByStation(Station station) {
        return trainRouteDAO.findByStation(station);
    }
}
