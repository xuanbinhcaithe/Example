package com.codegym.service.impl;

import com.codegym.model.ProductLine;
import com.codegym.repository.ProductLineRepository;
import com.codegym.service.ProductLineService;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductLineServiceImpl implements ProductLineService {
    @Autowired
    private ProductLineRepository productLineRepository;
    @Override
    public Iterable<ProductLine> findAll() {
        return productLineRepository.findAll();
    }

    @Override
    public ProductLine findById(Long id) {
        return productLineRepository.findOne(id);
    }

    @Override
    public void save(ProductLine productLine) {
        productLineRepository.save(productLine);
    }

    @Override
    public void remove(Long id) {
    productLineRepository.delete(id);
    }
}
