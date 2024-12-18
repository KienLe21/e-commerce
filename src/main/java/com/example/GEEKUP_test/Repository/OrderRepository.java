package com.example.GEEKUP_test.Repository;

import com.example.GEEKUP_test.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
