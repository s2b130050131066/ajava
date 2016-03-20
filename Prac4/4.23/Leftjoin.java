

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Leftjoin")
public class Leftjoin extends HttpServlet
{
public void doGet(HttpServletRequest req, HttpServletResponse res)
throws IOException, ServletException
{
res.setContentType("text/html");
PrintWriter pw = res.getWriter();
Connection con;
PreparedStatement ps;
ResultSet rs;
String url="jdbc:mysql://localhost:8080/jdbc";
String un="root";
String password="hinka";
try
{
	Class.forName("com.mysql.jdbc.Driver");
    System.out.println("driver is loaded");
    con=DriverManager.getConnection(url,un,password);
    System.out.println("connected");
    System.out.println("wrapper created");
    ps = con.prepareStatement("SELECT * FROM studentdata NATURAL JOIN account");
rs = ps.executeQuery();
pw.println("<table><tr>");
pw.println("<td>stu_rollno</td>");
pw.println("<td>stu_Name</td>");
pw.println("</tr>");
pw.println("</table>");
while(rs.next())
{
Integer stu_rollno = rs.getInt("rollno");
String stu_Name = rs.getString("name");
pw.println("<table><tr>");
pw.println("<td>"+stu_rollno+"</td>");
pw.println("<td>"+stu_Name+"</td>");
pw.println("</tr>");
pw.println("</table>");
}
try
{
con.close();
ps.close();
}
catch(Exception e)
{
pw.println(e);
}
}
catch(SQLException sx)
{
pw.println(sx);
}
catch(ClassNotFoundException cx)
{
pw.println(cx);
}
}
}