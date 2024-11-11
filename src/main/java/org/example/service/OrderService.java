package org.example.service;

import org.example.model.Order;
import org.example.repos.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id){
        return orderRepository.findById(id).orElse(null);
    }

    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }
}
