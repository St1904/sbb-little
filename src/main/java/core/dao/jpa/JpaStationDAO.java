package core.dao.jpa;

import core.dao.api.JpaGenericDAO;
import core.dao.api.StationDAO;
import core.dao.model.Station;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaStationDAO extends JpaGenericDAO<Station> implements StationDAO {
    public JpaStationDAO(EntityManager entityManager) {
        super(entityManager, Station.class);
    }

    public List<Station> findAll() {
        return (List<Station>) entityManager.createQuery("Select c from Station c").getResultList();
    }
}
