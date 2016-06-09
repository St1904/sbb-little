package core.util;

import core.dao.api.StationDAO;
import core.dao.jpa.JpaStationDAO;

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

    private StationDAO getStationDAO() {
        return new JpaStationDAO(getEntityManager());
    }

    private EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) entityManagerFactory = Persistence.createEntityManagerFactory("persistence_util");
        return entityManagerFactory;
    }

    public EntityManager getEntityManager() {
        if (entityManager == null) entityManager = getEntityManagerFactory().createEntityManager();
        return entityManager;
    }
}
