package core.util;

import core.dao.api.*;
import core.dao.jpa.*;
import core.services.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ApplicationContext {
    private static final ApplicationContext instance = new ApplicationContext();

    public static ApplicationContext getInstance() {
        return instance;
    }

    private ApplicationContext() {}

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    private EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit");
        return entityManagerFactory;
    }

    private EntityManager getEntityManager() {
        if (entityManager == null) {
            entityManager = getEntityManagerFactory().createEntityManager();

            /*//added
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    entityManager.close();
                }
            });
            //end of added*/
        }
        return entityManager;
    }


    private StationDAO getStationDAO() {
        return new JpaStationDAO(getEntityManager());
    }
    private CarriageDAO getCarriageDAO() {
        return new JpaCarriageDAO(getEntityManager());
    }
    private TrainDAO getTrainDAO() {
        return new JpaTrainDAO(getEntityManager());
    }
    private TrainCarriageDAO getTrainCarriageDAO() {
        return new JpaTrainCarriageDAO(getEntityManager());
    }
    private WaypointDAO getWaypointDAO() {
        return new JpaWaypointDAO(getEntityManager());
    }
    private RouteDAO getRouteDAO() {
        return new JpaRouteDAO(getEntityManager());
    }
    private TrainRouteDAO getTrainRouteDAO() {
        return new JpaTrainRouteDAO(getEntityManager());
    }
    private TicketDAO getTicketDAO() {
        return new JpaTicketDAO(getEntityManager());
    }
    private PassengerDAO getPassengerDAO() {
        return new JpaPassengerDAO(getEntityManager());
    }


    public StationService getStationService() {
        return new StationServiceImpl(getEntityManager(), getStationDAO());
    }
    public TrainService getTrainService() {
        return new TrainServiceImpl(getEntityManager(), getTrainDAO(), getTrainCarriageDAO(), getCarriageDAO());
    }
    public RouteService getRouteService() {
        return new RouteServiceImpl(getEntityManager(), getWaypointDAO(), getRouteDAO(), getTrainRouteDAO());
    }
    public TicketService getTicketService() {
        return new TicketServiceImpl(getEntityManager(), getTrainRouteDAO(), getTicketDAO(), getPassengerDAO(), getWaypointDAO(), getCarriageDAO());
    }
}
