package com.objis.demohibernate.service;


import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.stat.Statistics;

import com.objis.demohibernate.simple.Formation;
import com.objis.demohibernate.simple.util.HibernateUtil;


public class GestionnaireFormation {

	// Rendre persistant une formation 
	public Long creerFormation(Formation formation){
		
		Statistics stats = HibernateUtil.getSessionFactory().getStatistics(); // statistiques

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Long formationId = null;
		try {
			session.saveOrUpdate(formation);
			tx.commit();
			formationId = formation.getId();
		} 
		catch (Exception e) {
			tx.rollback();
		} 
		finally{
			session.close();
		}
		
		stats.logSummary();                // statistiques

		System.out.println( "       getEntityNames = " + stats.getEntityNames()[0]);
		System.out.println( "    EntityDeleteCount = " + stats.getEntityDeleteCount());
		System.out.println( "  getEntityFetchCount = " + stats.getEntityFetchCount());
		System.out.println( " getEntityInsertCount = " + stats.getEntityInsertCount());
		System.out.println( "   getEntityLoadCount = " + stats.getEntityLoadCount());
		System.out.println( " getEntityUpdateCount = " + stats.getEntityUpdateCount());
		
		return formationId;
	}
	
	public Formation chercherFormationparTheme(String theme) {
		Formation f = null;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Criteria c = session.createCriteria(Formation.class);
		c.add( Restrictions.ilike("theme", theme) );
		f = (Formation)c.uniqueResult();
		
		return f;
	}
}
