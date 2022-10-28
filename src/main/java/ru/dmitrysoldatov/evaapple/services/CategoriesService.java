package ru.dmitrysoldatov.evaapple.services;

import ru.dmitrysoldatov.evaapple.dto.CategoriesDTO;

import java.util.List;

public interface CategoriesService {

    void update(Integer id, CategoriesDTO categoriesDTO);

    void deleteById(Integer id);

    void save(CategoriesDTO categoriesDTO);

    List<CategoriesDTO> findAll();

    CategoriesDTO findById(Integer id);
}
