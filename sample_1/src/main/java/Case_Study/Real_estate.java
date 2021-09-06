package Case_Study;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Real_estate")
public class Real_estate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
//		response.setContentType("text/html");
		
		PrintWriter out =null;
	    
		try {
			out=response.getWriter();
			String firstname=request.getParameter("firstname");
			String lastname=request.getParameter("lastname");
			String address=request.getParameter("address");
			String mobilenumber=request.getParameter("phone");
			String email=request.getParameter("Email");
			String pname=request.getParameter("pname1");
			String plocation=request.getParameter("plocation");
			String ptype=request.getParameter("ptype");
			String additionalinfo=request.getParameter("Message");
			
	
			
//      	out.println("Project name is="+pname);
//			out.println("\nLast name is="+lastname);
//			out.println("\nAddress name is="+address);
//			out.println("\nMobile number is="+mobilenumber);
//			out.println("\nEmail is="+email);
//			out.println("\nAdditonal info is="+additionalinfo);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/real_estate","root","password");
			
			String sql = "insert into customerinfo(First_Name,Last_Name,Address,Contact_Number,Email_Id,Project_Name,Project_Location,Flat_Type,Additional_Message) values(?,?,?,?,?,?,?,?,?)"; 
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, address);
			ps.setString(4, mobilenumber);
			ps.setString(5, email);
			ps.setString(6, pname);
			ps.setString(7, plocation);
			ps.setString(8, ptype);
			ps.setString(9, additionalinfo);
			ps.executeUpdate();
	        System.out.println("Data Saved"); 
	        con.close();
	        
	        response.sendRedirect("test.html");
//	        out.println("<script type=\"text/javascript\">");
//	        out.println("alert('Data Saved Successfully');");
//	        out.println("</script>");
//	        
		}
		catch(Exception e) {
			
			System.out.println("Exception="+e);
		}
	}

}
