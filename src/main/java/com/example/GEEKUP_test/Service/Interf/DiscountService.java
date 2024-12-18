package com.example.GEEKUP_test.Service.Interf;

import com.example.GEEKUP_test.DTO.DiscountDTO;
import com.example.GEEKUP_test.DTO.Response;
import com.example.GEEKUP_test.Model.Discount;

public interface DiscountService {
    Response createDiscount(DiscountDTO discount);
    Response updateDiscount(DiscountDTO discount);
    Response deleteDiscount(String id);
    Response getDiscountById(String id);
    Response getAllDiscounts();

}
