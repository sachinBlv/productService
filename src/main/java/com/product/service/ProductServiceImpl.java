package com.product.service;

import com.product.model.Product;
import com.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return null;
    }

    @Override
    public Product getProductByName(String itemname) {
        return productRepository.getProductByName(itemname);
    }



    @Override
    public Product updateProduct(Product product) {

        Product product1 = productRepository.findById(product.getItemid()).get();
        product1.setCategory(product.getCategory());
        product1.setDop(product.getDop());
        product1.setItemname(product.getItemname());
        product1.setPrice(product.getPrice());
        return productRepository.save(product1);
    }

    @Override
    public int deleteProduct(String category) {
        return 0;
    }

    @Override
    public int getByCategory(String category) {
        List<Product> list = productRepository.getByCategory(category);
        for (int i = 0; i < list.size(); i++) {
            productRepository.delete(list.get(i));
        }
        return list.size();
    }
}
