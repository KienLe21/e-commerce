package com.example.GEEKUP_test.Controller;


import com.example.GEEKUP_test.DTO.ProductDTO;
import com.example.GEEKUP_test.DTO.Response;
import com.example.GEEKUP_test.Model.Product;
import com.example.GEEKUP_test.Service.Interf.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/add-product")
    public ResponseEntity<Response> addProduct(@RequestBody ProductDTO product) {
        Response response = productService.addProduct(product);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PutMapping("/update-product")
    public ResponseEntity<Response> updateProduct(@RequestBody ProductDTO product) {
        Response response = productService.updateProduct(product);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @DeleteMapping("/delete-product/{id}")
    public ResponseEntity<Response> deleteProduct(@PathVariable String id) {
        Response response = productService.deleteProduct(id);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/get-product/{id}")
    public ResponseEntity<Response> getProductById(@PathVariable String id) {
        Response response = productService.getProductById(id);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/get-all-products")
    public ResponseEntity<Response> getAllProducts() {
        Response response = productService.getAllProducts();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/get-product-by-category/{category}")
    public ResponseEntity<Response> getProductByCategory(@PathVariable String category) {
        Response response = productService.getProductByCategory(category);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/get-all-categories")
    public ResponseEntity<Response> getAllCategories() {
        Response response = productService.getAllCategories();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

}
