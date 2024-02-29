package com.projectsummit.ordermicroservice.service;

import com.projectsummit.ordermicroservice.dao.OrderDAO;
import com.projectsummit.ordermicroservice.dto.OrderCreatePatchDeleteResponse;
import com.projectsummit.ordermicroservice.entity.Order;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    private OrderDAO orderDAO;

    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO){
        this.orderDAO = orderDAO;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDAO.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Long orderId) {
        boolean exists = orderDAO.existsById(orderId);

        if(!exists){
            return null;
        }

        Optional<Order> order = orderDAO.findById(orderId);
        return order;
    }

    @Override
    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderDAO.getOrdersByCustomerId(customerId);
    }

    @Override
    public List<Order> getOrdersBySellerId(Long sellerId) {
        return orderDAO.getOrdersBySellerId(sellerId);
    }

    @Override
    @Transactional
    public OrderCreatePatchDeleteResponse createOrder(Order order) {
        orderDAO.save(order);
        return new OrderCreatePatchDeleteResponse("success",orderDAO.findById(order.getId()));

    }

    @Override
    @Transactional
    public OrderCreatePatchDeleteResponse updateOrder(Long orderId, Order order) {
        boolean exists = orderDAO.existsById(orderId);

        if(!exists){
            return new OrderCreatePatchDeleteResponse("Order not found for order id = "+ orderId, null);
        }

        Optional<Order> foundOrder = orderDAO.findById(orderId);
        if(foundOrder.isPresent()){

            if(order.getStatus()!=null){
                foundOrder.get().setStatus(order.getStatus());
            }

        }else{
            return new OrderCreatePatchDeleteResponse("Order not found for order id = "+ orderId, null);
        }

        return new OrderCreatePatchDeleteResponse("success",foundOrder);
    }

    @Override
    @Transactional
    public OrderCreatePatchDeleteResponse createOrderById(Long orderId) {
        boolean exists = orderDAO.existsById(orderId);

        if(!exists){
            return new OrderCreatePatchDeleteResponse("Order not found for order id = "+ orderId, null);
        }

        Optional<Order> order = orderDAO.findById(orderId);

        orderDAO.deleteById(orderId);

        return new OrderCreatePatchDeleteResponse("success",order);
    }


}
