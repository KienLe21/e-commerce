package com.example.GEEKUP_test.Repository;

import com.example.GEEKUP_test.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>{
    List<Product> findProductsByCategory(String category);

    @Query("SELECT DISTINCT p.category FROM Product p")
    List<String> findAllCategories();
}
