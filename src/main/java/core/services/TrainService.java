package core.services;

import core.dao.model.Carriage;
import core.dao.model.Train;

import java.util.List;
import java.util.Set;

public interface TrainService {
    List<Train> showTrains();
    void addTrain(String name, List<Carriage> carriages);
    void addCarriage(Carriage carriage);
    Carriage findCarriageById(long id);
}
