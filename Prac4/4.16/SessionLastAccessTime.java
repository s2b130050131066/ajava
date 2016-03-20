

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SessionLastAccessTime")
public class SessionLastAccessTime extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		HttpSession session = req.getSession();
		Date CreationTime = new Date(session.getCreationTime());
		Date LastAccess = new Date(session.getLastAccessedTime());
		Date now = new Date(0);
		DateFormat foreatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
		out.println("<html><head><title>Displaying Session Last aceess time</title></head>");
		out.println("<body>");
		out.println("<h2>Session Creation and Last aceess time:</h2>");
		out.println("the time and date now is:"+foreatter.format(now)+"<br><br>");
		out.println("The session creation time is: "+foreatter.format(CreationTime)+"");
		out.println("The session Last Access time is: "+foreatter.format(LastAccess)+"");
		out.println("</body></html>");
	}

}
