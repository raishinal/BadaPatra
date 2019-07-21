/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp.serviceImpl;

import com.bp.Dao.NewsDao;
import com.bp.models.News;
import com.bp.service.NewsService;
import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author roslm
 */
@Service
@Transactional
public class NewsServiceImpl implements NewsService{
     private String uploadDir = "C:\\Users\\roslm\\OneDrive\\Documents\\NetBeansProjects\\BadaPatra\\BadaPatra\\src\\main\\webapp\\resources";
     @Autowired
     NewsDao newsDao;

    @Override
    public boolean addItem(News item) {
      return newsDao.insert(item);
    }

    @Override
    public List<News> findAllItem() {
        return newsDao.selectAll();
    }

    @Override
    public News findItemById(int id) {
       return newsDao.selectById(id);
    }

    @Override
    public List<News> findLatestByDate(String date) {
       return newsDao.findByDate(date);
    }

    @Override
    public boolean updateItem(News item) {
       return newsDao.update(item);
    }

    @Override
    public boolean deleteItem(int id) {
       return newsDao.delete(id);
    }

    @Override
    public boolean uploadImage1(MultipartFile image) {
           boolean status = false;
        
        File dir = new File(uploadDir + File.separator + "newsimage");
        if(!dir.exists()){
            dir.mkdirs();
        }
       
        
       String filename = image.getOriginalFilename();
       File uploadImage = new File(dir + File.separator +filename);
       try{
           image.transferTo(uploadImage);
           status = true;
       }catch(Exception e){
           System.out.println(e); 
       }
        
        return status;
    }
    
}
