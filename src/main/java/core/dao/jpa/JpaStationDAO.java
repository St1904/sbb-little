package core.dao.jpa;

import core.dao.api.JpaGenericDAO;
import core.dao.api.StationDAO;
import core.dao.model.Station;

import javax.persistence.EntityManager;

public class JpaStationDAO extends JpaGenericDAO<Station> implements StationDAO {
    private EntityManager entityManager;
    public JpaStationDAO(EntityManager entityManager) {
        super(entityManager, Station.class);
    }
}
