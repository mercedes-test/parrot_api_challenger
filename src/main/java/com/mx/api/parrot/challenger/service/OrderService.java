package com.mx.api.parrot.challenger.service;

import com.mx.api.parrot.challenger.exception.ApiParrotException;
import com.mx.api.parrot.challenger.model.dto.request.OrderRequest;
import com.mx.api.parrot.challenger.model.dto.response.OrderResponseDTO;


public interface OrderService {

    OrderResponseDTO addOrder(OrderRequest ordeRequest, String username) throws ApiParrotException;
}
