package core.services;

import core.dao.model.Route;
import core.dao.model.Station;
import core.dao.model.Train;
import core.dao.model.TrainRoute;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface RouteService {
    void addRoute(String name, BigDecimal price, List<Point> points);
    List<Route> showRoutes();
    void setTrainOnRoute(Train train, Route route, Date date, Date time, BigDecimal price);
    Route findRouteById(long id);
    TrainRoute findTrainRouteById(long id);
    List<Route> routesBetweenStations(Station start, Station end);
    List<TrainRoute> findByRoute(Route route);
    List<TrainRoute> trainRoutesBetweenDates(List<TrainRoute> trainRouteList, Date start, Date finish);
}
