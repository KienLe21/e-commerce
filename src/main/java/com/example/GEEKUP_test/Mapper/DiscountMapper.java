package com.example.GEEKUP_test.Mapper;

import com.example.GEEKUP_test.DTO.DiscountDTO;
import com.example.GEEKUP_test.Model.Discount;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiscountMapper {
    DiscountDTO toDiscountDTO(Discount user);
    Discount toDiscount(DiscountDTO userDTO);
    List<DiscountDTO> toDiscountDTOList(List<Discount> discounts);
}
