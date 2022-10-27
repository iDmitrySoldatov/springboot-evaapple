package ru.dmitrysoldatov.evaapple.services;

import ru.dmitrysoldatov.evaapple.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    void update(Integer id, ProductDTO productDTO);

    void deleteById(Integer id);

    void save(ProductDTO productDTO);

    List<ProductDTO> findAll();

    ProductDTO findById(Integer id);

}
