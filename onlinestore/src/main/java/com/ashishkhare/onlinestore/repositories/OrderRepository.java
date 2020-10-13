package com.ashishkhare.onlinestore.repositories;

import com.ashishkhare.onlinestore.models.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders, Integer> {
}
