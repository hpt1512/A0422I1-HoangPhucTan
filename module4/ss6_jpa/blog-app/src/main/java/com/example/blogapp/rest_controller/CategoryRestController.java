package com.example.blogapp.rest_controller;

import com.example.blogapp.model.Blog;
import com.example.blogapp.model.Category;
import com.example.blogapp.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categogy")
public class CategoryRestController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("list")
    public ResponseEntity<List<Category>> getListCategory() {
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

}
