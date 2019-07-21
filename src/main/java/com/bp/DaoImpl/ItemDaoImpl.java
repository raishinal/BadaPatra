/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp.DaoImpl;

import com.bp.Dao.ItemDao;
import com.bp.models.Document;
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
public class ItemDaoImpl implements ItemDao{
      @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean insert(Document item) {
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
    public List<Document> selectAll() {
            Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Document> mcl = session.createQuery("from Document ORDER BY posted_date DESC").list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public Document selectById(int id) {
         Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Document where id = :code ");
        query.setParameter("code", id);
        List<Document> mcl = query.list();
        Document item=mcl.get(0);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public List<Document> selectByCategory(int category) {
         Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Document where category = :code ");
        query.setParameter("code", category);
        List mcl = query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<Document> searchKeywords(String key) {
              Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Document where title LIKE'%"+key+"%'");
        List mcl = query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<Document> findLatestItem() {
       Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Document ORDER BY posted_date DESC ");
        query.setFirstResult(0);
        query.setMaxResults(6);
        List<Document> mcl = query.list();
        
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<Document> findPopularItem() {
          Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Items ORDER BY likecounts DESC ");
        query.setFirstResult(0);
        query.setMaxResults(3);
        List<Document> mcl = query.list();
        
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<Document> findByDate(String date) {
         Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Document> mcl = session.createQuery("from Document WHERE posted_date > '"+date+"' ORDER BY posted_date DESC").list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public boolean update(Document item) {
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
            Query query = session.createQuery("delete from Document where id = :code ");
            query.setParameter("code", id);
            int result = query.executeUpdate();
            session.getTransaction().commit();
            status = true;
        }
        return status;
    }

    @Override
    public Document selectByTitle(String title) {
      Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Document where title = :code ");
        query.setParameter("code", title);
        List<Document> mcl = query.list();
        Document item=mcl.get(0);
        session.getTransaction().commit();
        session.close();
        return item;
    }
    
}
