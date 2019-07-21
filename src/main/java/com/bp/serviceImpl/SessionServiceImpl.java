/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp.serviceImpl;

import com.bp.Dao.SessionDao;
import com.bp.models.SessionCount;
import com.bp.service.SessionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SessionServiceImpl implements SessionService{

    @Autowired 
            SessionDao sessionCountDao;
    
    @Override
    public boolean save(SessionCount sc) {
        return sessionCountDao.insert(sc);
    }

    @Override
    public int getCount() {
        return sessionCountDao.getCount();
    }

    @Override
    public boolean resetCount(int id) {
        return sessionCountDao.resetCount(id);
    }

    @Override
    public boolean updateCount(SessionCount sc) {
       return sessionCountDao.updateCount(sc);
    }

    @Override
    public SessionCount getSessionCount(int id) {
       return sessionCountDao.getsessioncount(id);
    }

    @Override
    public String getDate() {
        return sessionCountDao.getDate();
    }

    @Override
    public SessionCount getCountbyDocument(int id) {
        return sessionCountDao.getCountbyDocument(id);
    }

    @Override
    public List<SessionCount> getAllSessionCount() {
        return sessionCountDao.getallsessioncount();
    }

    @Override
    public List<SessionCount> getPopular() {
        return sessionCountDao.getPopular();
    }

    
}
