package com.min.springbootmall.dao;

import com.min.springbootmall.dto.ProductRequest;
import com.min.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts();

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productsId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
