package com.example.GEEKUP_test.Service.Impl;

import com.example.GEEKUP_test.DTO.OrderDTO;
import com.example.GEEKUP_test.DTO.Response;
import com.example.GEEKUP_test.Exception.MyException;
import com.example.GEEKUP_test.Mapper.DiscountMapper;
import com.example.GEEKUP_test.Mapper.ProductMapper;
import com.example.GEEKUP_test.Mapper.UserMapper;
import com.example.GEEKUP_test.Model.Discount;
import com.example.GEEKUP_test.Model.Order;
import com.example.GEEKUP_test.Model.Product;
import com.example.GEEKUP_test.Repository.DiscountRepository;
import com.example.GEEKUP_test.Repository.OrderRepository;
import com.example.GEEKUP_test.Repository.ProductRepository;
import com.example.GEEKUP_test.Repository.UserRepository;
import com.example.GEEKUP_test.Service.Interf.OrderService;
import com.example.GEEKUP_test.Service.Interf.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final DiscountRepository discountRepository;
    private final UserMapper userMapper;
    private final ProductMapper productMapper;
    private final DiscountMapper discountMapper;

    @Override
    public Response createOrder(String userId, List<String> productIds, List<String> discountIds) {
        Response response = new Response();
        try {
            Order order = new Order();
            OrderDTO orderDTO = new OrderDTO();
            var user = userRepository.findById(Long.parseLong(userId)).orElseThrow(() -> new MyException("User not found"));
            List<Product> products = new ArrayList<>();
            for (String productId : productIds) {
                var product = productRepository.findById(Long.parseLong(productId)).orElseThrow(() -> new MyException("Product not found"));
                products.add(product);
            }
            List<Discount> discounts = new ArrayList<>();
            for (String discountId : discountIds) {
                var discount = discountRepository.findById(Long.parseLong(discountId)).orElseThrow(() -> new MyException("Discount not found"));
                discounts.add(discount);
            }

            order.setUser(user);
            orderDTO.setUser(userMapper.toUserDTO(user));
            order.setProducts(products);
            orderDTO.setProducts(productMapper.toProductDTOList(products));
            order.setDiscounts(discounts);
            orderDTO.setDiscounts(discountMapper.toDiscountDTOList(discounts));
            order.setOrderDate(LocalDate.now());
            orderDTO.setOrderDate(LocalDate.now());
            Integer finalPrice = 0;
            for (Product product : products) {
                finalPrice += product.getPrice();
            }
            for (Discount discount : discounts) {
                finalPrice -= finalPrice * discount.getDiscount() / 100;
            }
            order.setFinalPrice(finalPrice);
            orderDTO.setFinalPrice(finalPrice);
            Order newOrder = orderRepository.save(order);
            response.setOrder(orderDTO);
            response.setStatusCode(200);
            response.setMessage("Order created successfully");
        } catch (Exception e) {
            response.setStatusCode(400);
            response.setMessage("Order creation failed");
        }
        return response;
    }

    @Override
    public Response getOrderById(String id) {
        Response response = new Response();
        try {
            var order = orderRepository.findById(Long.parseLong(id)).orElseThrow(() -> new MyException("Order not found"));
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setId(order.getId());
            orderDTO.setUser(userMapper.toUserDTO(order.getUser()));
            orderDTO.setProducts(productMapper.toProductDTOList(order.getProducts()));
            orderDTO.setDiscounts(discountMapper.toDiscountDTOList(order.getDiscounts()));
            orderDTO.setOrderDate(order.getOrderDate());
            orderDTO.setFinalPrice(order.getFinalPrice());
            response.setOrder(orderDTO);
            response.setStatusCode(200);
            response.setMessage("Order found successfully");
        } catch (Exception e) {
            response.setStatusCode(400);
            response.setMessage("Order not found");
        }
        return response;
    }

    @Override
    public Response getAllOrders() {
        Response response = new Response();
        try {
            List<Order> orders = orderRepository.findAll();
            List<OrderDTO> orderDTOList = new ArrayList<>();
            for (Order order : orders) {
                OrderDTO orderDTO = new OrderDTO();
                orderDTO.setId(order.getId());
                orderDTO.setUser(userMapper.toUserDTO(order.getUser()));
                orderDTO.setProducts(productMapper.toProductDTOList(order.getProducts()));
                orderDTO.setDiscounts(discountMapper.toDiscountDTOList(order.getDiscounts()));
                orderDTO.setOrderDate(order.getOrderDate());
                orderDTO.setFinalPrice(order.getFinalPrice());
                orderDTOList.add(orderDTO);
            }
            response.setOrderList(orderDTOList);
            response.setStatusCode(200);
            response.setMessage("Orders found successfully");
        } catch (Exception e) {
            response.setStatusCode(400);
            response.setMessage("Orders not found");
        }
        return response;
    }
}
