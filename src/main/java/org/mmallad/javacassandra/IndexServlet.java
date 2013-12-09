package org.mmallad.javacassandra;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Dpak Malla mmallad
 * Date: 12/9/13
 * Time: 11:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name =  request.getParameter("myname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        request.setAttribute("name", name);
        //Init Cassandra Connections :)
        Common.Connect();
        //Now Let us Query
        String[] data = new String[3];
        data[0] = name;
        data[1] = email;
        data[2] = phone;
        Common.cassandraCluster.insertRecords(data);
        //Map<Integer, Map> datas = Common.cassandraCluster.selectRecords();
        //request.setAttribute("data", data.toString());
        //request.setAttribute("datas", datas.toString());
        request.setAttribute("succ","Success");
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Load UI Page
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
