package com.codegym.model;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;
    @NotEmpty
    private String name;

    private float price;
    private Long amount;
    private String dateCreate;
    @Lob
    private String description;

    @ManyToOne
    @JoinColumn(name = "productLine_id")
    private ProductLine productLine;

    public ProductLine getProductLine() {
        return productLine;
    }

    public void setProductLine(ProductLine productLine) {
        this.productLine = productLine;
    }

    public Product(@NotEmpty String name, float price, Long amount, String dateCreate, String description, ProductLine productLine) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.dateCreate = dateCreate;
        this.description = description;
        this.productLine = productLine;
    }

    public Product() {
    }

    public Product(@NotEmpty String name, float price, Long amount, String dateCreate, String description) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.dateCreate = dateCreate;
        this.description = description;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
