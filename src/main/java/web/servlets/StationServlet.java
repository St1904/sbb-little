package web.servlets;

import core.dao.api.DaoException;
import core.dao.model.Station;
import core.util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/addStation")
public class StationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/addStation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("stationName");
        String suffix = req.getParameter("stationSuffix");
        try {
            ApplicationContext.getInstance().getStationService().addStation(new Station(name, suffix));
            req.setAttribute("message", "Новая станция успешно добавлена!");
        } catch (DaoException e) {
            req.setAttribute("message", "Ошибка добавления станции! Такая станция уже существует.");
        } finally {
            req.setAttribute("backUrl", "/sbb/admin/addStation");
            req.getRequestDispatcher("/WEB-INF/addSuccess.jsp").forward(req, resp);
        }
    }
}
