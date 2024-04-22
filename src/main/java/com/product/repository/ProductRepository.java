package com.product.repository;

import com.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
//    @Query
//    Product getProductByName(String itemname);
@Query(value = "SELECT * FROM product_table WHERE itemname = :itemname", nativeQuery = true)
Product getProductByName(String itemname);
    @Query(value = "SELECT * FROM product_table WHERE category = :category", nativeQuery = true)
    List<Product> getByCategory(String category);
}
