package com.joy.productservicejune24.services;

import com.joy.productservicejune24.dtos.FakeStoreProductDto;
import com.joy.productservicejune24.models.Category;
import com.joy.productservicejune24.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;

    public FakeStoreProductService (RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        //Call FakeStore to fetch the Product with given id. => HTTP call.
        //restTemplate.getForObject will make a GET call to the given URL,
        //the URL will return a JSON object which will be in String format and this data
        //will be converted into my datatype which is mentioned in the second part
        //of this method i.e. FakeStoreProductDto.class
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDto.class
        );

        //convert FakeStoreProductDto into Product and return Product
        return convertFakeStoreProductToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProductDto){
        //convert FakeStoreProductDto into Product
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());

        Category category = new Category();
        category.setDescription(fakeStoreProductDto.getDescription());
        product.setCategory(category);

        return product;
    }
}
