/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp.DaoImpl;

import com.bp.Dao.NewsDao;
import com.bp.models.News;
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
public class NewsDaoImpl implements NewsDao{
         @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean insert(News item) {
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
    public List<News> selectAll() {
              Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<News> mcl = session.createQuery("from News ORDER BY posted_date DESC").list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public News selectById(int id) {
             Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from News where id = :code ");
        query.setParameter("code", id);
        List<News> mcl = query.list();
        News item=mcl.get(0);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public List<News> findByDate(String date) {
            Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<News> mcl = session.createQuery("from News WHERE posted_date > '"+date+"' ORDER BY posted_date DESC").list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public boolean update(News item) {
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
            Query query = session.createQuery("delete from News where id = :code ");
            query.setParameter("code", id);
            int result = query.executeUpdate();
            session.getTransaction().commit();
            status = true;
        }
        return status;
    }
}
