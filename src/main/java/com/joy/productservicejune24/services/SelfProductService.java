package com.joy.productservicejune24.services;

import com.joy.productservicejune24.exceptions.ProductNotFoundException;
import com.joy.productservicejune24.models.Category;
import com.joy.productservicejune24.models.Product;
import com.joy.productservicejune24.repositories.CategoryRepository;
import com.joy.productservicejune24.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        // Make a call to DB to fetch a product with given ID.
        Optional<Product> productOptional = productRepository.findById(productId);

        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product with id: " + productId +
                    " doesn't exist");
        }

        return productOptional.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product addNewProduct(Product product) {
        Category category = product.getCategory();

        if(category.getId() == null){
            //Create a new Category object in the DB
            category = categoryRepository.save(category);
            product.setCategory(category); //this category will have a new category ID
        }
        return productRepository.save(product);
    }
}
