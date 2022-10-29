package ru.dmitrysoldatov.evaapple.services;

import ru.dmitrysoldatov.evaapple.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    void deleteById(Integer id);

    OrderDTO save(OrderDTO orderDTO);

    List<OrderDTO> findAll();

    OrderDTO findById(Integer id);
}
