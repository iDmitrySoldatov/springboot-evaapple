package ru.dmitrysoldatov.evaapple.controllers;


import org.springframework.web.bind.annotation.*;
import ru.dmitrysoldatov.evaapple.models.Categories;
import ru.dmitrysoldatov.evaapple.repositories.CategoriesRepository;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    private final CategoriesRepository repository;

    public CategoriesController(CategoriesRepository repository){
        this.repository = repository;
    }

    @GetMapping("/test")
    public Categories get(@RequestParam int id){
       return this.repository.findById(id).get();
    }

}
