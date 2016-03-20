

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletInsertingdata")
public class ServletInsertingdata extends HttpServlet
{
    Connection con=null;
    Statement stmt=null;
    ResultSet rs=null;
    String url="jdbc:mysql://localhost:8080/jdbc";
    String un="root";
    String pwd="hinka";
    String tn="",tp="";
    public void init(ServletConfig sc) throws ServletException
    {
        super.init(sc);
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            con=DriverManager.getConnection(url,un,pwd);
            System.out.println("Connected");
            stmt=con.createStatement();
            System.out.println("Wrapper Created");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        doPost(req,res);
    }
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        if(req.getParameter("btnsmt")!=null)
            {
                String n=req.getParameter("txtname");
                String p=req.getParameter("txtpass");
                out.println("Hinka Patel       130050131066");
                String sql="insert into emp1 values('"+n+"','"+p+"')";
            out.println(sql);
            try
            {
                int r=stmt.executeUpdate(sql);
                out.println("data inserted succesfully");
            }
            catch(Exception e)
            {
                out.println(e+"sorry! Failure");
            }
            }
        	out.println("Hinka Patel       130050131066");
            out.println("<html><body>");
            out.println("<form method='Get' action='ServletInsertingdata'><br><br>");
            out.println("Name:<input type='text' name='txtname'><br><br>");
            out.println("Password:<input type='text' name='txtpass'><br><br>");
            out.println("<input type='Submit' name='btnsmt' value='Submit'><br><br>");
            out.println("</form></body></html>");
                  
	}

}
