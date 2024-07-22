package com.joy.productservicejune24.repositories;

import com.joy.productservicejune24.models.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //All methods (CRUD) related to Product Model should be here

    List<Product> findByPriceIsGreaterThan(Double price);
    //select * from products where price > ?   - equivalent to this query

    List<Product> findProductByTitleLike(String word);  // case sensitive
    //select * from products where title like '%iphone%'

    List<Product> findByTitleLikeIgnoreCase(String word); // case insensitive

    List<Product> findTop5ByTitleContains(String word);
    //select * from products where title like '%iphone%' LIMIT 5

    List<Product> findProductsByTitleContainsAndPriceGreaterThan(String word, Double price);

    List<Product> findProductsByTitleContainsOrderById(String word);

    Optional<Product> findById(Long id);

    List<Product> findAll(Sort sort);
}
