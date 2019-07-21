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

@Entity
public class SubDocument {
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
     
     private String title;
    private int mainDocument;
    private String descrpition;

    public SubDocument() {
    }

    public SubDocument(String title, int mainDocument, String descrpition) {
        this.title = title;
        this.mainDocument = mainDocument;
        this.descrpition = descrpition;
    }

    public SubDocument(int id, String title, int mainDocument, String descrpition) {
        this.id = id;
        this.title = title;
        this.mainDocument = mainDocument;
        this.descrpition = descrpition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMainDocument() {
        return mainDocument;
    }

    public void setMainDocument(int mainDocument) {
        this.mainDocument = mainDocument;
    }

    public String getDescrpition() {
        return descrpition;
    }

    public void setDescrpition(String descrpition) {
        this.descrpition = descrpition;
    }

   
}
