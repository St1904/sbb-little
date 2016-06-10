package core.dao.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Ticket")
public class Ticket extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "trainRoute_id", nullable = false)
    private TrainRoute trainRoute;

    @Column(name = "carriage_number", nullable = false)
    private int carriageNumber;

    @Column(name = "seat")
    private int seat;

    @ManyToOne
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "start_station", nullable = false)
    private Waypoint startStation;

    @ManyToOne
    @JoinColumn(name = "finish_station", nullable = false)
    private Waypoint finishStation;

    @Column(name = "price")
    private BigDecimal price;

    public Ticket() {
    }

    public TrainRoute getTrainRoute() {
        return trainRoute;
    }

    public void setTrainRoute(TrainRoute trainRoute) {
        this.trainRoute = trainRoute;
    }

    public int getCarriageNumber() {
        return carriageNumber;
    }

    public void setCarriageNumber(int carriageNumber) {
        this.carriageNumber = carriageNumber;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Waypoint getStartStation() {
        return startStation;
    }

    public void setStartStation(Waypoint startStation) {
        this.startStation = startStation;
    }

    public Waypoint getFinishStation() {
        return finishStation;
    }

    public void setFinishStation(Waypoint finishStation) {
        this.finishStation = finishStation;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
