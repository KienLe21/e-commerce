package com.example.GEEKUP_test.Service.Impl;

import com.example.GEEKUP_test.DTO.ProductDTO;
import com.example.GEEKUP_test.DTO.Response;
import com.example.GEEKUP_test.Exception.MyException;
import com.example.GEEKUP_test.Mapper.ProductMapper;
import com.example.GEEKUP_test.Model.Product;
import com.example.GEEKUP_test.Repository.ProductRepository;
import com.example.GEEKUP_test.Service.Interf.ProductService;
import com.example.GEEKUP_test.Service.Interf.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Response addProduct(ProductDTO product) {
        Response response = new Response();
        try {
            Product newProduct = productMapper.toProduct(product);
            productRepository.save(newProduct);
            response.setStatusCode(200);
            response.setMessage("Product added successfully");
            response.setProduct(product);
        } catch (Exception e) {
            response.setStatusCode(400);
            response.setMessage("Product added failed");
        }
        return response;
    }

    @Override
    public Response updateProduct(ProductDTO product) {
        Response response = new Response();
        try {
            Product newProduct = productMapper.toProduct(product);
            productRepository.save(newProduct);
            response.setStatusCode(200);
            response.setMessage("Product updated successfully");
        } catch (Exception e) {
            response.setStatusCode(400);
            response.setMessage("Product updated failed");
        }
        return response;
    }

    @Override
    public Response deleteProduct(String id) {
        Response response = new Response();
        try {
            var product = productRepository.findById(Long.parseLong(id)).orElseThrow(() -> new MyException("Product not found"));
            productRepository.delete(product);
            response.setStatusCode(200);
            response.setMessage("Product deleted successfully");
        } catch (Exception e) {
            response.setStatusCode(400);
            response.setMessage("Product deleted failed");
        }
        return response;
    }

    @Override
    public Response getProductById(String id) {
        Response response = new Response();
        try {
            var product = productRepository.findById(Long.parseLong(id)).orElseThrow(() -> new MyException("Product not found"));
            response.setStatusCode(200);
            response.setMessage("Product found successfully");
            response.setProduct(productMapper.toProductDTO(product));
        } catch (Exception e) {
            response.setStatusCode(400);
            response.setMessage("Product not found");
        }
        return response;
    }

    @Override
    public Response getAllProducts() {
        Response response = new Response();
        try {
            response.setStatusCode(200);
            response.setMessage("All products retrieved successfully");
            response.setProductList(productRepository.findAll().stream().map(productMapper::toProductDTO).toList());
        } catch (Exception e) {
            response.setStatusCode(400);
            response.setMessage("Failed to retrieve all products");
        }
        return response;
    }


}
