package com.codegym.repository;

import com.codegym.model.ProductLine;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductLineRepository extends PagingAndSortingRepository<ProductLine,Long> {
}
