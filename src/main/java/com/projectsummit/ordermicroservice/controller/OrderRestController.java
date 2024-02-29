package com.projectsummit.ordermicroservice.controller;

import com.projectsummit.ordermicroservice.dto.OrderCreatePatchDeleteResponse;
import com.projectsummit.ordermicroservice.entity.Order;
import com.projectsummit.ordermicroservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OrderRestController {

    private OrderService orderService;

    @Autowired
    public OrderRestController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<Order> getOrder(){
        return this.orderService.getAllOrders();
    }

    @GetMapping("/orders/{orderId}")
    public Optional<Order> getOrderById(@PathVariable("orderId") Long orderId){
        return orderService.getOrderById(orderId);
    }

    @GetMapping("/orders/customerId={customerId}")
    public List<Order> getOrdersByCustomerId(@PathVariable("customerId") Long customerId){
        return orderService.getOrdersByCustomerId(customerId);
    }

    @GetMapping("/orders/sellerId={sellerId}")
    public List<Order> getOrdersBySellerId(@PathVariable("sellerId") Long sellerId){
        return orderService.getOrdersBySellerId(sellerId);
    }

    @PostMapping("/orders")
    public OrderCreatePatchDeleteResponse createNewOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }

    @PatchMapping("/orders/{orderId}")
    public OrderCreatePatchDeleteResponse updateOrder(@PathVariable("orderId") Long orderId,@RequestBody Order order){
        return orderService.updateOrder(orderId,order);
    }

    @DeleteMapping("/orders/{orderId}")
    public OrderCreatePatchDeleteResponse deleteOrder(@PathVariable("orderId") Long orderId){
        return orderService.createOrderById(orderId);
    }

}
