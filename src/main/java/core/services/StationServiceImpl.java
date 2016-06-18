package core.services;

import core.dao.api.DaoException;
import core.dao.api.StationDAO;
import core.dao.model.Station;

import javax.persistence.EntityManager;
import java.util.List;

public class StationServiceImpl implements StationService {
    private StationDAO dao;
    private EntityManager entityManager;

    public StationServiceImpl(EntityManager entityManager, StationDAO dao) {
        this.entityManager = entityManager;
        this.dao = dao;
    }

    public void addStation(Station station) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            dao.create(station);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DaoException(e);
        }
    }

    public List<Station> showStations() {
        return dao.findAll();
    }

    public Station findById(long id) {
        return dao.find(id);
    }

    //public Station findByName(String name) {}
}
