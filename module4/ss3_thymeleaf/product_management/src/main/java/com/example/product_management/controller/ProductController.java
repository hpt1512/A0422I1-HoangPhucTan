package com.example.product_management.controller;

import com.example.product_management.bean.Product;
import com.example.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    IProductService productService;
    @GetMapping("/list")
    public String listProduct(Model model) {
        model.addAttribute("productList", productService.findAll());
        return "product/list";
    }

    @GetMapping("/create")
    public String formCreateProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product/create";
    }
    @PostMapping("/create")
    public String doCreate(@ModelAttribute("product") Product product) {
        productService.createOrUpdate(product);
        return "redirect:/list";
    }

    @GetMapping("/update")
    public String formUpdateProduct(Model model, @RequestParam("id") int id) {
        model.addAttribute("product", productService.findById(id));
        return "product/update";
    }
    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("product") Product product) {
        productService.createOrUpdate(product);
        return "redirect:/list";
    }
    @GetMapping("/delete")
    public String deleteProduct(Model model, @RequestParam("id") int id) {
        productService.deleteById(id);
        return "redirect:/list";
    }
    @GetMapping("/find")
    public String findProduct(Model model, @RequestParam("inputFind") String inputFind) {
        List<Product> productList = productService.findByName(inputFind);
        model.addAttribute("productList", productList);
        if ("".equals(inputFind)) {
            return "redirect:/list";
        } else {
            return "product/list";
        }
    }
}
