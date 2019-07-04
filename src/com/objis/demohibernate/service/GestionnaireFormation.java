package com.objis.demohibernate.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;

import com.objis.demohibernate.simple.Formation;
import com.objis.demohibernate.simple.util.HibernateUtil;

public class GestionnaireFormation {

    // Rendre persistant une formation
    public Long creerFormation( Formation formation ) {

        Statistics stats = HibernateUtil.getSessionFactory().getStatistics(); // Statistics

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Long formationId = null;

        try {
            session.saveOrUpdate( formation );
            tx.commit();
            formationId = formation.getId();
        } catch ( Exception e ) {
            tx.rollback();
        } finally {
            session.close();
        }

        stats.logSummary();
        return formationId;
    }
}
