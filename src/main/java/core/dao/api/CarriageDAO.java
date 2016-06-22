package core.dao.api;

import core.dao.model.Carriage;
import core.dao.model.TrainRoute;

import java.util.List;

public interface CarriageDAO extends GenericDAO<Carriage> {
    List<Carriage> findAll();
    Carriage findByTrainRoute(TrainRoute trainRoute, int carriageNumber);
}
