package com.example.order.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseModel {
    private Long bookId;
    private Integer orderId;
    private String orderQuantity;
    private String orderPrice;
    private String email;
    private  String phoneNumber;

}
