/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp.service;

import com.bp.models.SessionCount;
import java.util.List;

/**
 *
 * @author roslm
 */
public interface SessionService {
     public boolean save(SessionCount sc);
    
    public SessionCount getSessionCount(int id);
    public List<SessionCount> getAllSessionCount();

    public int getCount();
    public SessionCount getCountbyDocument(int id);
    public String getDate();
    public List<SessionCount> getPopular();

    public boolean resetCount(int id);

    public boolean updateCount(SessionCount sc);
    
}
