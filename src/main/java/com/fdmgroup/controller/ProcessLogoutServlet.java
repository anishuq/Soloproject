package com.fdmgroup.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProcessLogoutServlet
 */
@WebServlet("/ProcessLogoutServlet")
public class ProcessLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		HttpSession session = request.getSession();
		
 		session.removeAttribute("loggedInEmployee");//to stop a session 
		session.invalidate();
		
		request.setAttribute("logoutInfo", "Good-bye!");
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request,  response);
	}

}
