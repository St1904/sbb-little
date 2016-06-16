package core.dao.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Waypoint")
public class Waypoint extends BaseEntity {
    @Column(name = "arrival", nullable = false)
    private int arrival;

    @Column(name = "stay_count", nullable = false)
    private int stayCount;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route routeForWaypoint;

    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false)
    private Station station;

    public Waypoint() {
    }

    public int getArrival() {
        return arrival;
    }

    public void setArrival(int arrival) {
        this.arrival = arrival;
    }

    public int getStayCount() {
        return stayCount;
    }

    public void setStayCount(int stayCount) {
        this.stayCount = stayCount;
    }

    public Route getRouteForWaypoint() {
        return routeForWaypoint;
    }

    public void setRouteForWaypoint(Route routeForWaypoint) {
        this.routeForWaypoint = routeForWaypoint;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    @Override
    public String toString() {
        return "Waypoint{" +
                "arrival=" + arrival +
                ", stayCount=" + stayCount +
                ", routeForWaypoint=" + routeForWaypoint +
                ", station=" + station +
                '}';
    }
}
