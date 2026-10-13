package com.rentalproperty.servlet;
import com.rentalproperty.util.DBConnection; import javax.servlet.*; import javax.servlet.annotation.WebServlet; import javax.servlet.http.*; import java.io.*; import java.sql.*;
@WebServlet("/login") public class LoginServlet extends HttpServlet {
 protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
  String email=req.getParameter("email"),password=req.getParameter("password"),role=req.getParameter("role");
  try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement("SELECT * FROM users WHERE email=? AND password=? AND role=?")){p.setString(1,email);p.setString(2,password);p.setString(3,role);ResultSet rs=p.executeQuery();if(rs.next()){HttpSession s=req.getSession();s.setAttribute("userId",rs.getInt("user_id"));s.setAttribute("name",rs.getString("name"));s.setAttribute("email",rs.getString("email"));s.setAttribute("role",rs.getString("role"));res.sendRedirect("Owner".equals(role)?"OwnerDashboardServlet":"properties");}else res.sendRedirect("login.jsp?error=Invalid email, password or role");}
  catch(Exception e){e.printStackTrace();res.sendRedirect("login.jsp?error=Database connection failed");}
 }
}
