package com.example.GEEKUP_test.Controller;


import com.example.GEEKUP_test.DTO.DiscountDTO;
import com.example.GEEKUP_test.DTO.Response;
import com.example.GEEKUP_test.Model.Discount;
import com.example.GEEKUP_test.Service.Interf.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class DiscountController {
    private final DiscountService discountService;

    @PostMapping("/create-discount")
    public ResponseEntity<Response> addDiscount(@RequestBody DiscountDTO discount) {
        Response response = discountService.createDiscount(discount);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PutMapping("/update-discount")
    public ResponseEntity<Response> updateDiscount(@RequestBody DiscountDTO discount) {
        Response response = discountService.updateDiscount(discount);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @DeleteMapping("/delete-discount/{id}")
    public ResponseEntity<Response> deleteDiscount(@PathVariable String id) {
        Response response = discountService.deleteDiscount(id);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/get-discount/{id}")
    public ResponseEntity<Response> getDiscountById(@PathVariable String id) {
        Response response = discountService.getDiscountById(id);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/get-all-discounts")
    public ResponseEntity<Response> getAllDiscounts() {
        Response response = discountService.getAllDiscounts();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}
