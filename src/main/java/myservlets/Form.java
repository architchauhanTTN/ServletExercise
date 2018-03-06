package myservlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Form extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("This  is get request");
        RequestDispatcher rd=req.getRequestDispatcher("myform.jsp");

        rd.forward(req , resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();

        PrintWriter printWriter = resp.getWriter();
        System.out.println("This is a post Request");
        String userName = req.getParameter("user");
        String pass = req.getParameter("pass");
        httpSession.setAttribute("uName" , userName);

        if(ConnectionDB.checkUser(userName , pass) == false) {
            printWriter.println("Not a Correct User");

        }

        else {

            RequestDispatcher rd = req.getRequestDispatcher("blog.jsp");
//            resp.setHeader("From " , "Form");
                rd.forward(req , resp);
        }

    }
}
