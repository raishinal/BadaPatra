/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp.controller;

import com.bp.models.SessionCount;
import com.bp.models.UserDetails;
import com.bp.service.ItemService;
import com.bp.service.SessionService;
import com.bp.service.UserService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class AdminController {

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime before = now.minusDays(21);
    String formattedDateTime = now.format(dtf);
    String formattedBefore = before.format(dtf);
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetails user;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetails userDetails;
    
    @Autowired
    private SessionCount sessionCount;
    
    @Autowired
    private ItemService itemService;

    @Autowired
    private SessionService sessionService;
    @GetMapping("/Admin/Home")
    public ModelAndView adminHome(ModelAndView mv) {
        mv.setViewName("admin/Dashboard");
        mv.addObject("pageviewcount",sessionService.getCount());
        mv.addObject("pageviewcountdate",sessionService.getDate());
        mv.addObject("documents",itemService.findAllItem());
        mv.addObject("sessions",sessionService.getAllSessionCount());
        return mv;
    }

    @GetMapping("/Admin/Register")
    public ModelAndView registerUser(ModelAndView mv) {

        mv.setViewName("admin/registration");

        return mv;
    }

    @RequestMapping(value = "/Admin/RegisterUser", method = RequestMethod.POST)
    public String registerUser(
            @RequestParam("fname") String fname,
            @RequestParam("lname") String lname,
            @RequestParam("email") String email,
            @RequestParam("phone") long phone,
            @RequestParam("dob") String dob,
            @RequestParam("country") String country,
            @RequestParam("interest") String interest,
            @RequestParam("address") String address,
            @RequestParam("image") MultipartFile image,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("cpassword") String cpassword,
            @RequestParam("userType") String userType
    ) {

        // password
        if (password.equals(cpassword)) {
            userDetails.setPassword(passwordEncoder.encode(password));
        } else {
            return "redirect:/Admin/Register?PasswordMismatch";
        }
        // image 
        if (!image.isEmpty()) {
            if (userService.uploadImage(image)) {
                userDetails.setImageName(image.getOriginalFilename());
            } else {
                return "redirect:/Admin/Register?ImageUploadFailed";
            }
        } else {
            return "redirect:/Admin/Register?ImageNotSelected";
        }

        // other form data
        userDetails.setFirstname(fname);
        userDetails.setLastname(lname);
        userDetails.setActive(0);
        userDetails.setEmail(email);
        userDetails.setPhone(phone);
        userDetails.setDob(LocalDate.parse(dob));
        userDetails.setCountry(country);
        userDetails.setInterest(interest);
        userDetails.setAddress(address);
        userDetails.setStartdate(formattedDateTime);
        userDetails.setUserName(username);
        userDetails.setUserType(userType);

        if (!userService.saveUser(userDetails)) {
            return "redirect:/Admin/Register?UserRegistrationFailed";
        }

        return "redirect:/Admin/Register?Success";
    }

     @RequestMapping(value = "/Admin/Pagecount/Reset/{id}", method = RequestMethod.GET)
    public String resetCount(@PathVariable int id) {
        sessionCount.setCount(0);
        sessionCount.setId(id);
        sessionCount.setDocumentid(sessionService.getSessionCount(id).getDocumentid());
        sessionCount.setDate(formattedDateTime);
        
        if (sessionService.updateCount(sessionCount)) {
             return "redirect:/Admin/Home";
        } 
        else{
             return "redirect:/Admin/Home?countresetfailed";
        }
       
    }
}
