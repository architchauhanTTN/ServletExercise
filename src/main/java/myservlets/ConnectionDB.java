package myservlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class ConnectionDB {

        static boolean checkUser(String userName , String password) {
            boolean returnValue = false;
            try {


                Class.forName("com.mysql.jdbc.Driver");

                System.out.println("Trying to connect with database");

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ch","root","ttn");
                PreparedStatement stmt = con.prepareStatement("select * from user where name = ? and pass = ?");
                stmt.setString(1 , userName);
                stmt.setString(2 , password);
                ResultSet rs = stmt.executeQuery();
                System.out.println("Printing -----" + rs.getFetchSize());
                while(rs.next()) {
                    returnValue = true;
//                    System.out.println(rs.getString(1));
                }


                con.close();
            } catch (SQLException|ClassNotFoundException e) {
                e.printStackTrace();
            }
            return returnValue;
        }
        static void insertBlog(String blog, String user) {
            try {


                Class.forName("com.mysql.jdbc.Driver");



                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ch","root","ttn");
                PreparedStatement stmt = con.prepareStatement("insert into blog values(? , ?)");
                stmt.setString(1 , blog);
                stmt.setString(2 , user);
                System.out.println("Inserted Successfully !!!");
               stmt.executeUpdate();
                con.close();
            } catch (SQLException|ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

}
