package core.dao.api;

import core.dao.model.BaseEntity;

import javax.persistence.EntityManager;

public abstract class JpaGenericDAO<T extends BaseEntity> implements GenericDAO<T> {
    protected EntityManager entityManager;
    private Class<T> clazz;

    public JpaGenericDAO (EntityManager entityManager, Class<T> clazz) {
        this.entityManager = entityManager;
        this.clazz = clazz;
    }

    public long create(T entity) {
//        entityManager.getTransaction().begin();
        entityManager.persist(entity);
//        entityManager.getTransaction().commit();
        return entity.getId();
    }

    public void update(T entity) {
//        entityManager.getTransaction().begin();
        entityManager.merge(entity);
//        entityManager.getTransaction().commit();
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public T find(long id) {
        return entityManager.find(clazz, id);
    }
}
