package org.mmallad.javacassandra;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: mmallad
 * Date: 12/9/13
 * Time: 5:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class DoUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name =  request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Common.Connect();
        String[] data = new String[3];
        data[0] = name;
        data[1] = email;
        data[2] = phone;
        Common.cassandraCluster.updateRecord(data);
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.sendRedirect("/JavaCassandra/select");
    }
}
