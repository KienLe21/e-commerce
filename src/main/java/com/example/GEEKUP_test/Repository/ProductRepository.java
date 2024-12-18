package com.example.GEEKUP_test.Repository;

import com.example.GEEKUP_test.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
