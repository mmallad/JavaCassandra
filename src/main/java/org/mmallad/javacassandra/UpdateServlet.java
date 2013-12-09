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
 * Time: 5:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name =  request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        request.setAttribute("name",name);
        request.setAttribute("email",email);
        request.setAttribute("phone",phone);
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pages/update.jsp").forward(request, response);
    }
}
