package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.model.Order;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@Tag(name = "OrderController", description = "тестовое описание контроллера")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    @Operation(summary = "Создание заказа")
    public Order createOrder(@RequestBody Order order) {
        order.setorderdate();
        return orderService.saveOrder(order);
    }
    @GetMapping("/orders")
    @Operation(summary = "Получение всех заказов")
    public List<Order> getOrders() {
        if (!orderService.getAllOrders().isEmpty()) {
            return orderService.getAllOrders();
        } else {
            throw new RuntimeException("Orders not found");
        }
    }
    @GetMapping("/orders/{orderId}")
    @Operation(summary = "Получение заказа по id")
    public Order getOrder(@PathVariable Long orderId) {
        if (orderService.getOrderById(orderId) != null) {
            return orderService.getOrderById(orderId);
        } else {
            throw new RuntimeException("Order not found");
        }
    }
    @PutMapping("/orders/{orderId}")
    @Operation(summary = "Обновление данных заказа")
    public Order updateOrderById(@PathVariable Long orderId){
        Order order = orderService.getOrderById(orderId);
        order.setorderdate();
        return orderService.saveOrder(order);
    }
    @DeleteMapping("/orders/{orderId}")
    @Operation(summary = "Удаление заказа")
    public void deleteOrderById(@PathVariable Long orderId){
        orderService.deleteOrder(orderId);
    }
}
