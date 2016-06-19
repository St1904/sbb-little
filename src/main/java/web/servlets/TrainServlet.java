package web.servlets;

import core.dao.model.Carriage;
import core.util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/admin/addTrain")
public class TrainServlet extends HttpServlet {
    List<Carriage> carriageList;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        carriageList = ApplicationContext.getInstance().getTrainService().showCarriages();

        req.setAttribute("carriages", carriageList);

        req.getRequestDispatcher("/WEB-INF/addTrain.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] carriageStringList = req.getParameterValues("carriageNumber");
        Map<Carriage, Integer> carriageMap = new HashMap<Carriage, Integer>();
        for (int i = 0; i < carriageStringList.length; i++) {
            carriageMap.put(carriageList.get(i), Integer.parseInt(carriageStringList[i]));
        }

        for (Map.Entry<Carriage, Integer> pair : carriageMap.entrySet()) {
            System.out.println("carriage: " + pair.getKey() + " number: " + pair.getValue());
        }
        String name = req.getParameter("name");

        ApplicationContext.getInstance().getTrainService().addTrain(name, carriageMap);

    }
}
