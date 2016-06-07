package core.dao.api;

import core.dao.model.BaseEntity;

interface GenericDAO<T extends BaseEntity> {
    long create(T entity);
    void update(T entity);
    void delete(T entity);
    T find(long id);
}
