package core.services;

import core.dao.model.Carriage;
import core.dao.model.Station;
import core.dao.model.TrainRoute;
import core.dao.model.Waypoint;

import java.util.Date;
import java.util.List;

public interface TicketService {
    void buyTicket(TrainRoute trainRoute, int carriageNumber, int[] countSeats, String name, String surname, Date date, Station from, Station to);
    int[] fullSeatsArray(TrainRoute trainRoute, Waypoint start, Waypoint finish);
    int countFreeSeats(List<Carriage> carriages, int[] fullSeatsArray);
}
