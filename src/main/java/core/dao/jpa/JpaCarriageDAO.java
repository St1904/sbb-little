package core.dao.jpa;

import core.dao.api.CarriageDAO;
import core.dao.api.JpaGenericDAO;
import core.dao.model.Carriage;
import core.dao.model.TrainRoute;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaCarriageDAO extends JpaGenericDAO<Carriage> implements CarriageDAO {
    public JpaCarriageDAO(EntityManager entityManager) {
        super(entityManager, Carriage.class);
    }

    public List<Carriage> findAll() {
        return entityManager.createQuery(
                "select c from Carriage c"
                , Carriage.class)
                .getResultList();
    }

    public Carriage findByTrainRoute(TrainRoute trainRoute, int carriageNumber) {
        TypedQuery<Carriage> query = entityManager.createQuery(
                "select c from Carriage c inner join c.trainCarriages tc inner join tc.trainForCarriage t inner join t.TrainRoutes tr where tr = :trainRoute and tc.carriageNumber = :carriageNumber"
                , Carriage.class)
                .setParameter("trainRoute", trainRoute)
                .setParameter("carriageNumber", carriageNumber);
        return query.getResultList().get(0);
    }
}
