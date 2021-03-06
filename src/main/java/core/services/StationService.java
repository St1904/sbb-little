package core.services;

import core.dao.model.Station;

import java.util.List;

public interface StationService {
    void addStation(Station station);
    List<Station> showStations();
    Station findById(long id);
    //Station findByName(String name);
}
