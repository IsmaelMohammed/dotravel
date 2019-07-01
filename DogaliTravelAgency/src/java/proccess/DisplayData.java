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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ismael
 */
@WebServlet(name = "DisplayData", urlPatterns = {"/DisplayData"})
public class DisplayData extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost/Dogali", "root", "root");
            Statement st = con.createStatement();
            String query = "select * from book";
            ResultSet rs = st.executeQuery(query);
            String output = "<html><head><title>Dogali Travel Agency</title> </head><body > ";

            output += "<h1>Booking Data </h1>\n"
                    + "        <form action=\"Registration\" method=\"POST\"> <table border=6 class=\" w3-black\" >";
            output += "<th>First Name</th><th>last Name</th><th>Email</th><th>Department</th><th>PhoneNo</th><th>Fax</th><th>Nationality</th><th>Credit Card Number</th><th>Valid Until month</th><th>Valid Until year</th><th>Departure Date</th><th>preferred Departue Time</th><th>Return Date</th><th>preferred Rturn Time</th><th>Flight Class</th><th>Meal Preference</th><th>Frequent Flyer Program Name</th><th>Frequent Flyer Program Number</th><th>Hotel Name</th><th>Room Preferred</th><th>Smoking Preference</th>";
            while (rs.next()) {
                output += "<tr >";
                output += "<td>" + rs.getString("fname") + "</td>";
                output += "<td>" + rs.getString("lname") + "</td>";
                output += "<td>" + rs.getString("email") + "</td>";
                output += "<td>" + rs.getString("department") + "</td>";
                output += "<td>" + rs.getString("phoneno") + "</td>";
                output += "<td>" + rs.getString("fax") + "</td>";
                output += "<td>" + rs.getString("nationality") + "</td>";
                output += "<td>" + rs.getString("crnumber") + "</td>";
                output += "<td>" + rs.getString("month") + "</td>";
                output += "<td>" + rs.getString("years") + "</td>";
                output += "<td>" + rs.getString("ddate") + "</td>";
                output += "<td>" + rs.getString("pdtime") + "</td>";
                output += "<td>" + rs.getString("rdate") + "</td>";
                output += "<td>" + rs.getString("prtime") + "</td>";
                output += "<td>" + rs.getString("fclass") + "</td>";
                output += "<td>" + rs.getString("mpreference") + "</td>";
                output += "<td>" + rs.getString("ffpname") + "</td>";
                output += "<td>" + rs.getString("ffpnumber") + "</td>";
                output += "<td>" + rs.getString("hname") + "</td>";
                output += "<td>" + rs.getString("rpreferred") + "</td>";
                output += "<td>" + rs.getString("spreference") + "</td>";
                output += "</tr>";
            }
            output += "</table> </form></body></html>";
            res.setContentType("text/html");
            PrintWriter pw = res.getWriter();
            pw.println(output);
        } catch (SQLException e) {
        } catch (IOException e) {
        }

    }
}
