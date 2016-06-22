package core.services;

import core.dao.model.Station;
import core.dao.model.TrainRoute;
import core.dao.model.Waypoint;

import java.util.Date;

public class TimeTable {
    private Station station;
    private TrainRoute trainRoute;
    private Waypoint waypoint;
    private Date timeArrival;
    private int timeStay;
    private Date timeToGo;

    public TimeTable(Station station, TrainRoute trainRoute, Waypoint waypoint) {
        this.station = station;
        this.trainRoute = trainRoute;
        this.waypoint = waypoint;
        this.timeArrival = new Date(trainRoute.getFullDate().getTime() + waypoint.getArrival() * 60000);
        this.timeStay = waypoint.getStayCount();
        this.timeToGo = new Date(timeArrival.getTime() + waypoint.getStayCount() * 60000);
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public TrainRoute getTrainRoute() {
        return trainRoute;
    }

    public void setTrainRoute(TrainRoute trainRoute) {
        this.trainRoute = trainRoute;
    }

    public Waypoint getWaypoint() {
        return waypoint;
    }

    public void setWaypoint(Waypoint waypoint) {
        this.waypoint = waypoint;
    }

    public Date getTimeArrival() {
        return timeArrival;
    }

    public int getTimeStay() {
        return timeStay;
    }

    public Date getTimeToGo() {
        return timeToGo;
    }

    public String toString() {
        return "TimeTable : \n"
                + "station.name : " + station.getName() + "\n"
                + " trainRoute.id : " + trainRoute.getId() + "\n"
                + " route.name : " + trainRoute.getRouteForTrain().getName() + "\n"
                + " train.name : " + trainRoute.getTrainForRoute().getName() + "\n"
                + " timeArrival : " + timeArrival + "\n"
                + " timeStay : " + timeStay + "\n"
                + " timeToGo : " + timeToGo;
    }
}
