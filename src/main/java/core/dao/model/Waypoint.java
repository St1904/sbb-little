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

    @ManyToMany
    @JoinColumn(name = "route_id")
    private Route routeForWaypoint;

    @ManyToMany
    @JoinColumn(name = "station_id")
    private Station station;
}
