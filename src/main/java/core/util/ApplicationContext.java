package core.util;

import core.dao.api.StationDAO;
import core.dao.jpa.JpaStationDAO;
import core.services.StationService;
import core.services.StationServiceImpl;

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


    public StationService getStationService() {
        return new StationServiceImpl(getStationDAO());
    }
}
