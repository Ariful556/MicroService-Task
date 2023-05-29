package com.example.order.controller;

import com.example.order.config.FeignClientConfig;
import com.example.order.model.BookResponseModel;
import com.example.order.model.OrderRequestModel;
import com.example.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final FeignClientConfig feignClientConfig;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody OrderRequestModel orderRequestModel) {
        Long bookId = orderRequestModel.getBookId();

        ResponseEntity<BookResponseModel> bookResponse;
        BookResponseModel book;

        try {
            bookResponse = feignClientConfig.bookDetails(bookId);
            book = bookResponse.getBody();

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Book not found!");
        }

        return orderService.create(orderRequestModel);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllOrder() {
        return orderService.getAllOrder();
    }

    @DeleteMapping("/delete/{bookId}")
    public void deleteOrder(@PathVariable Long bookId) {
        orderService.deleteOrder(bookId);
    }

    @GetMapping("/id/{orderId}")
    public ResponseEntity<Object> bookDetails(@PathVariable Long bookId) {
        return orderService.orderDetails(bookId);
    }
}
