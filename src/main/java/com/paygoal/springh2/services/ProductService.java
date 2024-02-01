package com.paygoal.springh2.services;

import com.paygoal.springh2.domain.entity.Product;
import com.paygoal.springh2.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(Integer productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public Product getProductByName(String name) {
        return productRepository.getProductByName(name);
    }

    public List<Product> getAllProducstByPrice() {
        return productRepository.findAll(Sort.by("price"));
    }

    public ResponseEntity<Product> updateProduct(Integer productid, Product product) {
        if (product.getProductId() != null || !this.productExist(product.getProductId())) {
            product.setProductId(productid);
            return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    private boolean productExist(Integer productId) {
        return productRepository.existsById(productId);
    }

    public ResponseEntity<Void> deleteProduct(Integer productId) {
        if (this.productExist(productId)) {
            productRepository.deleteById(productId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
