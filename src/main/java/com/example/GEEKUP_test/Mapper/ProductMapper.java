package com.example.GEEKUP_test.Mapper;

import com.example.GEEKUP_test.DTO.ProductDTO;
import com.example.GEEKUP_test.DTO.UserDTO;
import com.example.GEEKUP_test.Model.Product;
import com.example.GEEKUP_test.Model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toProductDTO(Product user);
    Product toProduct(ProductDTO userDTO);
    List<ProductDTO> toProductDTOList(List<Product> products);
}
