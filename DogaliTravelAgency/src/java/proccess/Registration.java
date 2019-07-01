/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proccess;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ismael
 */
@WebServlet(name = "Registration", urlPatterns = {"/Registration"})
public class Registration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        try {
            String fname = req.getParameter("fname");
            String lname = req.getParameter("lname");
            String email = req.getParameter("email");
            String department = req.getParameter("department");
            String phoneno = req.getParameter("phoneno");
            String fax = req.getParameter("fax");
            String nationality = req.getParameter("nationality");
            String crnumber = req.getParameter("crnumber");
            String month = req.getParameter("month");
            String years = req.getParameter("years");
            String ddate = req.getParameter("ddate");
            String pdtime = req.getParameter("pdtime");
            String rdate = req.getParameter("rdate");
            String prtime = req.getParameter("prtime");
            String fclass = req.getParameter("fclass");
            String mpreference = req.getParameter("mpreference");
            String ffpname = req.getParameter("ffpname");
            String ffpnumber = req.getParameter("ffpnumber");
            String hname = req.getParameter("hname");
            String rpreferred = req.getParameter("rpreferred");
            String spreference = req.getParameter("spreference");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost/Dogali", "root", "root");
            Statement st = con.createStatement();
            String query = "Insert into book VALUES ('" + fname + "','" + lname + "','" +  email + "','" + department + "','" + phoneno+ "','" + fax + "','" + nationality + "','" + crnumber + "','" + month + "','" + years + "','" + ddate + "','" + pdtime + "','" + rdate + "','" + prtime + "','" + fclass + "','" + mpreference + "','" + ffpname + "','" + ffpnumber + "','" + hname + "','" + rpreferred + "','" + spreference + "')";
            int n = st.executeUpdate(query);
            con.close();
            RequestDispatcher rd = req.getRequestDispatcher("index.html");
            rd.include(req, res);
        } catch (SQLException e) {
            try {
                res.setContentType("text/html");
                PrintWriter pw = res.getWriter();
                pw.println("<div style='color:blue'>" + e.getMessage() + "</div>");
                RequestDispatcher dis = req.getRequestDispatcher("index.html");
                dis.include(req, res);
            } catch (ServletException e1) {
            } catch (IOException e1) {
            }
        } catch (ServletException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
