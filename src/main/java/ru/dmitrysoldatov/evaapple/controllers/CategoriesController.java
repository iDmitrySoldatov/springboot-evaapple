package ru.dmitrysoldatov.evaapple.controllers;

import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitrysoldatov.evaapple.dto.CategoriesDTO;
import ru.dmitrysoldatov.evaapple.exception.ResourceNotFoundException;
import ru.dmitrysoldatov.evaapple.services.CategoriesService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CategoriesController {
    private CategoriesService service;

    @Autowired
    public CategoriesController(CategoriesService service) {
        this.service = service;
    }

    @GetMapping("/categories")
    public List<CategoriesDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoriesDTO> getCategories(@PathVariable Integer id) {
        CategoriesDTO categories = service.findById(id);
        if (categories == null) {
            throw new ResourceNotFoundException("Categories not exist with id :" + id);
        } else {
            return ResponseEntity.ok(categories);
        }
    }

    @PostMapping("/categories")
    public CategoriesDTO createCategories(@RequestBody CategoriesDTO categoriesDTO) {
        return service.save(categoriesDTO);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoriesDTO> updateCategories(@PathVariable Integer id,
                                                          @RequestBody CategoriesDTO categoriesDTO) {
        CategoriesDTO categories = service.findById(id);
        if (categories == null) {
            throw new ResourceNotFoundException("Categories not exist with id :" + id);
        } else {
            categories.setParentId(categoriesDTO.getParentId());
            categories.setName(categoriesDTO.getName());
            categories.setCategoriesURL(categoriesDTO.getCategoriesURL());

            CategoriesDTO upadateCategories = service.save(categories);
            return ResponseEntity.ok(upadateCategories);
        }
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCategories(@PathVariable Integer id) {
        CategoriesDTO categories = service.findById(id);
        if (categories == null) {
            throw new ResourceNotFoundException("Categories not exist with id :" + id);
        } else {
            service.deleteById(id);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return ResponseEntity.ok(response);
        }
    }
}
