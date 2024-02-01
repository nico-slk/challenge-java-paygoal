package com.paygoal.springh2.domain.repository;

import com.paygoal.springh2.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product getProductByName(String name);

}
