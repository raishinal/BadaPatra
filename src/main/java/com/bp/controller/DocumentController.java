/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp.controller;

import com.bp.models.Document;
import com.bp.models.SessionCount;
import com.bp.models.SubDocument;
import com.bp.service.CategoryService;
import com.bp.service.ItemService;
import com.bp.service.SessionService;
import com.bp.service.SubDocumentService;
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
public class DocumentController {

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    String formattedDateTime = now.format(dtf);

    @Autowired
    Document item;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ItemService itemService;

    @Autowired
    SubDocument subDocument;

    @Autowired
    SubDocumentService subDocumentService;

    @Autowired
    SessionService sessionService;
    @Autowired
    SessionCount sessionCount;

    @GetMapping("/Admin/Document/Add")
    public ModelAndView addDocument(ModelAndView mv) {
        mv.addObject("categorylist", categoryService.findAllCategory());
        mv.setViewName("admin/adddocument");
        return mv;
    }

    @RequestMapping(value = "/Admin/Document/Add", method = RequestMethod.POST)
    public String registerUser(@RequestParam("title") String title,
            @RequestParam("category") int category,
            @RequestParam("description") String description,
            @RequestParam("headimage") MultipartFile headimage,
            @RequestParam("sampleimage") MultipartFile sampleimage
    ) {

        // image 
        if (!headimage.isEmpty()) {
            if (itemService.uploadImage1(headimage)) {
                item.setHeadimageName(headimage.getOriginalFilename());
            } else {
                return "redirect:/Admin/Document/Add?ImageNotUploaded";
            }
        } else {
            return "redirect:/Admin/Document/Add?ImageNotSelected";
        }
        // image 
        if (!sampleimage.isEmpty()) {
            if (itemService.uploadImage2(sampleimage)) {
                item.setSampleimageName(sampleimage.getOriginalFilename());
            } else {
                return "redirect:/Admin/Document/Add?ImageNotUploaded";
            }
        } else {
            return "redirect:/Admin/Document/Add?ImageNotSelected";
        }

        // other form data
        item.setTitle(title);
        item.setCategory(category);
        item.setDescription(description);
        item.setLikecounts(0);
        item.setPosted_date(formattedDateTime);

        if (!itemService.addItem(item)) {

            return "redirect:/Admin/Document/Add?Failed";
        } else {
            Document dc= itemService.findItemByTitle(title);
            sessionCount.setCount(0);
            sessionCount.setDate(formattedDateTime);
            sessionCount.setDocumentid(dc.getId());
            if(sessionService.save(sessionCount)){
                 return "redirect:/Admin/Document/Add?Success";
            }
            else
            return "redirect:/Admin/Document/Add?Failure";
        }
    }

    @GetMapping("/Admin/Document/Show")
    public ModelAndView showItems(ModelAndView mv) {
        mv.addObject("itemlist", itemService.findAllItem());
        mv.addObject("categorylist", categoryService.findAllCategory());
        mv.setViewName("admin/showdocument");
        return mv;
    }

    @RequestMapping(value = "/Admin/Document/Edit/{id}", method = RequestMethod.GET)
    public ModelAndView editDocument(@PathVariable int id, ModelAndView mv) {
        mv.addObject("categorylist", categoryService.findAllCategory());
        mv.addObject("item", itemService.findItemById(id));
        mv.setViewName("admin/editdocument");
        return mv;
    }

