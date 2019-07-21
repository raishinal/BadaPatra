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
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    private String description;
    @Transient
    private MultipartFile headimage;
    private String headimageName;
    private String posted_date;

    public News() {
    }

    public News(String title, String description, MultipartFile headimage, String headimageName, String posted_date) {
        this.title = title;
        this.description = description;
        this.headimage = headimage;
        this.headimageName = headimageName;
        this.posted_date = posted_date;
    }

    public News(int id, String title, String description, MultipartFile headimage, String headimageName, String posted_date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.headimage = headimage;
        this.headimageName = headimageName;
        this.posted_date = posted_date;
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

    public String getPosted_date() {
        return posted_date;
    }

    public void setPosted_date(String posted_date) {
        this.posted_date = posted_date;
    }

}
