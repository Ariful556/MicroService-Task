package com.example.order.service;

import com.example.order.entity.OrderEntity;
import com.example.order.model.OrderRequestModel;
import com.example.order.model.OrderResponseModel;
import com.example.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public ResponseEntity<Object> create(OrderRequestModel orderRequestModel) {
        OrderEntity orderEntity = OrderEntity.builder()
                .orderId(orderRequestModel.getOrderId())
                .bookId(orderRequestModel.getBookId())
                .orderQuantity(orderRequestModel.getOrderQuantity())
                .orderPrice(orderRequestModel.getOrderPrice())
                .email(orderRequestModel.getEmail())
                .phoneNumber(orderRequestModel.getPhoneNumber())
                .build();
        OrderEntity savedOrder = orderRepository.save(orderEntity);
        OrderResponseModel orderResponseModel = OrderResponseModel.builder()
                .orderId(savedOrder.getOrderId())
                .bookId(savedOrder.getBookId())
                .orderQuantity(savedOrder.getOrderQuantity())
                .orderPrice(savedOrder.getOrderPrice())
                .email(savedOrder.getEmail())
                .phoneNumber(savedOrder.getPhoneNumber())
                .build();
        return new ResponseEntity<>(orderResponseModel, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> getAllOrder() {
        List<OrderEntity> OrderList = orderRepository.findAll();
        List<OrderResponseModel> responseList = new ArrayList<>();
        for (OrderEntity order : OrderList) {
            OrderResponseModel orderResponseModel = OrderResponseModel.builder()
                    .orderId(order.getOrderId())
                    .bookId(order.getBookId())
                    .orderQuantity(order.getOrderQuantity())
                    .orderPrice(order.getOrderPrice())
                    .email(order.getEmail())
                    .phoneNumber(order.getPhoneNumber())
                    .build();
            responseList.add(orderResponseModel);
        }
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }


    public void deleteOrder(Long bookId) {
        OrderEntity orderEntity = orderRepository.findByOrderId(bookId);
        if (orderEntity != null) {
            orderRepository.delete(orderEntity);
        }

    }
    public ResponseEntity<Object> orderDetails(Long bookId) {
        OrderEntity orderEntity = orderRepository.findByOrderId(bookId);
        if (orderEntity != null) {
            OrderResponseModel orderResponseModel = OrderResponseModel.builder()
                    .orderId(orderEntity.getOrderId())
                    .orderQuantity(orderEntity.getOrderQuantity())
                    .orderPrice(orderEntity.getOrderPrice())
                    .email(orderEntity.getEmail())
                    .phoneNumber(orderEntity.getPhoneNumber())
                    .build();
            return new ResponseEntity<>(orderResponseModel, HttpStatus.OK);
        }
        return new ResponseEntity<>(new RuntimeException("Nothing Found"), HttpStatus.NOT_FOUND);
    }
}
