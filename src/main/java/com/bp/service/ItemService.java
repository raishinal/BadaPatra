/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp.service;

import com.bp.models.Document;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author roslm
 */
public interface ItemService {

    public boolean addItem(Document item);

    public List<Document> findAllItem();

    public Document findItemById(int id);
    public Document findItemByTitle(String title);
    

    public List<Document> findItemByCategory(int category);

    public List<Document> findItemByKey(String key);

    public List<Document> findLatestItems();

    public List<Document> findPopularItems();

    public List<Document> findLatestByDate(String date);

    public boolean updateItem(Document item);

    public boolean deleteItem(int id);

    boolean uploadImage1(MultipartFile image);
    boolean uploadImage2(MultipartFile image);
}
