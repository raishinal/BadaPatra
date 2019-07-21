/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp.controller;

import com.bp.models.News;
import com.bp.service.CategoryService;
import com.bp.service.NewsService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author roslm
 */
@Controller

public class NewsController {

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    String formattedDateTime = now.format(dtf);
    @Autowired
    News news;

    @Autowired
    NewsService newsService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/Admin/News/Add")
    public ModelAndView addNews(ModelAndView mv) {
        mv.setViewName("admin/addnews");
        return mv;
    }

    @RequestMapping(value = "/Admin/News/Add", method = RequestMethod.POST)
    public String addNews(@RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("headimage") MultipartFile headimage
    ) {

        // image 
        if (!headimage.isEmpty()) {
            if (newsService.uploadImage1(headimage)) {
                news.setHeadimageName(headimage.getOriginalFilename());
            } else {
                return "redirect:/Admin/Document/Add?ImageNotUploaded";
            }
        } else {
            return "redirect:/Admin/Document/Add?ImageNotSelected";
        }

        // other form data
        news.setTitle(title);
        news.setDescription(description);
        news.setPosted_date(formattedDateTime);

        if (!newsService.addItem(news)) {
            return "redirect:/Admin/News/Add?Failed";
        } else {
            return "redirect:/Admin/News/Add?Success";
        }
    }

    @GetMapping("/Admin/News/Show")
    public ModelAndView showNews(ModelAndView mv) {
        mv.addObject("itemlist", newsService.findAllItem());
        mv.setViewName("admin/shownews");
        return mv;
    }

    @RequestMapping(value = "/Admin/News/Edit/{id}", method = RequestMethod.GET)
    public ModelAndView editNews(@PathVariable int id, ModelAndView mv) {
        mv.addObject("item", newsService.findItemById(id));
        mv.setViewName("admin/editnews");
        return mv;
    }

    
    
     @RequestMapping(value ="/Admin/News/Update", method = RequestMethod.POST)
    public String updateNews(
            @RequestParam("id") int id,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("headimagename") String headimagename,
            @RequestParam("headimage") MultipartFile headimage
    ) {

        // image 
        if (!headimage.isEmpty()) {
            if (newsService.uploadImage1(headimage)) {
               news.setHeadimageName(headimage.getOriginalFilename());
            } else {
                return "redirect:/Admin/Document/Show?ImageUploadFailed";
            }
        } else {

            news.setHeadimageName(headimagename);

        }
        
        News i = newsService.findItemById(id);

        // other form data
        news.setId(id);
        news.setDescription(description);
        news.setTitle(title);
        news.setPosted_date(i.getPosted_date());
        if (!newsService.updateItem(news)) {
            return "redirect:/Admin/News/Show?failed";
        } else {

            return "redirect:/Admin/News/Show?Success";
        }

    }

    @RequestMapping(value = "/Admin/News/Delete/{id}", method = RequestMethod.GET)
    public String deleteNews(@PathVariable int id) {
        if (newsService.deleteItem(id)) {
            return "redirect:/Admin/News/Show?Success";

        } else {
            return "redirect:/Admin/News/Show?Failed";
        }
    }
}
