/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp.serviceImpl;

import com.bp.Dao.ItemDao;
import com.bp.models.Document;
import com.bp.service.ItemService;
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
public class ItemServiceImpl implements ItemService{
     private String uploadDir = "C:\\Users\\roslm\\OneDrive\\Documents\\NetBeansProjects\\BadaPatra\\BadaPatra\\src\\main\\webapp\\resources";
    
    @Autowired
    private ItemDao itemDao;

    @Override
    public boolean addItem(Document item) {
        return itemDao.insert(item);
    }

    @Override
    public List<Document> findAllItem() {
       return itemDao.selectAll();
    }

    @Override
    public Document findItemById(int id) {
        return itemDao.selectById(id);
    }

    @Override
    public List<Document> findItemByCategory(int category) {
     return itemDao.selectByCategory(category);
    }

    @Override
    public List<Document> findItemByKey(String key) {
       return itemDao.searchKeywords(key);
    }

    @Override
    public List<Document> findLatestItems() {
       return itemDao.findLatestItem();
    }

    @Override
    public List<Document> findPopularItems() {
       return itemDao.findPopularItem();
    }

    @Override
    public List<Document> findLatestByDate(String date) {
        return itemDao.findByDate(date);
    }

    @Override
    public boolean updateItem(Document item) {
        return itemDao.update(item);
    }

    @Override
    public boolean deleteItem(int id) {
       return itemDao.delete(id);
    }

    @Override
    public boolean uploadImage1(MultipartFile image) {
        boolean status = false;
        
        File dir = new File(uploadDir + File.separator + "headimage");
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

    @Override
    public boolean uploadImage2(MultipartFile image) {
        boolean status = false;
        
        File dir = new File(uploadDir + File.separator + "sampleimage");
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

    @Override
    public Document findItemByTitle(String title) {
       return itemDao.selectByTitle(title);
    }


    
}
