package ru.dmitrysoldatov.evaapple.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import ru.dmitrysoldatov.evaapple.convert.ConverterDTO;
import ru.dmitrysoldatov.evaapple.dto.OrderDTO;
import ru.dmitrysoldatov.evaapple.models.Order;
import ru.dmitrysoldatov.evaapple.repositories.OrderRepository;
import ru.dmitrysoldatov.evaapple.services.OrderService;

import java.util.List;
import java.util.Optional;

public class OrderServiceImp implements OrderService {
    private OrderRepository repository;

    private ConverterDTO converterDTO;

    @Autowired
    public OrderServiceImp(OrderRepository repository, ConverterDTO converterDTO) {
        this.repository = repository;
        this.converterDTO = converterDTO;
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void save(OrderDTO orderDTO) {
        repository.save(converterDTO.convertToOrder(orderDTO));
    }

    @Override
    public List<OrderDTO> findAll() {
        List<Order> orderList = repository.findAll();
        return converterDTO.convertListToOrderDTO(orderList);
    }

    @Override
    public OrderDTO findById(Integer id) {
        Optional<Order> optionalOrder = repository.findById(id);
        if (!optionalOrder.isEmpty()) {
            Order order = optionalOrder.get();
            return converterDTO.convertToOrderDTO(order);
        } else {
            return null;
        }
    }
}
