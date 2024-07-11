package com.joy.productservicejune24.services;

import com.joy.productservicejune24.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId);
    List<Product> getAllProducts();
}
