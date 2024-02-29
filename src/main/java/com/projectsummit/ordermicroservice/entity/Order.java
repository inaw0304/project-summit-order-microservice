package com.projectsummit.ordermicroservice.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "orders")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long sellerId;
    private Long customerId;
    private Long productId;
    private int quantity;
    private float totalPrice;
    private String status;


    @Temporal(TemporalType.TIMESTAMP)
    private Date orderTime;

    // Constructor with everything except id
    public Order(Long sellerId, Long customerId, Long productId, int quantity, float totalPrice, String status, Date orderTime) {
        this.sellerId = sellerId;
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.status = status;
        this.orderTime = orderTime;
    }



}
