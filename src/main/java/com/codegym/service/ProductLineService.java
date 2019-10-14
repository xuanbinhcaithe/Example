package com.codegym.service;

import com.codegym.model.ProductLine;

public interface ProductLineService {
    Iterable<ProductLine> findAll();
    ProductLine findById(Long id);
    void save(ProductLine productLine);
    void remove(Long id);
}
