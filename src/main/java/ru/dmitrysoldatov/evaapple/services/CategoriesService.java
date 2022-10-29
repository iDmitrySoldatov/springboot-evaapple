package ru.dmitrysoldatov.evaapple.services;

import ru.dmitrysoldatov.evaapple.dto.CategoriesDTO;

import java.util.List;

public interface CategoriesService {
    void deleteById(Integer id);

    CategoriesDTO save(CategoriesDTO categoriesDTO);

    List<CategoriesDTO> findAll();

    CategoriesDTO findById(Integer id);
}
