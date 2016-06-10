package core.dao.api;

import core.dao.model.Train;

import java.util.List;

public interface TrainDAO extends GenericDAO<Train> {
    public List<Train> findAll();
}
