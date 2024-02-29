package com.projectsummit.ordermicroservice.service;

import com.projectsummit.ordermicroservice.dto.OrderCreatePatchDeleteResponse;
import com.projectsummit.ordermicroservice.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAllOrders();

    Optional<Order> getOrderById(Long orderId);

    List<Order> getOrdersByCustomerId(Long customerId);

    List<Order> getOrdersBySellerId(Long sellerId);

    OrderCreatePatchDeleteResponse createOrder(Order order);

    OrderCreatePatchDeleteResponse createOrderById(Long orderId);

    OrderCreatePatchDeleteResponse updateOrder(Long orderId, Order order);
}
