package core.dao.api;

import core.dao.model.Station;
import core.dao.model.TrainRoute;
import core.dao.model.Waypoint;

public interface WaypointDAO extends GenericDAO<Waypoint> {
    Waypoint findByAll (TrainRoute trainRoute, Station station);
}
