package com.example.blogapp.rest_controller;

import com.example.blogapp.form.BlogForm;
import com.example.blogapp.model.Blog;
import com.example.blogapp.model.Category;
import com.example.blogapp.service.IBlogService;
import com.example.blogapp.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public ResponseEntity<List<Blog>> getListBlog() {
        return new ResponseEntity<>(blogService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable("id") Integer id) {
        Blog blog = blogService.getBlogById(id);
        if (blog == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
    }

    @GetMapping("/findBlogByCategory/{categoryId}")
    public ResponseEntity<List<Blog>> getListBlogByCategoryId(@PathVariable("categoryId") Integer categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(blogService.findBlogByCategory(category), HttpStatus.OK);
    }

//    @PostMapping("/create")
//    public String createBlog(@RequestBody BlogForm blogForm) {
//        Integer id = Integer.parseInt(blogForm.getId());
//        String name = blogForm.getName();
//        String content = blogForm.getContent();
//        Category category = categoryService.getCategoryById(Integer.parseInt(blogForm.getCategoryId()));
//
//        Blog blog = new Blog(id, name, content, category);
//        blogService.save(blog);
//        return "success";
//    }
}
