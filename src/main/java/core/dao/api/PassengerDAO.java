package core.dao.api;

import core.dao.model.Passenger;

import java.util.Date;

public interface PassengerDAO extends GenericDAO<Passenger> {
    Passenger findByAll(String name, String surname, Date birthdate);
}
