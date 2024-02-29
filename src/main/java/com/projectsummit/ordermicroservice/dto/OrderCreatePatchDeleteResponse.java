package com.projectsummit.ordermicroservice.dto;

import com.projectsummit.ordermicroservice.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;


@Data
@AllArgsConstructor
public class OrderCreatePatchDeleteResponse {

    private String status;
    private Optional<Order> order;

}
