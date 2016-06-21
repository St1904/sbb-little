package web.servlets;


import core.dao.api.DaoException;
import core.dao.model.Route;
import core.dao.model.Train;
import core.util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/admin/setTrainOnRoute")
public class TrainRouteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Train> trains = ApplicationContext.getInstance().getTrainService().showTrains();
        List<Route> routes = ApplicationContext.getInstance().getRouteService().showRoutes();

        req.setAttribute("trains", trains);
        req.setAttribute("routes", routes);
        req.getRequestDispatcher("/WEB-INF/setTrainOnRoute.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long trainId = Long.parseLong(req.getParameter("sTrain"));
        Train train = ApplicationContext.getInstance().getTrainService().findTrainById(trainId);

        long routeId = Long.parseLong(req.getParameter("sRoute"));
        Route route = ApplicationContext.getInstance().getRouteService().findRouteById(routeId);

        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = sdf.parse(req.getParameter("date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        sdf.applyPattern("HH:mm");
        Date time = new Date();
        try {
            time = sdf.parse(req.getParameter("time"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(req.getParameter("price")));

        try {
            ApplicationContext.getInstance().getRouteService().setTrainOnRoute(train, route, date, time, price);
            req.setAttribute("message", "Поезд назначен");
        } catch (DaoException e) {
//            e.printStackTrace();
            req.setAttribute("message", "Что-то пошло не так, попробуйте еще раз...");
        } finally {
            req.setAttribute("backUrl", "/sbb/admin/setTrainOnRoute");
            req.getRequestDispatcher("/WEB-INF/addSuccess.jsp").forward(req, resp);
        }
    }
}
