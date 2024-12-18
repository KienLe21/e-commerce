package com.example.GEEKUP_test.DTO;

import com.example.GEEKUP_test.Model.Discount;
import com.example.GEEKUP_test.Model.Order;
import com.example.GEEKUP_test.Model.Product;
import com.example.GEEKUP_test.Model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserDTO {
    Long id;
    String name;
    String email;
    String phoneNumber;
    String province;
    String district;
    String commune;
    String address;
    String housingType;

}
