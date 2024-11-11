package org.example.controller;

import org.example.model.Order;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        order.setorderdate();
        return orderService.saveOrder(order);
    }
    @GetMapping("/orders")
    public List<Order> getOrders() {
        if (!orderService.getAllOrders().isEmpty()) {
            return orderService.getAllOrders();
        } else {
            throw new RuntimeException("Orders not found");
        }
    }
    @GetMapping("/orders/{orderId}")
    public Order getOrder(@PathVariable Long orderId) {
        if (orderService.getOrderById(orderId) != null) {
            return orderService.getOrderById(orderId);
        } else {
            throw new RuntimeException("Order not found");
        }
    }
    @PutMapping("/orders/{orderId}")
    public Order updateOrderById(@PathVariable Long orderId){
        Order order = orderService.getOrderById(orderId);
        order.setorderdate();
        return orderService.saveOrder(order);
    }
    @DeleteMapping("/orders/{orderId}")
    public void deleteOrderById(@PathVariable Long orderId){
        orderService.deleteOrder(orderId);
    }
}
