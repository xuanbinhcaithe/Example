package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "productLine")
public class ProductLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(targetEntity = Product.class)
    private List<Product> products;


    public ProductLine(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public ProductLine() {
    }

    public ProductLine(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
