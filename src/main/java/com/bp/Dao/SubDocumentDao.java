/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp.Dao;

import com.bp.models.Document;
import com.bp.models.SubDocument;
import java.util.List;

/**
 *
 * @author roslm
 */
public interface SubDocumentDao {
     public boolean insert(SubDocument item);

    public List<SubDocument> selectAll();

    public SubDocument selectById(int id);
    public List<SubDocument> selectByMain(int id);
    
      public boolean update(SubDocument item);

    public boolean delete(int id);
}
