package com.mx.api.parrot.challenger.repository;

import com.mx.api.parrot.challenger.model.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
}
