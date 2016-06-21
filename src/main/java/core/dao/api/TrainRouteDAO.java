package core.dao.api;

import core.dao.model.Route;
import core.dao.model.TrainRoute;

import java.util.Date;
import java.util.List;

public interface TrainRouteDAO extends GenericDAO<TrainRoute> {
    List<TrainRoute> findByRoute(Route route);
}
