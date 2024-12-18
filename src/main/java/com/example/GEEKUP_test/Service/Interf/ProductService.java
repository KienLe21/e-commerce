package com.example.GEEKUP_test.Service.Interf;

import com.example.GEEKUP_test.DTO.ProductDTO;
import com.example.GEEKUP_test.DTO.Response;
import com.example.GEEKUP_test.Model.Product;

public interface ProductService {
    Response addProduct(ProductDTO product);
    Response updateProduct(ProductDTO product);
    Response deleteProduct(String id);
    Response getProductById(String id);
    Response getAllProducts();
    Response getProductByCategory(String category);
    Response getAllCategories();
}
