package core.dao.api;

import core.dao.model.BaseEntity;

import javax.persistence.EntityManager;

public abstract class JpaGenericDAO<T extends BaseEntity> implements GenericDAO<T> {
    private EntityManager entityManager;
    private Class<T> clazz;

    public JpaGenericDAO (EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public long create(T entity) {
        entityManager.persist(entity);
        return entity.getId();
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public T find(long id) {
        return entityManager.find(clazz, id);
    }
}
