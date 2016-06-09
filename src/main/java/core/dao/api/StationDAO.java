package core.dao.api;

import core.dao.model.Station;

import javax.persistence.EntityManager;
import java.util.List;

public interface StationDAO extends GenericDAO<Station> {
    List<Station> findAll();
}
