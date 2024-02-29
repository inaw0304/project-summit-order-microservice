package com.projectsummit.ordermicroservice.config;

import com.projectsummit.ordermicroservice.dao.OrderDAO;
import com.projectsummit.ordermicroservice.entity.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class PopulateDB {

    @Bean
    CommandLineRunner commandLineRunner(OrderDAO orderDAO){

        return args -> {
            List<Order> orders = new ArrayList<>();
            orders.add(new Order(1L, 1L, 1L, 2, 50.0f, "Pending", new Date()));
            orders.add(new Order(2L, 1L, 2L, 1, 30.0f, "Completed", new Date(System.currentTimeMillis() - 86400000)));
            orders.add(new Order(3L, 2L, 3L, 3, 75.0f, "Shipped", new Date(System.currentTimeMillis() + 86400000)));
            orders.add(new Order(4L, 2L, 1L, 1, 25.0f, "Pending", new Date(System.currentTimeMillis() - 172800000)));
            orders.add(new Order(1L, 3L, 2L, 2, 60.0f, "Pending", new Date(System.currentTimeMillis() + 172800000)));
            orderDAO.saveAll(orders);

        };

    }
}
