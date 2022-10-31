package ru.dmitrysoldatov.evaapple.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitrysoldatov.evaapple.dto.ProductDTO;
import ru.dmitrysoldatov.evaapple.exception.ResourceNotFoundException;
import ru.dmitrysoldatov.evaapple.services.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/product")
    public List<ProductDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Integer id) {
        ProductDTO productDTO = service.findById(id);
        if (productDTO == null) {
            throw new ResourceNotFoundException("Product not exist with id :" + id);
        } else {
            return ResponseEntity.ok(productDTO);
        }
    }

    @PostMapping("/product")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return service.save(productDTO);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Integer id,
                                                @RequestBody ProductDTO productDTO) {
        ProductDTO product = service.findById(id);
        if (product == null) {
            throw new ResourceNotFoundException("Product not exist with id :" + id);
        } else {
            product.setName(productDTO.getName());
            product.setDescription(productDTO.getDescription());
            product.setPrice(productDTO.getPrice());
            product.setCategoriesId(productDTO.getCategoriesId());
            product.setImagesURL(productDTO.getImagesURL());

            ProductDTO upadateProduct = service.save(product);
            return ResponseEntity.ok(upadateProduct);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Integer id) {
        ProductDTO prduct = service.findById(id);
        if (prduct == null) {
            throw new ResourceNotFoundException("Order not exist with id :" + id);
        } else {
            service.deleteById(id);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return ResponseEntity.ok(response);
        }
    }
}
