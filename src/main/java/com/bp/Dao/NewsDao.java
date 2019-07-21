/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp.Dao;

import com.bp.models.News;
import java.util.List;

/**
 *
 * @author roslm
 */
public interface NewsDao {
     public boolean insert(News item);

    public List<News> selectAll();

    public News selectById(int id);
    
     public List<News> findByDate(String date);

    public boolean update(News item);

    public boolean delete(int id);

}
