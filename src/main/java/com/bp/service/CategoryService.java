/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp.service;

import com.bp.models.Category;
import java.util.List;

/**
 *
 * @author roslm
 */
public interface CategoryService {

    public void addCategory(Category cat);

    public List<Category> findAllCategory();
    public List<Category> findCategoryById(int id);
    

    public boolean updateCategory(Category cat);

    public boolean deleteCategory(int id);
}
