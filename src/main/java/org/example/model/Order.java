package org.example.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Entity
@Table(name = "orders")
@Schema(description = "Сущность заказа")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "id заказа")
    private int id;
    @Schema(description = "Название заказа")
    private String product;
    @Schema(description = "Количество")
    private int quantity;
    @Schema(description = "Цена закааз")
    private BigDecimal price;
    @Schema(description = "Статус заказа")
    private String status;
    @Schema(description = "Дата заказа")
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