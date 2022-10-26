package ru.dmitrysoldatov.evaapple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dmitrysoldatov.evaapple.models.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
