/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp.service;

import com.bp.models.News;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author roslm
 */
public interface NewsService {
     public boolean addItem(News item);

    public List<News> findAllItem();

    public News findItemById(int id);
    
    public List<News> findLatestByDate(String date);
     
      public boolean updateItem(News item);

    public boolean deleteItem(int id);

    boolean uploadImage1(MultipartFile image);
}
