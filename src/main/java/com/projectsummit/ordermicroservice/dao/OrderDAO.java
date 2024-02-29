package com.projectsummit.ordermicroservice.dao;

import com.projectsummit.ordermicroservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO extends JpaRepository<Order,Long> {

    List<Order> getOrdersByCustomerId(Long customerId);
    List<Order> getOrdersBySellerId(Long sellerId);
}
