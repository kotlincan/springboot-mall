package com.min.springbootmall.service;

import com.min.springbootmall.constant.ProductCategory;
import com.min.springbootmall.dto.ProductRequest;
import com.min.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(ProductCategory category, String search);
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productsId, ProductRequest productRequest);

    void deleteProductById(Integer productId);


}
