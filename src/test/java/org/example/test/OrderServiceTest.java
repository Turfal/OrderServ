package org.example.test;

import org.example.model.Order;
import org.example.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    void orderListIsNotEmpty() {
        var orders = orderService.getAllOrders();
        assertFalse(orders.isEmpty(), "Бд пустая");
    }

    @Test
    void orderCanSaveData(){
        Order order = new Order();
        order.setPrice(BigDecimal.valueOf(1212));
        order.setQuantity(1);
        order.setorderdate();
        order.setProduct("test");
        order.setStatus("test");

        assertNotNull(orderService.saveOrder(order), "Ордер не сохранился");
    }

    @Test
    void getOrderById() {
        Order order = new Order();
        order.setPrice(BigDecimal.valueOf(1212));
        order.setQuantity(1);
        order.setorderdate();
        order.setProduct("test");
        order.setStatus("test");
        Order savedOrder = orderService.saveOrder(order);

        Order retrievedOrder = orderService.getOrderById((long) savedOrder.getId());

        assertEquals(savedOrder.getId(), retrievedOrder.getId());
        assertEquals(savedOrder.getProduct(), retrievedOrder.getProduct());
        assertEquals(savedOrder.getQuantity(), retrievedOrder.getQuantity());
    }

    @Test
    void deleteOrder() {
        Order order = new Order();
        order.setPrice(BigDecimal.valueOf(1212));
        order.setQuantity(1);
        order.setorderdate();
        order.setProduct("test");
        order.setStatus("test");
        Order savedOrder = orderService.saveOrder(order);

        orderService.deleteOrder((long) savedOrder.getId());

        Order deletedOrder = orderService.getOrderById((long) savedOrder.getId());
        assertNull(deletedOrder);
    }
}