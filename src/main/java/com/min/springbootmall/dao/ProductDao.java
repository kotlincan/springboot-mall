package com.min.springbootmall.dao;

import com.min.springbootmall.dto.ProductRequest;
import com.min.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productsId, ProductRequest productRequest);
}
