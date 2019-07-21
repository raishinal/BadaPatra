/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp.DaoImpl;

import com.bp.Dao.SubDocumentDao;
import com.bp.models.Document;
import com.bp.models.SubDocument;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author roslm
 */
@Repository
public class SubDocumentDaoImpl implements SubDocumentDao{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean insert(SubDocument item) {
         boolean status = false;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
            status = true;
        }

        return status;
    }

    @Override
    public List<SubDocument> selectAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<SubDocument> mcl = session.createQuery("from SubDocument").list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public SubDocument selectById(int id) {
         Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from SubDocument where id = :code ");
        query.setParameter("code", id);
        List<SubDocument> mcl = query.list();
        SubDocument item=mcl.get(0);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean update(SubDocument item) {
          boolean status = false;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(item);
            session.getTransaction().commit();
            status = true;

        }
        return status;
    }

    @Override
    public boolean delete(int id) {
          boolean status = false;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Query query = session.createQuery("delete from SubDocument where id = :code ");
            query.setParameter("code", id);
            int result = query.executeUpdate();
            session.getTransaction().commit();
            status = true;
        }
        return status;
    }

    @Override
    public List<SubDocument> selectByMain(int id) {
       Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from SubDocument where mainDocument = :code ");
        query.setParameter("code", id);
        List<SubDocument> mcl=query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }
    
}
