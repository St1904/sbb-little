package core.dao.api;

import core.dao.model.Route;

import java.util.List;

public interface RouteDAO extends GenericDAO<Route> {
    public List<Route> findAll();
}
