package com.min.springbootmall.dto;

import com.min.springbootmall.constant.ProductCategory;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class ProductRequest {

    @NotNull
    private String ProductName;
    @NotNull
    private ProductCategory Category;
    @NotNull
    private String ImageUrl;
    @NotNull
    private int Price;
    @NotNull
    private int Stock;
    private String Description;

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public ProductCategory getCategory() {
        return Category;
    }

    public void setCategory(ProductCategory category) {
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
}
