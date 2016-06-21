package core.dao.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "TrainRoute")
public class TrainRoute extends BaseEntity {
    @Temporal(value = TemporalType.DATE)
    @Column(name = "date", nullable = false)
    private Date date;

    @Temporal(value = TemporalType.TIME)
    @Column(name = "time_start", nullable = false)
    private Date time;

    @Column(name = "price_coef", nullable = false)
    private BigDecimal priceCoef;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route routeForTrain;

    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false)
    private Train trainForRoute;

    public TrainRoute() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public BigDecimal getPriceCoef() {
        return priceCoef;
    }

    public void setPriceCoef(BigDecimal priceCoef) {
        this.priceCoef = priceCoef;
    }

    public Route getRouteForTrain() {
        return routeForTrain;
    }

    public void setRouteForTrain(Route routeForTrain) {
        this.routeForTrain = routeForTrain;
    }

    public Train getTrainForRoute() {
        return trainForRoute;
    }

    public void setTrainForRoute(Train trainForRoute) {
        this.trainForRoute = trainForRoute;
    }

    public String toString() {
        return "id=" + this.getId() +
                " train_id=" + this.getTrainForRoute().getId() +
                " route_id=" + this.getRouteForTrain().getId() +
                " date=" + this.getDate() +
                " time=" + this.getTime();
    }
}
