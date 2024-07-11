package com.joy.productservicejune24.controllers;

import com.joy.productservicejune24.models.Product;
import com.joy.productservicejune24.services.FakeStoreProductService;
import com.joy.productservicejune24.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController (ProductService productService){
        this.productService = productService;
    }

    // http://localhost:8075/products/10  here 10 is the id
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getSingleProduct(id);
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

//    public addNewProduct(){
//
//    }
}
