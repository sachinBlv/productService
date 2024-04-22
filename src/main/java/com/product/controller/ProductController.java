package com.product.controller;

import com.product.model.Product;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/item/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product  product1=null;
        try{
            if(product==null||product.toString().equals(null)||product.equals(null)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(product);
            }else{


                    product1= productService.addProduct(product);
                return ResponseEntity.status(HttpStatus.OK).body(product1);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());

        }finally {
            product1=null;
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(product1);
    }
@PutMapping("/item/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product product1 = productService.updateProduct(product);
        return ResponseEntity.status(HttpStatus.OK).body(product1);
    }
    @GetMapping("/getproduct/{itemName}")
    public ResponseEntity<Product> getProductByName(@PathVariable ("itemName") String itemname){
        Product productByName = productService.getProductByName(itemname);
        return ResponseEntity.status(HttpStatus.OK).body(productByName);
    }
    @DeleteMapping("/item")
    public String deleteProduct(@RequestParam String category){
        int byCategory = productService.getByCategory(category);
        String stringValue = String.format("total %d reocrd deleted successfully",byCategory);
        return stringValue ;
    }

}
