package core.services;

import core.dao.api.StationDAO;
import core.dao.model.Station;

import java.util.List;

public class StationServiceImpl implements StationService {
    private StationDAO dao;

    public StationServiceImpl(StationDAO dao) {
        this.dao = dao;
    }

    public void addStation(Station station) {
        dao.create(station);
    }

    public List<Station> showStations() {
        return dao.findAll();
    }

    //public Station findByName(String name) {}
}
