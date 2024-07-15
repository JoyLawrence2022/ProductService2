package com.joy.productservicejune24.services;

import com.joy.productservicejune24.exceptions.ProductNotFoundException;
import com.joy.productservicejune24.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product updateProduct(Long id, Product product);

    Product replaceProduct(Long id, Product product);

    void deleteProduct(Long id);
}
