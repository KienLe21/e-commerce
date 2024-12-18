package com.example.GEEKUP_test.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class OrderDTO {
    Long id;
    LocalDate orderDate;
    Integer finalPrice;
    UserDTO user;
    List<ProductDTO> products;
    List<DiscountDTO> discounts;

}
