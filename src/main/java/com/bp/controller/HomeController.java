/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author roslm
 */
@Controller
public class HomeController {
    
    
     @GetMapping("/Index")
    public ModelAndView showIndex(ModelAndView mv) {
         System.out.println("hello");
        mv.setViewName("index");
        return mv;
    }
}
