/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp.controller;

import com.bp.models.SessionCount;
import com.bp.service.CategoryService;
import com.bp.service.ItemService;
import com.bp.service.NewsService;
import com.bp.service.SessionService;
import com.bp.service.SubDocumentService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author roslm
 */
@Controller
public class HomeController {
    @Autowired
    CategoryService categoryService;
    
    @Autowired
    ItemService itemService;
    
    @Autowired
    SubDocumentService subDocumentService;
    
    @Autowired
    SessionService sessionService;
    
    @Autowired
    SessionCount sessionCount;
    
    @Autowired
    NewsService newsService;
    
     @GetMapping("/Index")
    public ModelAndView showIndex(ModelAndView mv) {
        SessionCount ses = sessionService.getCountbyDocument(0);
        int count =ses.getCount();
        count = count + 1;
        sessionCount.setCount(count);
        sessionCount.setId(0);
        sessionCount.setDocumentid(0);
        sessionCount.setDate(sessionService.getDate());

        if (sessionService.updateCount(sessionCount)) {
            mv.addObject("count", "countfailure");
        } else {
            mv.addObject("count", "countsuccess");
        }
        mv.addObject("categorylist",categoryService.findAllCategory());
        mv.addObject("documentlist",itemService.findAllItem());
        mv.addObject("populardocument",sessionService.getPopular());
        mv.addObject("news",newsService.findAllItem());
        mv.setViewName("index");
        return mv;
    }
    
       @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        return "accessDenied";
    }

    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/Logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth1 = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth1);
        if (auth1 != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth1);
        }
        return "redirect:/Index";
    }
    
    
    @GetMapping("/Document/{id}")
    public ModelAndView showSingleDocument(@PathVariable int id, ModelAndView mv) {
        SessionCount ses = sessionService.getCountbyDocument(id);
        int count =ses.getCount();
        count = count + 1;
        sessionCount.setCount(count);
        sessionCount.setId(ses.getId());
        sessionCount.setDocumentid(id);
        sessionCount.setDate(sessionService.getDate());

        if (sessionService.updateCount(sessionCount)) {
            mv.addObject("count", "countfailure");
        } else {
            mv.addObject("count", "countsuccess");
        }
        mv.addObject("categorylist", categoryService.findAllCategory());
        mv.addObject("documentlist", itemService.findAllItem());
        mv.addObject("item", itemService.findItemById(id));
        mv.addObject("sublist",subDocumentService.findMainItem(id));
        mv.setViewName("singledocument");
        return mv;
    }
    
     @RequestMapping(value = "/Search", method = RequestMethod.GET)
    public ModelAndView searchItem(@RequestParam("key") String key,
            ModelAndView mv) {
        mv.addObject("categorylist",categoryService.findAllCategory());
        mv.addObject("documentlist",itemService.findAllItem());
        mv.addObject("itemlist", itemService.findItemByKey(key));
        mv.setViewName("groupdocument");
        return mv;
    }
    
    
     @GetMapping("/News/{id}")
    public ModelAndView showSingleNews(@PathVariable int id, ModelAndView mv) {
        
        mv.addObject("categorylist", categoryService.findAllCategory());
        mv.addObject("documentlist", itemService.findAllItem());
        mv.addObject("item",newsService.findItemById(id));
        mv.setViewName("singlenews");
        return mv;
    }
}
