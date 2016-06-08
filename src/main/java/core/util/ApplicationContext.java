package core.util;

import core.dao.api.StationDAO;
import core.dao.jpa.JpaStationDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ApplicationContext {
    private static ApplicationContext instance = new ApplicationContext();

    public static ApplicationContext getInstance() {
        return instance;
    }

    private ApplicationContext() {}

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit");
    private EntityManager entityManager;

    private StationDAO getStationDAO() {
        return new JpaStationDAO(getEntityManager());
    }

    public EntityManager getEntityManager() {
        if (entityManager == null) entityManagerFactory.createEntityManager();
        return entityManager;
    }
}
