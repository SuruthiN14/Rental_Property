package com.rentalproperty.servlet;
import com.rentalproperty.util.DBConnection; import javax.servlet.*; import javax.servlet.annotation.WebServlet; import javax.servlet.http.*; import java.io.*; import java.sql.*;
@WebServlet("/addProperty") public class AddPropertyServlet extends HttpServlet {
 protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
  HttpSession s=req.getSession(false); if(s==null||s.getAttribute("userId")==null){res.sendRedirect("login.jsp");return;}
  try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement("INSERT INTO properties(owner_id,title,location,type,rent,bedrooms,description,status,image) VALUES(?,?,?,?,?,?,?,'Available',?)")){p.setInt(1,(Integer)s.getAttribute("userId"));p.setString(2,req.getParameter("title"));p.setString(3,req.getParameter("location"));p.setString(4,req.getParameter("type"));p.setDouble(5,Double.parseDouble(req.getParameter("rent")));p.setInt(6,Integer.parseInt(req.getParameter("bedrooms")));p.setString(7,req.getParameter("description"));p.setString(8,req.getParameter("image"));p.executeUpdate();res.sendRedirect("OwnerDashboardServlet?msg=added");}catch(Exception e){res.sendRedirect("addProperty.jsp?error=Please check the entered values");}
 }
}
