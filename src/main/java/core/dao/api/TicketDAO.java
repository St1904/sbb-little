package core.dao.api;

import core.dao.model.*;

import java.util.Date;
import java.util.List;

public interface TicketDAO extends GenericDAO<Ticket> {
    boolean passengerNotFoundOnTrain(Passenger passenger);
    boolean passengerNotFound(String name, String surname, Date birthdate);
    List<Ticket> showTicketsForTrainRoute(TrainRoute trainRoute);
    List<Passenger> findAllPassengers(TrainRoute trainRoute);
}
