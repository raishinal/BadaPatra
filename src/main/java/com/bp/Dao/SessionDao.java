/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp.Dao;

import com.bp.models.SessionCount;
import java.util.List;

/**
 *
 * @author roslm
 */
public interface SessionDao {
       public boolean insert(SessionCount sc);
    public SessionCount getsessioncount(int id);
    public List<SessionCount> getallsessioncount();
    
    public int getCount();
    public SessionCount getCountbyDocument(int id);
    public String getDate();
    public List<SessionCount> getPopular();
    public boolean resetCount(int id);
    public boolean updateCount(SessionCount sc);
}
