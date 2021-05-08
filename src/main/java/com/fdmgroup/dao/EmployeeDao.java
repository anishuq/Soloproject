package com.fdmgroup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.Address;
import com.fdmgroup.model.Employee;
import com.fdmgroup.model.NesCharJpa_JSP2;

public class EmployeeDao {
	private DbConnection con;
	private static EntityManager em;

	public EmployeeDao() {
		super();
		this.con = DbConnection.getInstance();
	}
	
	public void addEmployee(Employee employee) {
		EntityManager em = con.getEntityManager();
		em.getTransaction().begin();
			
		em.persist(employee);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<Employee> select() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JSP_EX_2");
        em = emf.createEntityManager();
        em.getTransaction().begin();

		Query q = em.createNamedQuery("Employee.FindAll", Employee.class);
        List<Employee> employees = q.getResultList();
        
        employees.forEach((e) -> {System.out.println(e);});
        
        return employees;
	}
	
	

	public Employee findByEmpID(int foundID) {
		List<Employee> qResult = new ArrayList<>();
		
		EntityManager em = con.getEntityManager();
			TypedQuery<Employee> q = em.createNamedQuery("Employee.findByID", Employee.class);
			q.setParameter("id", foundID);
			qResult = q.getResultList();
		em.close();
		
		if(qResult != null && qResult.size() == 1)
			return qResult.get(0);
		return null;

	}
}
