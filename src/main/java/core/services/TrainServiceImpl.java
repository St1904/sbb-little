package core.services;

import core.dao.api.CarriageDAO;
import core.dao.api.TrainCarriageDAO;
import core.dao.api.TrainDAO;
import core.dao.model.Carriage;
import core.dao.model.Train;
import core.dao.model.TrainCarriage;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class TrainServiceImpl implements TrainService {
    private TrainDAO trainDAO;
    private TrainCarriageDAO trainCarriageDAO;
    private CarriageDAO carriageDAO;

    public TrainServiceImpl(TrainDAO trainDAO, TrainCarriageDAO trainCarriageDAO, CarriageDAO carriageDAO) {
        this.trainDAO = trainDAO;
        this.trainCarriageDAO = trainCarriageDAO;
        this.carriageDAO = carriageDAO;
    }

    public void addCarriage(String type, int capacity, BigDecimal price) {
        carriageDAO.create(new Carriage(type, capacity, price));
    }

    public void addTrain(String name, Map<Carriage, Integer> map) {
        Train train = new Train();
        train.setName(name);

        int seats = 0;
        for (Map.Entry<Carriage, Integer> pair : map.entrySet()) {
            seats += pair.getKey().getCapacity() * pair.getValue();
        }
        train.setSeats(seats);
        trainDAO.create(train);

        TrainCarriage trainCarriage;
        int count = 0;
        for (Map.Entry<Carriage, Integer> pair : map.entrySet()) {
            for (int i = 1; i <= pair.getValue(); i++) {
                trainCarriage = new TrainCarriage();
                trainCarriage.setCarriage(pair.getKey());
                trainCarriage.setCarriageNumber(i + count);
                trainCarriage.setTrainForCarriage(train);
                trainCarriageDAO.create(trainCarriage);
            }
            count += pair.getValue();
        }
    }

    public List<Train> showTrains() {
        return trainDAO.findAll();
    }

    public Carriage findCarriageById(long id) {
        return carriageDAO.find(id);
    }

    public Train findTrainByName(String name) {
        return trainDAO.findByName(name);
    }

    public List<Carriage> showCarriages(Train train) {
        return trainCarriageDAO.findByTrain(train);
    }
}
