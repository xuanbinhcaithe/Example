package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.model.ProductLine;
import com.codegym.service.ProductLineService;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductLineService productLineService;


    @ModelAttribute("productLine")
    public Iterable<ProductLine> viewProductLine(){
        return productLineService.findAll();
    }

    @GetMapping("/create-product")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }
    @PostMapping("/create-product")
    public ModelAndView createProduct(@ModelAttribute Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("ms","Create successfully!");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }
    @GetMapping("/products")
    public ModelAndView listProduct(@RequestParam("s") Optional<String> s, Pageable pageable) {
        Page<Product> products;
        if (s.isPresent()) {
            products = productService.findAllByNameContaining(s.get(),pageable);
        }else {
            products = productService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("product",products);
        return modelAndView;
    }
    @GetMapping("/edit-product/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") Long id) {
        Product product = productService.findById(id);
        if (product != null) {
            ModelAndView modelAndView = new ModelAndView("/product/edit");
            modelAndView.addObject("product",product);
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("/error.404");
        return modelAndView;
    }
    @PostMapping("/edit-product")
    public ModelAndView updateProduct(@ModelAttribute Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/product/edit");
        modelAndView.addObject("product",product);
        modelAndView.addObject("ms","update successfully!");
        return modelAndView;
    }
    @GetMapping("/delete-product/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long id) {
        Product product = productService.findById(id);
        if (product != null) {
            ModelAndView modelAndView = new ModelAndView("/product/delete");
            modelAndView.addObject("product",product);
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("/error");
        return modelAndView;
    }
    @PostMapping("/delete-product")
    public String deleteProduct(@ModelAttribute Product product) {
        productService.remove(product.getCode());
        return "redirect:products";
    }
}
