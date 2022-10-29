package ru.dmitrysoldatov.evaapple.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitrysoldatov.evaapple.dto.OrderDTO;
import ru.dmitrysoldatov.evaapple.exception.ResourceNotFoundException;
import ru.dmitrysoldatov.evaapple.services.OrderService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {
    private OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/order")
    public List<OrderDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable Integer id) {
        OrderDTO orderDTO = service.findById(id);
        if (orderDTO == null) {
            throw new ResourceNotFoundException("Order not exist with id :" + id);
        } else {
            return ResponseEntity.ok(orderDTO);
        }
    }

    @PostMapping("/order")
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return service.save(orderDTO);
    }

    @PutMapping("/order/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Integer id,
                                                          @RequestBody OrderDTO orderDTO) {
        OrderDTO order = service.findById(id);
        if (order == null) {
            throw new ResourceNotFoundException("Order not exist with id :" + id);
        } else {
            order.setPhoneNumber(order.getPhoneNumber());
            order.setClienName(order.getClienName());
            order.setCity(order.getCity());
            order.setDateTime(order.getDateTime());
            order.setProduct(order.getProduct());

            OrderDTO upadateOrder = service.save(order);
            return ResponseEntity.ok(upadateOrder);
        }
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteOrder(@PathVariable Integer id) {
        OrderDTO order = service.findById(id);
        if (order == null) {
            throw new ResourceNotFoundException("Order not exist with id :" + id);
        } else {
            service.deleteById(id);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return ResponseEntity.ok(response);
        }
    }
}
