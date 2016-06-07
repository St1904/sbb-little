package core.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ApplicationContext {
    private static ApplicationContext instance = new ApplicationContext();

    public static ApplicationContext getInstance() {
        return instance;
    }

    private ApplicationContext() {}

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistance_util");
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if (entityManager == null) entityManagerFactory.createEntityManager();
        return entityManager;
    }
}
