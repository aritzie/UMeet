package com.umeet.umeet.controller;

import com.umeet.umeet.entities.Category;
import com.umeet.umeet.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequestMapping("/b/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ServerRepository serverRepository;

    @Autowired
    ChannelRepository channelRepository;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    MessageFileRepository messageFileRepository;

    /* @GetMapping("/form")
    public String viewCategoryCreation(Model model, Long idCategory, Long idServer) {
        Category category = new Category();
        if (idCategory == null) {
            category.setServer(serverRepository.findById(idServer).get());
        } else {
            category = categoryRepository.findById(idCategory).get();
        }
        model.addAttribute("category", category);
        return "formCategory";
    }*/
    
    @PostMapping("/form")
    public Category viewCategoryCreation(Long idCategory, Long idServer) {
        Category category = new Category();
        if (idCategory == null) {
            category.setServer(serverRepository.findById(idServer).get());
        } else {
            category = categoryRepository.findById(idCategory).get();
        }
       
        return category;
    }


    /*@PostMapping("/addCategory")
    public String addCategory(Category category, Long idServer){
        category.setServer(serverRepository.findById(idServer).get());
        if(category.getName()==null || ("").equals(category.getName())){
            return "redirect:server/one?idServer="+category.getServer().getId();
        }
        categoryRepository.save(category);
        return "redirect:server/one?idServer="+category.getServer().getId();
    }*/
    @PostMapping("/addCategory")
    public Category addCategory(Category category, Long idServer) {
        category.setServer(serverRepository.findById(idServer).get());
        if (category.getName() == null || ("").equals(category.getName())) {

        }
        categoryRepository.save(category);
        return category;

    }

    /* @GetMapping("/deleteCategory")
    public String deleteCategory(Long idCategory) {
        long idServer = categoryRepository.findById(idCategory).get().getServer().getId();
        categoryRepository.deleteById(idCategory);
        return "redirect:server/one?idServer=" + idServer;
    }*/
    @GetMapping("/deleteCategory")
    public Long deleteCategory(Long idCategory) {
        long idServer = categoryRepository.findById(idCategory).get().getServer().getId();
        categoryRepository.deleteById(idCategory);
        //return "redirect:server/one?idServer=" + idServer;
        return idServer;
    }

}
