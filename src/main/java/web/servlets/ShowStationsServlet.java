package web.servlets;

import core.dao.model.Station;
import core.util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showStations")
public class ShowStationsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Station> stationList = ApplicationContext.getInstance().getStationService().showStations();
/*        for (Station station : stationList) {
            System.out.println(station);
        }*/
        req.setAttribute("stationList", stationList);
        req.getRequestDispatcher("showStations.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
