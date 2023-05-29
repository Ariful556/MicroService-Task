package com.example.order.config;

//import com.example.orderservice.model.BookResponseModel;
import com.example.order.model.BookResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book-shop-application")
public interface FeignClientConfig {


    @GetMapping("books/id/{bookId}")
    public ResponseEntity<BookResponseModel> bookDetails(@PathVariable("bookId") Long bookId);
}