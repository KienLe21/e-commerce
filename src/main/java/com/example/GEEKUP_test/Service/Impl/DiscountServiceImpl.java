package com.example.GEEKUP_test.Service.Impl;

import com.example.GEEKUP_test.DTO.DiscountDTO;
import com.example.GEEKUP_test.DTO.Response;
import com.example.GEEKUP_test.Mapper.DiscountMapper;
import com.example.GEEKUP_test.Model.Discount;
import com.example.GEEKUP_test.Repository.DiscountRepository;
import com.example.GEEKUP_test.Service.Interf.DiscountService;
import com.example.GEEKUP_test.Service.Interf.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepository discountRepository;
    private final DiscountMapper discountMapper;

    @Override
    public Response createDiscount(DiscountDTO discount) {
        Response response = new Response();
        try {
            Discount newDiscount = discountMapper.toDiscount(discount);
            discountRepository.save(newDiscount);
            response.setMessage("Discount created successfully");
            response.setStatusCode(200);
            response.setDiscount(discount);
        } catch (Exception e) {
            response.setMessage("Discount created failed");
            response.setStatusCode(400);
        }
        return response;
    }

    @Override
    public Response updateDiscount(DiscountDTO discount) {
        Response response = new Response();
        try {
            Discount newDiscount = discountMapper.toDiscount(discount);
            discountRepository.save(newDiscount);
            response.setMessage("Discount updated successfully");
            response.setStatusCode(200);
        } catch (Exception e) {
            response.setMessage("Discount updated failed");
            response.setStatusCode(400);
        }
        return response;
    }

    @Override
    public Response deleteDiscount(String id) {
        Response response = new Response();
        try {
            var discount = discountRepository.findById(Long.parseLong(id)).get();
            discountRepository.delete(discount);
            response.setMessage("Discount deleted successfully");
            response.setStatusCode(200);
        } catch (Exception e) {
            response.setMessage("Discount deleted failed");
            response.setStatusCode(400);
        }
        return response;
    }

    @Override
    public Response getDiscountById(String id) {
        Response response = new Response();
        try {
            var discount = discountRepository.findById(Long.parseLong(id)).get();
            response.setDiscount(discountMapper.toDiscountDTO(discount));
            response.setMessage("Get discount successfully");
            response.setStatusCode(200);
        } catch (Exception e) {
            response.setMessage("Get discount failed");
            response.setStatusCode(400);
        }
        return response;
    }

    @Override
    public Response getAllDiscounts() {
        Response response = new Response();
        try {
            response.setDiscountList(discountRepository.findAll().stream().map(discountMapper::toDiscountDTO).toList());
            response.setMessage("Get all discounts successfully");
            response.setStatusCode(200);
        } catch (Exception e) {
            response.setMessage("Get all discounts failed");
            response.setStatusCode(400);
        }
        return response;
    }

}
