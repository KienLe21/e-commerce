package com.example.GEEKUP_test.DTO;

import com.example.GEEKUP_test.Model.Discount;
import com.example.GEEKUP_test.Model.Order;
import com.example.GEEKUP_test.Model.Product;
import com.example.GEEKUP_test.Model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    int statusCode;
    String message;
    UserDTO user;
    ProductDTO product;
    DiscountDTO discount;
    OrderDTO order;
    List<UserDTO> userList;
    List<ProductDTO> productList;
    List<DiscountDTO> discountList;
    List<OrderDTO> orderList;

}
