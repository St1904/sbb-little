package core.dao.api;

import core.dao.model.Carriage;
import core.dao.model.Train;
import core.dao.model.TrainCarriage;

import java.util.List;

public interface TrainCarriageDAO extends GenericDAO<TrainCarriage> {
    List<Carriage> findByTrain(Train train);
}
