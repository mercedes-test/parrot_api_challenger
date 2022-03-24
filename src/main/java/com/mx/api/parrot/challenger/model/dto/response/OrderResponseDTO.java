package com.mx.api.parrot.challenger.model.dto.response;

import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Generated
@Getter
@Setter
@Builder
public class OrderResponseDTO implements ResponseDTO{
    private int orderNumber;
    private String nameClient;
    private Double totalPrice;
    private List<ProductResponseDTO> products;
}
