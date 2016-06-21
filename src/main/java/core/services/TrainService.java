package core.services;

import core.dao.model.Carriage;
import core.dao.model.Train;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface TrainService {

    void addCarriage(String type, int capacity, BigDecimal price);
    void addTrain(String name, Map<Carriage, Integer> map);

    List<Train> showTrains();

    Carriage findCarriageById(long id);
    Train findTrainById(long id);
    Train findTrainByName(String name);

    List<Carriage> findCarriagesByTrain(Train train);
    List<Carriage> showCarriages();
}
