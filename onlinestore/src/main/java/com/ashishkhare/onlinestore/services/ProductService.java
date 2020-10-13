package com.ashishkhare.onlinestore.services;

import com.ashishkhare.onlinestore.repositories.ProductRepository;
import com.ashishkhare.onlinestore.repositories.UserCartRepository;
import com.ashishkhare.onlinestore.models.Product;
import com.ashishkhare.onlinestore.models.UserCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserCartRepository userCartRepository;

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        productRepository.findAll().forEach(list::add);
        return list;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void addToCart(UserCart userCart) {
        Optional<UserCart> userOldCart = userCartRepository.findById(userCart.getUserId());
        if(userOldCart.isPresent()){
            userCart.getProductIds().addAll(userOldCart.get().getProductIds());
        }
        userCartRepository.save(userCart);
    }

    public Optional<UserCart> getCart(Integer id) {
        return userCartRepository.findById(id);
    }

    public void emptyCart(Integer id) {
        userCartRepository.deleteById(id);
    }

    public Object getProduct(Integer id) {
        try {
            return productRepository.findById(id).get();
        } catch (Exception e) {
            return "No element found";
        }
    }
}
