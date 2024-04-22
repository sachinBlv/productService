package com.product.service;

import com.product.model.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    List<Product> getAllProduct();

    Product updateProduct(Product product);
    int deleteProduct(String category);
   Product getProductByName(String itemname);
   int getByCategory(String category);
}
