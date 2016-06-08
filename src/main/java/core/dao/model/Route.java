package core.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "Route")
public class Route extends BaseEntity {
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "price_per_min", nullable = false, unique = true)
    private BigDecimal pricePerMinute;

    @OneToMany(mappedBy = "routeForWaypoint")
    private Set<Waypoint> waypoints;

    @OneToMany(mappedBy = "routeForTrain")
    private Set<TrainRoute> trainRoutes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPricePerMinute() {
        return pricePerMinute;
    }

    public void setPricePerMinute(BigDecimal pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }

    public Set<Waypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(Set<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }

    public Set<TrainRoute> getTrainRoutes() {
        return trainRoutes;
    }

    public void setTrainRoutes(Set<TrainRoute> trainRoutes) {
        this.trainRoutes = trainRoutes;
    }
}
