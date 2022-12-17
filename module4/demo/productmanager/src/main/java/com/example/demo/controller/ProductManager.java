package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductTypeService;
import com.example.demo.validate.ValidateProduct;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.Column;
import javax.validation.Valid;

@Controller
public class ProductManager {
    @Autowired
    ProductService productService;
    @Autowired
    ProductTypeService productTypeService;
    @Autowired
    ValidateProduct validateProduct;

    @GetMapping("list")
    public String displayAll(Model model){
        model.addAttribute("listProduct",productService.findAll());
        return "list";
    }
    @GetMapping("create")
    public String showCreate(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("listProductType",productTypeService.findAll());
        return "create";
    }
    @PostMapping("create")
    public String doCreate(@Valid @ModelAttribute(value = "product")Product product, BindingResult bindingResult, Model model){
        validateProduct.validate(product,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("listProductType",productTypeService.findAll());
            return "create";
        }
        productService.addProduct(product);
        return "redirect:/list";
    }

}
