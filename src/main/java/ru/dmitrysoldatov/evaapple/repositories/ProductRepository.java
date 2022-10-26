package ru.dmitrysoldatov.evaapple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dmitrysoldatov.evaapple.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
