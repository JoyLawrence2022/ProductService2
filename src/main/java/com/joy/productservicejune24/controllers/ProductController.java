package com.joy.productservicejune24.controllers;

import com.joy.productservicejune24.exceptions.ProductNotFoundException;
import com.joy.productservicejune24.models.Product;
import com.joy.productservicejune24.services.FakeStoreProductService;
import com.joy.productservicejune24.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        ResponseEntity<Product> response =
                new ResponseEntity<>(
                        productService.getSingleProduct(id),
                        HttpStatus.OK
                );
        return response;
    }

/*
    // THIS METHOD WORKS, BUT NOW WE ARE ADDING OUR OWN EXCEP. HANDLING CLASS
    // http://localhost:8075/products/10  here 10 is the id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
        ResponseEntity<Product> responseEntity = null;

        try{
            Product product = productService.getSingleProduct(id);
            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        } catch (RuntimeException e){
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }
*/


/*  // THIS METHOD WORKS, BUT NOW WE ARE ADDING EXCEP. HANDLING
    // http://localhost:8075/products/10  here 10 is the id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
        ResponseEntity<Product> responseEntity =
                new ResponseEntity<>(
                        productService.getSingleProduct(id),
                        HttpStatus.OK
                );
        return responseEntity;
    }
*/

/*    This method works, but now we are adding ResponseEntity as well
    // http://localhost:8075/products/10  here 10 is the id
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getSingleProduct(id);
    }
 */

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }


    public void deleteProduct(Long productId){

    }

    // THIS CODE IS NOT FULLY COMPLETE, SHOWING ERROR IN POSTMAN
    // PATCH => http://localhost:8075/products/1
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(Long id, Product product){
        return null;
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException(){
        ResponseEntity<String> response = new ResponseEntity<>(
                "ArrayIndexOutOfBoundException has happened, Inside the Controller",
                HttpStatus.BAD_REQUEST
        );

        return response;
    }
}
