package com.min.springbootmall.model;

import javax.xml.crypto.Data;
import java.sql.Timestamp;


public class Product {

    private Integer ProductId;
    private String ProductName;
    private String Category;
    private String ImageUrl;
    private int Price;
    private int Stock;
    private String Description;
    private Timestamp CreatedDate;
    private Timestamp LastModifiedDate;

    public Integer getProductId() {
        return ProductId;
    }

    public void setProductId(Integer productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Timestamp getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        CreatedDate = createdDate;
    }

    public Timestamp getLastModifiedDate() {
        return LastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        LastModifiedDate = lastModifiedDate;
    }




}
