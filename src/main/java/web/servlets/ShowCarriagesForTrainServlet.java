package web.servlets;

import core.dao.model.Carriage;
import core.dao.model.Train;
import core.util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/showCarriagesForTrain")
public class ShowCarriagesForTrainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Train train = ApplicationContext.getInstance().getTrainService().findTrainById(Long.parseLong(req.getParameter("trainId")));
        List<Carriage> carriageList = ApplicationContext.getInstance().getTrainService().findCarriagesByTrain(train);
        req.setAttribute("carriages", carriageList);
        req.getRequestDispatcher("/WEB-INF/showCarriagesForTrain.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
