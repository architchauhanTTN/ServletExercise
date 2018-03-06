package myservlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Blog extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("This is get");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("This is a post request");
        String blogDe = req.getParameter("blog");
        System.out.println(blogDe);

        HttpSession httpSession = req.getSession(false);

        String userName  = (String)httpSession.getAttribute("uName");

        ConnectionDB.insertBlog(blogDe , userName); // inserts into the database

        resp.getWriter().println("YOU BLOG HAS BEEN SAVED . THANKYOU !! ");
    }
}
