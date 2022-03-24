package com.mx.api.parrot.challenger.repository;

import com.mx.api.parrot.challenger.model.entity.ProductListEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductListRepository extends CrudRepository<ProductListEntity, Integer>{

    Optional<ProductListEntity> findProductListById(@Param("id") Integer id);


}
