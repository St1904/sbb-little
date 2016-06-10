package core.util;

import core.dao.api.CarriageDAO;
import core.dao.api.StationDAO;
import core.dao.api.TrainCarriageDAO;
import core.dao.api.TrainDAO;
import core.dao.jpa.JpaCarriageDAO;
import core.dao.jpa.JpaStationDAO;
import core.dao.jpa.JpaTrainCarriageDAO;
import core.dao.jpa.JpaTrainDAO;
import core.services.StationService;
import core.services.StationServiceImpl;
import core.services.TrainService;
import core.services.TrainServiceImpl;

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

    public EntityManager getEntityManager() {
        if (entityManager == null) entityManager = getEntityManagerFactory().createEntityManager();
        return entityManager;
    }


    public StationDAO getStationDAO() {
        return new JpaStationDAO(getEntityManager());
    }
    public CarriageDAO getCarriageDAO() {
        return new JpaCarriageDAO(getEntityManager());
    }
    public TrainDAO getTrainDAO() {
        return new JpaTrainDAO(getEntityManager());
    }
    public TrainCarriageDAO getTrainCarriageDAO() {
        return new JpaTrainCarriageDAO(getEntityManager());
    }


    public StationService getStationService() {
        return new StationServiceImpl(getStationDAO());
    }
    public TrainService getTrainService() {
        return new TrainServiceImpl(getTrainDAO(), getTrainCarriageDAO());
    }
}
