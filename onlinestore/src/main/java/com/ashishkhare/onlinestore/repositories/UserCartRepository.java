package com.ashishkhare.onlinestore.repositories;

import com.ashishkhare.onlinestore.models.UserCart;
import org.springframework.data.repository.CrudRepository;

public interface UserCartRepository extends CrudRepository<UserCart, Integer> {
}
