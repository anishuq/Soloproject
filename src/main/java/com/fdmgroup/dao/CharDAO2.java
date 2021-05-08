package com.fdmgroup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.NesCharJpa_JSP2;

public class CharDAO2 {

	private DbConnection con;

	public CharDAO2() {
		super();
		this.con = DbConnection.getInstance();
	}
	
	public void addNesChar(NesCharJpa_JSP2 nesChar) {
		EntityManager em = con.getEntityManager();
		em.getTransaction().begin();
			em.persist(nesChar);
		em.getTransaction().commit();
		em.close();
	}


	public NesCharJpa_JSP2 findByNesCharID(int id) {
	List<NesCharJpa_JSP2> qResult = new ArrayList<>();
		
		EntityManager em = con.getEntityManager();
			TypedQuery<NesCharJpa_JSP2> q = em.createNamedQuery("n.findByCharID", NesCharJpa_JSP2.class);
			q.setParameter("nIDParam", id);
			qResult = q.getResultList();
		em.close();
		
		if(qResult != null && qResult.size() == 1)
			return qResult.get(0);
		return null;
	}
	
	public NesCharJpa_JSP2 findByNesCharName(String name) {
		List<NesCharJpa_JSP2> qResult = new ArrayList<>();
			
			EntityManager em = con.getEntityManager();
				TypedQuery<NesCharJpa_JSP2> q = em.createNamedQuery("n.findByCharName", NesCharJpa_JSP2.class);
				q.setParameter("nCharName", name);
				qResult = q.getResultList();
			em.close();
			
			if(qResult != null && qResult.size() == 1)
				return qResult.get(0);
			return null;
		}

	public List<NesCharJpa_JSP2> findAll() {
		List<NesCharJpa_JSP2> dbList = new ArrayList<>();
		EntityManager em = con.getEntityManager();
			TypedQuery<NesCharJpa_JSP2> q = em.createNamedQuery("n.findAllChar", NesCharJpa_JSP2.class);
			dbList = q.getResultList();
		em.close();
		
		return dbList;
	}

	}