package com.fdmgroup.dao;

import java.util.List;
import javax.persistence.*;
import com.fdmgroup.model.Address;
import com.fdmgroup.model.Employee;

public class AddressDao {
	private static EntityManager em;
	private DbConnection con;
	
	public AddressDao(){
		super();
		this.con = DbConnection.getInstance();
	}
	
	public void addAddress(Address address) {
		EntityManager em = con.getEntityManager();
		em.getTransaction().begin();
			
		em.persist(address);
		
		em.getTransaction().commit();
		em.close();
	}
	
	
	public static void select() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JSP_EX_2");
        em = emf.createEntityManager();
        em.getTransaction().begin();

		Query q = em.createNamedQuery("Address.FindAll", Address.class);
        List<Address> addresses = q.getResultList();
        
        for(Address s : addresses) {
        	System.out.println(s);
        }
	}
}
