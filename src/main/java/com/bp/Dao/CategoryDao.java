/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp.Dao;

import com.bp.models.Category;
import java.util.List;

/**
 *
 * @author roslm
 */
public interface CategoryDao {
    public void insert(Category cat);
    public List<Category> selectAll();
    public List<Category> selectById(int id);
    public boolean update(Category cat);
    public boolean delete(int id);
}
