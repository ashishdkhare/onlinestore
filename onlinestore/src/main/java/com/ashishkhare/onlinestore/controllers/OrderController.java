package com.ashishkhare.onlinestore.controllers;

import com.ashishkhare.onlinestore.models.Orders;
import com.ashishkhare.onlinestore.models.RequestToken;
import com.ashishkhare.onlinestore.models.UserCart;
import com.ashishkhare.onlinestore.repositories.OrderRepository;
import com.ashishkhare.onlinestore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(method=RequestMethod.POST, value="/checkout")
    public Object checkOut(@RequestBody RequestToken requestToken){
        final List<Integer> productIds = new ArrayList<>();
        Integer userId = requestToken.getUserId();
        if (userId == null || requestToken.getAccessToken() == null) {
            return "Kindly sign-in first";
        }
        Optional<UserCart> userCart = productService.getCart(userId);
        if (userCart.isPresent()){
            productIds.addAll(userCart.get().getProductIds());
            Orders order = new Orders(userId, "Pending", productIds);
            Orders savedOrder = orderRepository.save(order);
            return "Kindly proceed to payment for order id : " + savedOrder.getOrderId();
        } else {
            return "Add products to user cart first";
        }
    }

    @RequestMapping(method=RequestMethod.POST, value="/orderplaced")
    public Object placeOrder(@RequestBody RequestToken requestToken){
        Optional<Orders> savedOrder = orderRepository.findById(requestToken.getOrderId());
        if (savedOrder.isPresent()) {
            savedOrder.get().setPaymentStatus("Approved");
            orderRepository.save(savedOrder.get());
            productService.emptyCart(savedOrder.get().getUserId());
        }
        return savedOrder;
    }
}
