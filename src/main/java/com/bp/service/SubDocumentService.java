/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp.service;

import com.bp.models.SubDocument;
import java.util.List;

/**
 *
 * @author roslm
 */
public interface SubDocumentService {

    public boolean addItem(SubDocument item);

    public List<SubDocument> findAllItem();
    public List<SubDocument> findMainItem(int id);

    public SubDocument findItemById(int id);

    public boolean updateItem(SubDocument item);

    public boolean deleteItem(int id);
}
