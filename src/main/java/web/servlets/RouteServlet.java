package web.servlets;

import core.dao.api.DaoException;
import core.dao.model.Station;
import core.services.Point;
import core.util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin/addRoute")
public class RouteServlet extends HttpServlet {
    private List<Station>  stationList;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        stationList = ApplicationContext.getInstance().getStationService().showStations();
        req.setAttribute("stations", stationList);
        req.getRequestDispatcher("/WEB-INF/addRoute.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(req.getParameter("price")));
        String[] arrivals = req.getParameterValues("arrival");
        String[] stays = req.getParameterValues("stay");

        int arrival;
        int stay;
        List<Point> pointList = new ArrayList<Point>();
        for (int i = 0; i < stationList.size(); i++) {
            if (!"".equals(arrivals[i]) && !"".equals(stays[i])) {
                arrival = Integer.parseInt(arrivals[i]);
                stay = Integer.parseInt(stays[i]);
                pointList.add(new Point(stationList.get(i), arrival, stay));
            }
        }

        for (Point point : pointList) {
            System.out.println(point);
        }


        try {
            ApplicationContext.getInstance().getRouteService().addRoute(name, price, pointList);
            req.setAttribute("message", "Маршрут проложен!");
        } catch (DaoException e) {
            req.setAttribute("message", "Так не пойдет, надо что-то менять.");
        } catch (Throwable e) {
            req.setAttribute("message", "Это что-то совсем плохое случилось...");
            e.printStackTrace();
        } finally {
            req.setAttribute("backUrl", "/sbb/admin/addRoute");
            req.getRequestDispatcher("/WEB-INF/addSuccess.jsp").forward(req, resp);
        }
    }
}
