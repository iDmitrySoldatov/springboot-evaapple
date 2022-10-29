package ru.dmitrysoldatov.evaapple.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dmitrysoldatov.evaapple.convert.ConverterDTO;
import ru.dmitrysoldatov.evaapple.dto.CategoriesDTO;
import ru.dmitrysoldatov.evaapple.models.Categories;
import ru.dmitrysoldatov.evaapple.repositories.CategoriesRepository;
import ru.dmitrysoldatov.evaapple.services.CategoriesService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CategoriesServiceImp implements CategoriesService {
    private CategoriesRepository repository;

    private ConverterDTO converterDTO;

    @Autowired
    public CategoriesServiceImp(CategoriesRepository repository, ConverterDTO converterDTO) {
        this.repository = repository;
        this.converterDTO = converterDTO;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public CategoriesDTO save(CategoriesDTO categoriesDTO) {
        Categories categories = repository.save(converterDTO.convertToCategories(categoriesDTO));
        return  converterDTO.convertToCategoriesDTO(categories);
    }

    @Override
    public List<CategoriesDTO> findAll() {
        List<Categories> categoriesList = repository.findAll();
        return converterDTO.convertListToCategoriesDTO(categoriesList);
    }

    @Override
    public CategoriesDTO findById(Integer id) {
        Optional<Categories> optionalCategories = repository.findById(id);
        if (!optionalCategories.isEmpty()) {
            Categories categories = optionalCategories.get();
            return converterDTO.convertToCategoriesDTO(categories);
        } else {
            return null;
        }
    }
}
