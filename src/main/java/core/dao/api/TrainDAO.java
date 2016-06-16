package core.dao.api;

import core.dao.model.Train;

import java.util.List;

public interface TrainDAO extends GenericDAO<Train> {
    List<Train> findAll();
    Train findByName(String name);
}
