package core.dao.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "TrainRoute")
public class TrainRoute extends BaseEntity {
    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "time_start", nullable = false)
    private Time time;

    @Column(name = "price_coef", nullable = false)
    private BigDecimal priceCoef;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route routeForTrain;

    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false)
    private Train trainForRoute;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
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
}
