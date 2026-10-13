package com.rentalproperty.servlet;
import javax.servlet.*; import javax.servlet.annotation.WebServlet; import javax.servlet.http.*; import java.io.*;
@WebServlet("/logout") public class LogoutServlet extends HttpServlet { protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException{HttpSession s=req.getSession(false);if(s!=null)s.invalidate();res.sendRedirect("index.jsp");} }
