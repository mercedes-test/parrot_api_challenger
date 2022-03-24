package com.mx.api.parrot.challenger.service;

import com.mx.api.parrot.challenger.exception.ApiParrotException;
import com.mx.api.parrot.challenger.model.entity.ProductListEntity;

public interface ProductListService {

    ProductListEntity createProductList(String username) throws ApiParrotException;
}
