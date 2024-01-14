package com.min.springbootmall.dao.Impl;

import com.min.springbootmall.constant.ProductCategory;
import com.min.springbootmall.dao.ProductDao;
import com.min.springbootmall.dto.ProductQueryParams;
import com.min.springbootmall.dto.ProductRequest;
import com.min.springbootmall.model.Product;
import com.min.springbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Product> getProducts(ProductQueryParams productQueryParams) {
        String sql = "select product_id,product_name, category, image_url, price, stock, description, " +
                "created_date, last_modified_date " +
                "from product WHERE 1=1";
        Map<String, Object> map = new HashMap<>();

        if (productQueryParams.getCategory() != null){
            sql = sql + " AND category = :category";
            map.put("category",productQueryParams.getCategory().name());
        }

        if (productQueryParams.getSearch() != null){
            sql = sql + " AND product_name LIKE :search";
            map.put("search","%" +productQueryParams.getSearch() + "%");
        }

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map,new ProductRowMapper());

        return productList;
    }

    @Override
    public Product getProductById(Integer productId) {
        String sql = "select product_id,product_name, category, image_url, price, stock, description, " +
                "created_date, last_modified_date " +
                "from product where product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);


        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        if (productList.size() > 0) {
            return productList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        String sql = "INSERT INTO product(product_name, category, image_url, price, stock ,description, created_date, last_modified_date)" +
                "VALUES (:productName, :category, :imageUrl, :price, :stock, :description , :createdDate, :lastModifiedDate)";

        Map<String ,Object> map = new HashMap<>();
        map.put("productName",productRequest.getProductName());
        map.put("category",productRequest.getCategory().toString());
        map.put("imageUrl",productRequest.getImageUrl());
        map.put("price",productRequest.getPrice());
        map.put("stock",productRequest.getStock());
        map.put("description",productRequest.getDescription());

        Date now = new Date();
        map.put("createdDate", now);
        map.put("lastModifiedDate", now);

        KeyHolder keyHandler = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHandler);

        int productId = keyHandler.getKey().intValue();
        return productId;
    }


    @Override
    public void updateProduct(Integer productsId, ProductRequest productRequest) {
        String sql = "UPDATE product SET product_name = :productName, category = :category, image_url = :imageUrl,"+
                "price = :price, stock = :stock, description = :description, last_modified_date = :lastModifiedDate" +
                " WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productsId);

        map.put("productName",productRequest.getProductName());
        map.put("category",productRequest.getCategory().toString());
        map.put("imageUrl",productRequest.getImageUrl());
        map.put("price",productRequest.getPrice());
        map.put("stock",productRequest.getStock());
        map.put("description",productRequest.getDescription());

        map.put("lastModifiedDate", new Date());

        namedParameterJdbcTemplate.update(sql,map);


    }

    @Override
    public void deleteProductById(Integer productId) {
        String sql = "DELETE FROM product WHERE product_id = :productId";

        Map <String,Object> map = new HashMap<>();
        map.put("productId",productId);

        namedParameterJdbcTemplate.update(sql, map);
    }
}
