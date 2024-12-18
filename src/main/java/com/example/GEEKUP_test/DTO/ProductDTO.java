package com.example.GEEKUP_test.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class ProductDTO {
    Long id;
    String name;
    String size;
    Integer price;
    Integer quantity;
    String color;

}
