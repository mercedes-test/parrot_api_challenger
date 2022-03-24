package com.mx.api.parrot.challenger.service;


import com.mx.api.parrot.challenger.model.dto.request.ProductRequest;
import com.mx.api.parrot.challenger.model.entity.ProductEntity;
import com.mx.api.parrot.challenger.model.entity.ProductListEntity;

import java.util.List;

public interface ProductService {

    List<ProductEntity> createProduct(List<ProductRequest> products, ProductListEntity productListEntity);
}
