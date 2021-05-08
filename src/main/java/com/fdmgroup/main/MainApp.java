package com.fdmgroup.main;

import java.util.List;

import com.fdmgroup.dao.AddressDao;
import com.fdmgroup.dao.CharDAO2;
import com.fdmgroup.dao.EmployeeDao;
import com.fdmgroup.model.Employee;
import com.fdmgroup.model.NesCharJpa_JSP2;
import com.fdmgroup.model.UserTypes;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Andrew Blakney3:05 p.m.
		/*
		NesCharJpa_JSP2 c1 = new NesCharJpa_JSP2();
		c1.setCharName("WARIO");

		System.out.println(c1);
	*/
		//CharDAO2 cDAO = new CharDAO2();
		//cDAO.addNesChar(c1);
	
		//System.out.println("dONE");
		/*NesCharJpa_JSP2 c2 = new NesCharJpa_JSP2();
		c2.setCharName("Mondo-Gecko");


		cDAO.addNesChar(c2);

		System.out.println("2 CHARS ADDED ...");*/
		//List<NesCharJpa_JSP2> list =  cDAO.findAll();
		
		//list.forEach((s) -> {System.out.println(s);});
		
		//===============================================================
		AddressDao addressDao = new AddressDao();
		addressDao.select();
		
		System.out.println("dONE2");
		
		EmployeeDao employeeDao = new EmployeeDao();
		//Employee e1 = new Employee("Robert", "7895", "Rob", "Smith","rob@cranky.com",2, UserTypes.ADMIN , 899);
		//employeeDao.addEmployee(e1);
		employeeDao.select();		
		 
	}

}
