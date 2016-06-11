package core.services;

import java.math.BigDecimal;
import java.util.List;

public interface RouteService {
    void addRoute(String name, BigDecimal price, List<Point> points);
}
