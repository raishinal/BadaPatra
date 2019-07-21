/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp.serviceImpl;

import com.bp.Dao.SubDocumentDao;
import com.bp.models.SubDocument;
import com.bp.service.SubDocumentService;
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
public class SubDocumentServiceImpl implements SubDocumentService {

    @Autowired 
    SubDocumentDao subDocumentDao;
    
    @Override
    public boolean addItem(SubDocument item) {
        return subDocumentDao.insert(item);
    }

    @Override
    public List<SubDocument> findAllItem() {
      return subDocumentDao.selectAll();
    }

    @Override
    public SubDocument findItemById(int id) {
        return subDocumentDao.selectById(id);
    }

    @Override
    public boolean updateItem(SubDocument item) {
        return subDocumentDao.update(item);
    }

    @Override
    public boolean deleteItem(int id) {
        return subDocumentDao.delete(id);
    }

    @Override
    public List<SubDocument> findMainItem(int id) {
        return subDocumentDao.selectByMain(id);
    }
    
}
