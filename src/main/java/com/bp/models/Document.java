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
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author roslm
 */
@Entity
public class Document {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String title;
    private int category;
    private String description;
    @Transient
    private MultipartFile headimage;
    private String headimageName;
    @Transient
    private MultipartFile sampleimage;
    private String sampleimageName;
    private String posted_date;
    private int likecounts;

    public Document() {
    }

    public Document(String title, int category, String description, MultipartFile headimage, String headimageName, MultipartFile sampleimage, String sampleimageName, String posted_date, int likecounts) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.headimage = headimage;
        this.headimageName = headimageName;
        this.sampleimage = sampleimage;
        this.sampleimageName = sampleimageName;
        this.posted_date = posted_date;
        this.likecounts = likecounts;
    }

    public Document(int id, String title, int category, String description, MultipartFile headimage, String headimageName, MultipartFile sampleimage, String sampleimageName, String posted_date, int likecounts) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.description = description;
        this.headimage = headimage;
        this.headimageName = headimageName;
        this.sampleimage = sampleimage;
        this.sampleimageName = sampleimageName;
        this.posted_date = posted_date;
        this.likecounts = likecounts;
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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getHeadimage() {
        return headimage;
    }

    public void setHeadimage(MultipartFile headimage) {
        this.headimage = headimage;
    }

    public String getHeadimageName() {
        return headimageName;
    }

    public void setHeadimageName(String headimageName) {
        this.headimageName = headimageName;
    }

    public MultipartFile getSampleimage() {
        return sampleimage;
    }

    public void setSampleimage(MultipartFile sampleimage) {
        this.sampleimage = sampleimage;
    }

    public String getSampleimageName() {
        return sampleimageName;
    }

    public void setSampleimageName(String sampleimageName) {
        this.sampleimageName = sampleimageName;
    }

    public String getPosted_date() {
        return posted_date;
    }

    public void setPosted_date(String posted_date) {
        this.posted_date = posted_date;
    }

    public int getLikecounts() {
        return likecounts;
    }

    public void setLikecounts(int likecounts) {
        this.likecounts = likecounts;
    }
    
    
    

    
}
