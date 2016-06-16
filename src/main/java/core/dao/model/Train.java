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
    private Set<TrainRoute> TrainRoutes;

    @OneToMany(mappedBy = "trainForCarriage")
    private Set<TrainCarriage> TrainCarriages;

    public Train() {
    }

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

    public Set<TrainRoute> getTrainRoutes() {
        return TrainRoutes;
    }

    public void setTrainRoutes(Set<TrainRoute> trainRoutes) {
        TrainRoutes = trainRoutes;
    }

    public Set<TrainCarriage> getTrainCarriages() {
        return TrainCarriages;
    }

    public void setTrainCarriages(Set<TrainCarriage> trainCarriages) {
        TrainCarriages = trainCarriages;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + this.getId() + '\'' +
                "name='" + name + '\'' +
                ", seats=" + seats +
                '}';
    }
}
