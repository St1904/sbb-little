package web.servlets;

import core.dao.model.Station;
import core.util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/showStations")
public class ShowStationsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Station> stationList = ApplicationContext.getInstance().getStationService().showStations();
/*        for (Station station : stationList) {
            System.out.println(station);
        }*/

/*        String[] s = new String[3];
        s[0] = "s1";
        s[1] = "s2";
        s[2] = "s3";
        for (String ss : s) {
            System.out.println(ss);
        }
        req.setAttribute("strings", s);*/


/*
  //working in c:out
        String s = "Test string for jstl";
        req.setAttribute("testString", s);*/


/*        ArrayList<String> stationList = new ArrayList<String>();
        stationList.add("s1");
        stationList.add("s2");
        stationList.add("s3");*/


        req.setAttribute("stations", stationList);
        req.getRequestDispatcher("/WEB-INF/showStations.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