    @RequestMapping(value = "/Admin/Document/Update", method = RequestMethod.POST)
    public String updateDocument(
            @RequestParam("id") int id,
            @RequestParam("title") String title,
            @RequestParam("category") int category,
            @RequestParam("description") String description,
            @RequestParam("headimagename") String headimagename,
            @RequestParam("headimage") MultipartFile headimage,
            @RequestParam("sampleimagename") String sampleimagename,
            @RequestParam("sampleimage") MultipartFile sampleimage
    ) {

        // image 
        if (!headimage.isEmpty()) {
            if (itemService.uploadImage1(headimage)) {
                item.setHeadimageName(headimage.getOriginalFilename());
            } else {
                return "redirect:/Admin/Document/Show?ImageUploadFailed";
            }
        } else {

            item.setHeadimageName(headimagename);

        }
        if (!sampleimage.isEmpty()) {
            if (itemService.uploadImage1(sampleimage)) {
                item.setSampleimageName(sampleimage.getOriginalFilename());
            } else {
                return "redirect:/Admin/Document/Show?ImageUploadFailed";
            }
        } else {

            item.setSampleimageName(sampleimagename);

        }
        Document i = itemService.findItemById(id);

        // other form data
        item.setId(id);
        item.setTitle(title);
        item.setCategory(category);
        item.setDescription(description);
        item.setLikecounts(i.getLikecounts());
        item.setPosted_date(i.getPosted_date());

        if (itemService.updateItem(item)) {
//            sessionCount.setCount(0);
//            sessionCount.setDate(formattedDateTime);
//            sessionCount.setDocumentid(id);
//            if (sessionService.save(sessionCount)) {
//                return "redirect:/Admin/Document/Show?Success";
//            }
//            else{
            return "redirect:/Admin/Document/Show?Failed";
        } else {
            return "redirect:/Admin/Document/Show?failed";

        }

    }

    @RequestMapping(value = "/Admin/Document/Delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable int id) {
        if (itemService.deleteItem(id)) {
            return "redirect:/Admin/Document/Show?Success";

        } else {
            return "redirect:/Admin/Document/Show?Failed";
        }
    }

    @GetMapping("/Admin/SubDocument/Add")
    public ModelAndView addSubDocument(ModelAndView mv) {
        mv.addObject("categorylist", itemService.findAllItem());
        mv.setViewName("admin/addsubdocument");
        return mv;
    }

    @RequestMapping(value = "/Admin/SubDocument/Add", method = RequestMethod.POST)
    public String addsubDocument(@RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("main") int main
    ) {

        subDocument.setDescrpition(description);
        subDocument.setMainDocument(main);
        subDocument.setTitle(title);

        if (!subDocumentService.addItem(subDocument)) {
            return "redirect:/Admin/SubDocument/Add?Failed";
        } else {
            return "redirect:/Admin/SubDocument/Add?Success";
        }
    }

    @GetMapping("/Admin/SubDocument/Show")
    public ModelAndView showSubItems(ModelAndView mv) {
        mv.addObject("itemlist", subDocumentService.findAllItem());
        mv.setViewName("admin/displaysubdocument");
        return mv;
    }

    @RequestMapping(value = "/Admin/SubDocument/Edit/{id}", method = RequestMethod.GET)
    public ModelAndView editSubDocument(@PathVariable int id, ModelAndView mv) {
        mv.addObject("categorylist", subDocumentService.findAllItem());
        mv.addObject("item", subDocumentService.findItemById(id));
        mv.setViewName("admin/editsubdocument");
        return mv;
    }

    @RequestMapping(value = "/Admin/SubDocument/Update", method = RequestMethod.POST)
    public String updateSubDocument(
            @RequestParam("id") int id,
            @RequestParam("title") String title,
            @RequestParam("main") int main,
            @RequestParam("description") String description
    ) {

        SubDocument i = subDocumentService.findItemById(id);

        // other form data
        subDocument.setId(id);
        subDocument.setTitle(title);
        subDocument.setMainDocument(main);
        subDocument.setDescrpition(description);

        if (!subDocumentService.updateItem(subDocument)) {
            return "redirect:/Admin/SubDocument/Show?failed";
        } else {

            return "redirect:/Admin/SubDocument/Show?Success";
        }

    }

    @RequestMapping(value = "/Admin/SubDocument/Delete/{id}", method = RequestMethod.GET)
    public String deleteSubDocument(@PathVariable int id) {
        if (subDocumentService.deleteItem(id)) {
            return "redirect:/Admin/SubDocument/Show?Success";

        } else {
            return "redirect:/Admin/SubDocument/Show?Failed";
        }
    }

}
