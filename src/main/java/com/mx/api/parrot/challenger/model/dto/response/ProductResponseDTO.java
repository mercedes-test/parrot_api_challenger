package com.mx.api.parrot.challenger.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDTO implements ResponseDTO{

    private String nameProduct;
    private Double unitPrice;
    private Integer quantity;
}
