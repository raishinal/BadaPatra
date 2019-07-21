/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp.serviceImpl;

import com.bp.Dao.CategoryDao;
import com.bp.models.Category;
import com.bp.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author roslm
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
     @Autowired
    CategoryDao categoryDao;

    @Override
    public void addCategory(Category cat) {
        categoryDao.insert(cat);
    }

    @Override
    public List<Category> findAllCategory() {
       return categoryDao.selectAll();
    }

    @Override
    public boolean updateCategory(Category cat) {
       return categoryDao.update(cat);
    }

    @Override
    public boolean deleteCategory(int id) {
        return categoryDao.delete(id);
    }

    @Override
    public List<Category> findCategoryById(int id) {
       return categoryDao.selectById(id);
    }
    
}
