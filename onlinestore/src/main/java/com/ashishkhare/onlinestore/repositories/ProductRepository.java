package com.ashishkhare.onlinestore.repositories;

import com.ashishkhare.onlinestore.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
