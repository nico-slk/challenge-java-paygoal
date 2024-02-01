package com.paygoal.springh2.controller;

import com.paygoal.springh2.domain.entity.Product;
import com.paygoal.springh2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/productId/{productid}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer productid) {
        return ResponseEntity.ok(productService.getProductById(productid));
    }

    @GetMapping("/productName/{productName}")
    public ResponseEntity<Product> getProductByName(@PathVariable String productName) {
        return ResponseEntity.ok(productService.getProductByName(productName));
    }

    @GetMapping("/price")
    public ResponseEntity<List<Product>> getProductsSortedByPrice() {
        return ResponseEntity.ok(productService.getAllProducstByPrice());
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId, @RequestBody Product product) {
        return productService.updateProduct(productId, product);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer productId) {
        return productService.deleteProduct(productId);
    }

    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

}
