package com.min.springbootmall.dao;

import com.min.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
