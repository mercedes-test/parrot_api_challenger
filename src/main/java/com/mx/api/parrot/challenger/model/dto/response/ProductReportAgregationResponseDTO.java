package com.mx.api.parrot.challenger.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductReportAgregationResponseDTO implements ResponseDTO{

    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("totalQuantity")
    private Long totalQuantity;
    @JsonProperty("priceTotal")
    private Double priceTotal;
}
