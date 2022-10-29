package ru.dmitrysoldatov.evaapple.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dmitrysoldatov.evaapple.convert.ConverterDTO;
import ru.dmitrysoldatov.evaapple.dto.OrderDTO;
import ru.dmitrysoldatov.evaapple.models.Order;
import ru.dmitrysoldatov.evaapple.repositories.OrderRepository;
import ru.dmitrysoldatov.evaapple.services.OrderService;

import java.util.List;
import java.util.Optional;
@Service
@Transactional(readOnly = true)
public class OrderServiceImp implements OrderService {
    private OrderRepository repository;

    private ConverterDTO converterDTO;

    @Autowired
    public OrderServiceImp(OrderRepository repository, ConverterDTO converterDTO) {
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
    public OrderDTO save(OrderDTO orderDTO) {
        Order order = repository.save(converterDTO.convertToOrder(orderDTO));
        return converterDTO.convertToOrderDTO(order);
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
