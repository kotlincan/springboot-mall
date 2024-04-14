package com.min.springbootmall.service;

import com.min.springbootmall.dto.ProductQueryParams;
import com.min.springbootmall.dto.ProductRequest;
import com.min.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(ProductQueryParams productQueryParams);
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productsId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

    Integer countProduct(ProductQueryParams productQueryParams);
}
