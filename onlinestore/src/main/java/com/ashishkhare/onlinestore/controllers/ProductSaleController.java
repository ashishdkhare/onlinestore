package com.ashishkhare.onlinestore.controllers;

import com.ashishkhare.onlinestore.models.Product;
import com.ashishkhare.onlinestore.models.UserCart;
import com.ashishkhare.onlinestore.services.AuthenticatorService;
import com.ashishkhare.onlinestore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductSaleController {

    @Autowired
    ProductService productService;
    @Autowired
    AuthenticatorService authenticatorService;

    @RequestMapping("/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping("/products/{id}")
    public Object getProduct(@PathVariable Integer id) {
        return productService.getProduct(id);
    }

    @RequestMapping(method=RequestMethod.POST, value="/products")
    public String addProducts(@RequestBody List<Product> products){
        products.forEach(product -> productService.addProduct(product));
        return "Added to store";
    }

    @RequestMapping(method=RequestMethod.POST, value="/add2cart")
    public String addToCart(@RequestBody UserCart userCart){
        if(!authenticatorService.authenticate(userCart.getUserId())){
            return "User authentication failed";
        }
        productService.addToCart(userCart);
        return "Added to cart";
    }

    @RequestMapping(method=RequestMethod.GET, value="/add2cart")
    public Object getCart(@RequestBody UserCart userCart){
        try {
            if(!authenticatorService.authenticate(userCart.getUserId())){
                return "User authentication failed";
            }
            return productService.getCart(userCart.getUserId());
        } catch (NullPointerException npe){
            return "Cart is empty";
        }
    }

}
