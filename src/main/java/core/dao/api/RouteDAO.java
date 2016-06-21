package core.dao.api;

import core.dao.model.Route;
import core.dao.model.Station;

import java.util.List;

public interface RouteDAO extends GenericDAO<Route> {
    List<Route> findAll();
    List<Route> findBetweenStations(Station start, Station finish);
}
