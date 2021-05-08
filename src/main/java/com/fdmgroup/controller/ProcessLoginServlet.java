package com.fdmgroup.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.dao.CharDAO2;
import com.fdmgroup.dao.EmployeeDao;
import com.fdmgroup.model.Employee;
import com.fdmgroup.model.NesCharJpa_JSP2;

/**
 * Servlet implementation class ProcessLoginServlet
 */
@WebServlet("/ProcessLoginServlet")
public class ProcessLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("username");
		String pass = request.getParameter("userpass");

		EmployeeDao eDao = new EmployeeDao();
		List<Employee> list = new ArrayList<>();
		list = eDao.select();

		boolean found = false;
		int foundID = 0;
		Employee loggedInEmployee = null;

		System.out.println(list.get(0));

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUsername().equals(uname) && list.get(i).getPassword().equals(pass)) {
				found = true;
				foundID = list.get(i).getId();
				break;
			}
		}

		System.out.println("3");
		if (found) {
			// loggedInEmployee is MANAGED: extracted through an entity manager.
			// Now if I change something in this "managed" object through
			// its SETTER that change will be reflected in the DB also.
			loggedInEmployee = eDao.findByEmpID(foundID);

			HttpSession session = request.getSession();
			session.setAttribute("loggedInEmployee", loggedInEmployee);
			session.setMaxInactiveInterval(5000);

			// Destination Servlet.
			RequestDispatcher rd = request.getRequestDispatcher("splash.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("logoutInfo", "INVALID LOG IN ATTEMPT!");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}

	}
}
























/*
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("1");

	// get params from web form
	String inputCharName = request.getParameter("charNameParam");

	// validate
	CharDAO2 dao = new CharDAO2();
	List<NesCharJpa_JSP2> list = new ArrayList<>();
	list = dao.findAll();
	
	boolean found = false;
	int foundID = 0;
	NesCharJpa_JSP2 loggedInUser = null;
	
	System.out.println(list.get(0));
	
	for(int i=0; i < list.size(); i++) {
	if(list.get(i).getCharName().equals(inputCharName)) {
	found = true;
	foundID = list.get(i).getCharID();
	}
	}
	System.out.println("3");
	if(found) {
	//loggedInUser = dao.findByNesCharID(foundID);
	loggedInUser = dao.findByNesCharName(inputCharName);
	HttpSession session = request.getSession();
	session.setAttribute("charUser", loggedInUser);
	session.setMaxInactiveInterval(5000);

	RequestDispatcher rd = request.getRequestDispatcher("splash.jsp");
	rd.forward(request, response);
	}
	else {
	request.setAttribute("logoutInfo", "INVALID LOG IN ATTEMPT!");
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);
	}
	*/


