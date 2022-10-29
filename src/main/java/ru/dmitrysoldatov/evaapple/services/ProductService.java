package ru.dmitrysoldatov.evaapple.services;

import ru.dmitrysoldatov.evaapple.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    void deleteById(Integer id);

    void save(ProductDTO productDTO);

    List<ProductDTO> findAll();

    ProductDTO findById(Integer id);

}
