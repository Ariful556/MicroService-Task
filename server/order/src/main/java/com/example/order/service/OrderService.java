package com.example.order.service;

import com.example.order.model.OrderRequestModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    ResponseEntity<Object> create(OrderRequestModel orderRequestModel);

    ResponseEntity<Object> getAllOrder();

    void deleteOrder(Long bookId);

    ResponseEntity<Object> orderDetails(Long bookId);
//    ResponseEntity<Object> orderDetails(Integer orderId);
}
