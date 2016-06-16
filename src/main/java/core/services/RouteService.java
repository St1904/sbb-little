package core.services;

import core.dao.model.Route;

import java.math.BigDecimal;
import java.util.List;

public interface RouteService {
    void addRoute(String name, BigDecimal price, List<Point> points);
    List<Route> showRoutes();
}
