package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.model.ProductLine;
import com.codegym.service.ProductLineService;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductLineController {

    @Autowired
    private ProductLineService productLineService;
    @Autowired
    private ProductService productService;

    @GetMapping("/create-productLine")
    public ModelAndView formCreate() {
        ModelAndView modelAndView = new ModelAndView("/productLine/create");
        modelAndView.addObject("productLine",new ProductLine());
        return modelAndView;
    }
    @PostMapping("/create-productLine")
    public ModelAndView createProductLine(@ModelAttribute ProductLine productLine) {
        productLineService.save(productLine);
        ModelAndView modelAndView = new ModelAndView("/productLine/create");
        modelAndView.addObject("productLine",new ProductLine());
        modelAndView.addObject("ms","Create successfully!");
        return modelAndView;
    }



}
