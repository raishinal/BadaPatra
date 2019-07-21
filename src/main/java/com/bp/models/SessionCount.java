/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author roslm
 */
@Entity
public class SessionCount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private int count;
    private int documentid;
    private String date;

    public SessionCount() {
    }

    public SessionCount(int count, int documentid, String date) {
        this.count = count;
        this.documentid = documentid;
        this.date = date;
    }

    public SessionCount(int id, int count, int documentid, String date) {
        this.id = id;
        this.count = count;
        this.documentid = documentid;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDocumentid() {
        return documentid;
    }

    public void setDocumentid(int documentid) {
        this.documentid = documentid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
