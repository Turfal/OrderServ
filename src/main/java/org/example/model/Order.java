package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String product;
    private int quantity;
    private BigDecimal price;
    private String status;
    private LocalDate orderdate;

    public Order(){}
    public Order(int id, String product, int quantity, BigDecimal price, String status, LocalDate orderdate) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.orderdate = orderdate;
    }

    // Getters and setters

    public void setId(int id) {
        this.id = id;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setorderdate() {
        this.orderdate = LocalDate.now();
    }
}