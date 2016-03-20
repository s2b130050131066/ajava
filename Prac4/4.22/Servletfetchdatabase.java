

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servletfetchdatabase")
public class Servletfetchdatabase extends HttpServlet
{
    Connection con=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    String url="jdbc:mysql://localhost:3306/jdbc";
    String un="root";
    String password="hinka";
    String tn="",tp="";
    String sql="insert into emp1 values(?,?)";
    public void init(ServletConfig sc)throws ServletException
    {
        super.init(sc);
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("driver is loaded");
        con=DriverManager.getConnection(url,un,password);
        System.out.println("connected");
        pstmt=con.prepareStatement(sql);
        System.out.println("wrapper created");
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println("driver Not Loaded"+cnfe.getMessage());
            return;
        }
        catch(SQLException sqle)
        {
            System.out.println("connection problem"+sqle.getMessage());
            return;
        }
    }
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        doPost(req,res);
    }
     public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
       out.println("<html>");
        out.println("<body><table >");
        out.println("<th>name</th>");
        out.println("<th>password</th>");
        try
        {
        	pstmt.setString(1,tn);
            pstmt.setString(2,tp);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
                tn=rs.getString("name");
                tp=rs.getString("password");
                out.println("<tr>");
                out.println("<td>"+tn+"</td>");
                out.println("<td>"+tp+"</td>");
                out.println("</tr>");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        out.println("</table></body></html>");
    }
}
