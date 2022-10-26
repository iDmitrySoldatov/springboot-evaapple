package ru.dmitrysoldatov.evaapple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dmitrysoldatov.evaapple.models.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
}
