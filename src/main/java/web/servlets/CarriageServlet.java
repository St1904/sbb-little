package web.servlets;

import core.dao.api.DaoException;
import core.util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/admin/addCarriage")
public class CarriageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/addCarriage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Integer capacity = Integer.parseInt(req.getParameter("capacity"));
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(req.getParameter("price")));
        try {
            ApplicationContext.getInstance().getTrainService().addCarriage(name, capacity, price);
            req.setAttribute("message", "Это что-то новенькое, добавляем...");
        } catch (DaoException e) {
            req.setAttribute("message", "Такой вагон уже есть, придумайте что-нибудь новое");
        } finally {
            req.setAttribute("backUrl", "/sbb/admin/addCarriage");
            req.getRequestDispatcher("/WEB-INF/addSuccess.jsp").forward(req, resp);
        }
    }
}
