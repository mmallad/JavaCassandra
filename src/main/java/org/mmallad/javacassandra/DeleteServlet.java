package org.mmallad.javacassandra;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Dipak Malla mmallad
 * Date: 12/9/13
 * Time: 5:35 PM
 */
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Common.Connect();
        String email = request.getParameter("email");
        Common.cassandraCluster.deleteRecord(email);
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.sendRedirect("/JavaCassandra/select");
    }
}
