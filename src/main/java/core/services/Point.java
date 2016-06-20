package core.services;

import core.dao.model.Station;

public class Point {
    public Station station;
    public int arrival;
    public int stay;

    public Point(Station station, int arrival, int stay) {
        this.station = station;
        this.arrival = arrival;
        this.stay = stay;
    }

    @Override
    public String toString() {
        return "Point{" +
                "station=" + station +
                ", arrival=" + arrival +
                ", stay=" + stay +
                '}';
    }
}
