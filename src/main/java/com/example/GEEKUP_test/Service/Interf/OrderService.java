package com.example.GEEKUP_test.Service.Interf;

import com.example.GEEKUP_test.DTO.Response;
import com.example.GEEKUP_test.Model.Order;

import java.util.List;

public interface OrderService {
    Response createOrder(String userId, List<String> productIds, List<String> discountIds);
    Response getOrderById(String id);
    Response getAllOrders();
}
