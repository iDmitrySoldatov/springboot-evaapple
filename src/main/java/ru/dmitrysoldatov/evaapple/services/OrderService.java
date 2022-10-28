package ru.dmitrysoldatov.evaapple.services;

import ru.dmitrysoldatov.evaapple.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    void update(Integer id, OrderDTO orderDTO);

    void deleteById(Integer id);

    void save(OrderDTO orderDTO);

    List<OrderDTO> findAll();

    OrderDTO findById(Integer id);
}
