package core.dao.api;

import core.dao.model.Carriage;

import java.util.List;

public interface CarriageDAO extends GenericDAO<Carriage> {
    List<Carriage> findAll();
}
