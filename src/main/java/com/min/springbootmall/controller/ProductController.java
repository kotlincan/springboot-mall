package com.min.springbootmall.controller;

import com.min.springbootmall.constant.ProductCategory;
import com.min.springbootmall.dto.ProductQueryParams;
import com.min.springbootmall.dto.ProductRequest;
import com.min.springbootmall.model.Product;
import com.min.springbootmall.service.ProductService;
import com.min.springbootmall.util.Page;
import jdk.jfr.Percentage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

   @GetMapping("/products")
    public ResponseEntity<Page<Product>> getProducts(
            //查詢條件 Filtering
            @RequestParam(required = false) ProductCategory category,
            @RequestParam(required = false) String search,

            // 排序 Sorting
            @RequestParam(defaultValue = "created_date") String orderBy,
            @RequestParam(defaultValue = "desc") String sort,

            //分頁 Pagination
            @RequestParam(defaultValue = "5") @Max(1000) @Min(0) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0) Integer offset
   ){
       ProductQueryParams productQueryParams = new ProductQueryParams();
       productQueryParams.setCategory(category);
       productQueryParams.setSearch(search);
       productQueryParams.setOrderBy(orderBy);
       productQueryParams.setSort(sort);
       productQueryParams.setLimit(limit);
       productQueryParams.setOffset(offset);

       // 取得 product list
       List<Product> products = productService.getProducts(productQueryParams);

       // 取得product 總數
      Integer total  = productService.countProduct(productQueryParams);

      //分頁
       Page<Product> page = new Page<>();
       page.setLimit(limit);
       page.setOffset(offset);
       page.setTotal(total);
       page.setResults(products);
       return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);

        if (product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {
     Integer productId = productService.createProduct(productRequest);

     Product product = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/products/{productsId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productsId,
                                                 @RequestBody @Valid ProductRequest productRequest){
        //檢查product 是否存在
        Product product = productService.getProductById(productsId);

        if (product == null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        //修改商品數據
        productService.updateProduct(productsId,productRequest);

        Product updatedProduct = productService.getProductById(productsId);

        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
    }

    @DeleteMapping("products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
        productService.deleteProductById(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();



    }
}
