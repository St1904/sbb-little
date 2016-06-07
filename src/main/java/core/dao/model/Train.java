package core.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "Train")
public class Train extends BaseEntity {
    @Column(name = "name", nullable = false, length = 45, unique = true)
    private String name;

    @Column(name = "seats", nullable = false)
    private int seats;

    @OneToMany(mappedBy = "trainForRoute")
    private Set<Route> routes;

    @OneToMany(mappedBy = "trainForCarriage")
    private Set<Carriage> carriages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Set<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(Set<Route> routes) {
        this.routes = routes;
    }

    public Set<Carriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(Set<Carriage> carriages) {
        this.carriages = carriages;
    }
}
