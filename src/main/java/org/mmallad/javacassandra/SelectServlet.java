package org.mmallad.javacassandra;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mmallad
 * Date: 12/9/13
 * Time: 3:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class SelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Common.Connect();
        Map<Integer, Map> data = Common.cassandraCluster.selectRecords();
        request.setAttribute("data", data);
        request.getRequestDispatcher("/pages/select.jsp").forward(request, response);
    }
}
