package core.services;

import core.dao.api.*;
import core.dao.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TicketServiceImpl implements TicketService {
    private EntityManager entityManager;
    private TrainRouteDAO trainRouteDAO;
    private TicketDAO ticketDAO;
    private PassengerDAO passengerDAO;
    private WaypointDAO waypointDAO;
    private CarriageDAO carriageDAO;

    public TicketServiceImpl(EntityManager entityManager,
                             TrainRouteDAO trainRouteDAO,
                             TicketDAO ticketDAO,
                             PassengerDAO passengerDAO,
                             WaypointDAO waypointDAO,
                             CarriageDAO carriageDAO) {
        this.entityManager = entityManager;
        this.trainRouteDAO = trainRouteDAO;
        this.ticketDAO = ticketDAO;
        this.passengerDAO = passengerDAO;
        this.waypointDAO = waypointDAO;
        this.carriageDAO = carriageDAO;
    }

    public void buyTicket(TrainRoute trainRoute, int carriageNumber, int[] fullSeatsArray, String name, String surname, Date birthdate, Station from, Station to) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Passenger passenger;
            if (ticketDAO.passengerNotFound(name, surname, birthdate)) {
                passenger = new Passenger();
                passenger.setName(name);
                passenger.setSurname(surname);
                passenger.setBirthdate(birthdate);
                passengerDAO.create(passenger);
            } else {
                passenger = passengerDAO.findByAll(name, surname, birthdate);
            }
            if (ticketDAO.passengerNotFoundOnTrain(passenger)
                    && (trainRoute.getFullDate().getTime() - new Date().getTime() >= 10 * 60 * 1000)) {
                Ticket ticket = new Ticket();
                ticket.setTrainRoute(trainRoute);
                ticket.setCarriageNumber(carriageNumber);
                ticket.setPassenger(passenger);

                Waypoint start = waypointDAO.findByAll(trainRoute, from);
                Waypoint finish = waypointDAO.findByAll(trainRoute, to);
                ticket.setStartStation(start);
                ticket.setStartStation(finish);

                //price
                int tripTime = finish.getArrival() - start.getArrival() - start.getStayCount();
                Route route = trainRoute.getRouteForTrain();
                Carriage carriage = carriageDAO.findByTrainRoute(trainRoute, carriageNumber);
                BigDecimal price = route.getPricePerMinute()
                        .multiply(BigDecimal.valueOf(tripTime))
                        .multiply(trainRoute.getPriceCoef())
                        .add(carriage.getPriceForCarriage());
                ticket.setPrice(price);

                //seat
                ticket.setSeat(fullSeatsArray[carriageNumber] + 1);

                ticketDAO.create(ticket);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new DaoException(e);
        }
    }

    public int[] fullSeatsArray(TrainRoute trainRoute, Waypoint start, Waypoint finish) {
        List<Ticket> tickets = ticketDAO.showTicketsForTrainRoute(trainRoute);
        int[] count = new int[tickets.size()];
        for (Ticket ticket : tickets) {
            if (start.getArrival() < ticket.getFinishStation().getArrival()
                    && finish.getArrival() > ticket.getStartStation().getArrival()) {
                count[ticket.getCarriageNumber()]++;
            }
        }
        return count;
    }

    public int countFreeSeats(List<Carriage> carriages, int[] fullSeatsArray) {
        int count = 0;
        for (int i = 0; i < carriages.size(); i++) {
            count += carriages.get(i).getCapacity() - fullSeatsArray[i];
        }
        return count;
    }
}
