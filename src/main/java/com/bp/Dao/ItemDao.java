/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp.Dao;

import com.bp.models.Document;
import java.util.List;

/**
 *
 * @author roslm
 */
public interface ItemDao {

    public boolean insert(Document item);

    public List<Document> selectAll();

    public Document selectById(int id);
    public Document selectByTitle(String title);

    public List<Document> selectByCategory(int category);

    public List<Document> searchKeywords(String key);

    public List<Document> findLatestItem();

    public List<Document> findPopularItem();

    public List<Document> findByDate(String date);

    public boolean update(Document item);

    public boolean delete(int id);
}
