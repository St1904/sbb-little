package core.services;

import core.dao.api.TrainCarriageDAO;
import core.dao.api.TrainDAO;
import core.dao.model.Carriage;
import core.dao.model.Train;
import core.dao.model.TrainCarriage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TrainServiceImpl implements TrainService {
    private TrainDAO trainDAO;
    private TrainCarriageDAO trainCarriageDAO;

    public TrainServiceImpl(TrainDAO trainDAO, TrainCarriageDAO trainCarriageDAO) {
        this.trainDAO = trainDAO;
        this.trainCarriageDAO = trainCarriageDAO;
    }

    public List<Train> showTrains() {
        return trainDAO.findAll();
    }

    public void addTrain(String name, Set<Carriage> carriages) {
        Train train = new Train();
        train.setName(name);

        int seats = 0;
        for (Carriage carriage : carriages) {
            seats += carriage.getCapacity();
        }
        train.setSeats(seats);
        trainDAO.create(train);

        int carriageNumber = 0;
        TrainCarriage trainCarriage;
        for (Carriage carriage : carriages) {
            carriageNumber++;
            trainCarriage = new TrainCarriage();
            trainCarriage.setCarriage(carriage);
            trainCarriage.setCarriageNumber(carriageNumber);
            trainCarriage.setTrainForCarriage(train);
            trainCarriageDAO.create(trainCarriage);
        }
    }
}
