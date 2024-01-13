package com.min.springbootmall.service;

import com.min.springbootmall.dto.ProductRequest;
import com.min.springbootmall.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productsId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
