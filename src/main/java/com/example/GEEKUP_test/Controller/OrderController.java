package com.example.GEEKUP_test.Controller;


import com.example.GEEKUP_test.DTO.Response;
import com.example.GEEKUP_test.Service.Interf.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create-order/{userId}")
    public ResponseEntity<Response> createOrder(@PathVariable String userId,
                                                @RequestPart List<String> productIds,
                                                @RequestPart List<String> discountIds) {
        Response response = orderService.createOrder(userId, productIds, discountIds);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/get-order/{id}")
    public ResponseEntity<Response> getOrderById(@PathVariable String id) {
        Response response = orderService.getOrderById(id);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/get-all-orders")
    public ResponseEntity<Response> getAllOrders() {
        Response response = orderService.getAllOrders();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}
